package com.joyreach.h5.web.action;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.joyreach.h5.web.entity.PayHttpReqRespJson;
import com.joyreach.h5.web.enumeration.VipLevelEnum;
import com.joyreach.h5.web.service.IUserService;
import com.joyreach.h5.web.service.util.IpUtils;

import edu.hziee.cap.common.util.Md5Utils;

@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PayAction extends BaseAction {

  private final static Logger logger              = LoggerFactory.getLogger(PayAction.class);

  @Resource(name = "userService")
  private IUserService        userService;

  // http://ydpayreq.i9188.net:8500/spApi/monthLtYdApiReq.do
  private final static String reqVerifyCodeUrl    = "http://localhost:8088/monthLtYdApiReq.do";

  private final static String apiAuthKey          = "3b5ffeb8036b4dbcaea441e8d2e5d566";

  // http://ydpayreq.i9188.net:8500/spApi/submitConfirm.do
  private final static String submitVerifyCodeUrl = "http://127.0.0.1:8088/submitConfirm.do";

  private final static String cp_id               = "10000";

  private final static int    timeOutSeconds      = 10;

  @RequestMapping("/pay/reqVerifyCode.do")
  public void sendApi(String phone, Integer type) {
    if (StringUtils.isBlank(phone) || type == null) {
      this.sendResponse("{\"result_code\":\"" + -1 + "\"}");
      return;
    }
    String imsi = "460013574274037";
    String imei = "865528022060664";
    String client_ip = IpUtils.getIpAddress(this.getRequest());
    Integer price = (type + 1) * 500;
    String app_name = "联通阅读h5";
    String pay_code_name = "联通阅读" + VipLevelEnum.getDesc(type);
    String cp_channel_id = "h5";
    String sign = cp_id + imsi + imei + client_ip + phone + price + pay_code_name + app_name + cp_channel_id + apiAuthKey;
    sign = Md5Utils.getMd5(sign);
    try {
      app_name = URLEncoder.encode(app_name, "UTF-8");
      pay_code_name = URLEncoder.encode(pay_code_name, "UTF-8");
    } catch (Exception e) {
      logger.error("==>>encode content by URLEncoder has an error.");
    }
    String reqParams = "?cp_id=" + cp_id + "&imsi=" + imsi + "&imei=" + imei + "&client_ip=" + client_ip + "&price=" + price + "&app_name=" + app_name
        + "&pay_code_name=" + pay_code_name + "&cp_channel_id=" + cp_channel_id + "&phone=" + phone + "&sign=" + sign;
    // if (true) {
    // this.sendResponse("{\"result_code\":\"" + 1 + "\",\"linkId\":\"" +
    // 12321321 + "\",\"type\":\"" + type + "\"}");
    // return;
    // }
    PayHttpReqRespJson payHttpReqRespJson = sendHttp(reqVerifyCodeUrl + reqParams);
    if (payHttpReqRespJson == null) {
      this.sendResponse("{\"result_code\":\"" + -1 + "\"}");
      return;
    }
    this.sendResponse("{\"result_code\":\"" + payHttpReqRespJson.getResultCode() + "\",\"linkId\":\"" + payHttpReqRespJson.getLinkId() + "\",\"type\":\""
        + payHttpReqRespJson.getType() + "\"}");
  }

  @RequestMapping("/pay/submitVerifyCode.do")
  public void submit(String verifyCode, String linkId, Integer type, String cacheKey) {
    if (StringUtils.isBlank(verifyCode) || StringUtils.isBlank(linkId) || StringUtils.isBlank(cacheKey) || type == null) {
      this.sendResponse("{\"result_code\":\"" + -1 + "\"}");
      return;
    }
    String reqParams = "?cp_id=" + cp_id + "&order_id=" + linkId + "&verify_code=" + verifyCode;
    PayHttpReqRespJson payHttpReqRespJson = sendHttp(submitVerifyCodeUrl + reqParams);
    // PayHttpReqRespJson payHttpReqRespJson = new PayHttpReqRespJson();
    // payHttpReqRespJson.setResultCode(0);
    if (payHttpReqRespJson == null) {
      this.sendResponse("{\"result_code\":\"" + -1 + "\"}");
      return;
    }
    if (payHttpReqRespJson.getResultCode() == 0) {
      userService.improveUserVipLevel(cacheKey.split("_")[1], type);
    }
    this.sendResponse("{\"result_code\":\"" + payHttpReqRespJson.getResultCode() + "\"}");
  }

  private PayHttpReqRespJson sendHttp(String getUrl) {
    HttpClient client = new DefaultHttpClient();
    client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeOutSeconds * 1000);
    client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeOutSeconds * 1000);
    HttpGet get = new HttpGet(getUrl);
    try {
      HttpResponse resp = client.execute(get);
      if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        String content = IOUtils.toString(resp.getEntity().getContent(), "UTF-8");
        PayHttpReqRespJson httpReqRespJson = new Gson().fromJson(content, PayHttpReqRespJson.class);
        return httpReqRespJson;
      }
    } catch (ClientProtocolException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    logger.warn("==>>Fail to send http req,the http url = {}", getUrl);

    return null;
  }

  public IUserService getUserService() {
    return userService;
  }

  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

}
