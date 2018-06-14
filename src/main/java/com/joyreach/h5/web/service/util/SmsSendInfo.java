package com.joyreach.h5.web.service.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.joyreach.h5.web.entity.SmsResultJson;

/**
 * @author kun.zheng
 * @date 2016-2-26 下午5:47:34
 */
public class SmsSendInfo {

  private static String url = "http://api.ict-china.com/do/smsApi!mt.shtml";

  public SmsSendInfo() {

  }

  public static Boolean sendSms(String mobile, String verifyCode) {
    String cpmid = mobile+"_"+verifyCode;
    String message = "本次登录的验证码："+verifyCode+",验证码5分钟内有效";
    HttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(url);
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version='1.0' encoding='UTF-8'?>");
    sb.append("<mtpacket>");
    sb.append("<cpid>4017</cpid>");
    sb.append("<userpass>5e57e6078732c4c6623f279753b9edbf</userpass>");
    sb.append("<port>05382</port>");
    sb.append("<cpmid>" + cpmid + "</cpmid>");
    sb.append("<flag>1</flag>");
    sb.append("<mobile><![CDATA[" + mobile + "]]></mobile>");
    sb.append("<message><![CDATA[" + message + "【杭州真趣】]]></message>");
    sb.append("<respDataType>JSON</respDataType>");
    sb.append("</mtpacket>");

    try {
      httpPost.setEntity(new StringEntity(sb.toString(), "UTF-8"));
      HttpResponse httpRespones = httpClient.execute(httpPost);
      HttpEntity entity = httpRespones.getEntity();
      String httpValue = EntityUtils.toString(entity);
      if (entity != null) {
        EntityUtils.consume(entity);
      }

      Gson gson = new Gson();
      SmsResultJson smsResultJson = (SmsResultJson) gson.fromJson(httpValue, SmsResultJson.class);

      if (smsResultJson.getRespCode().equals("0")) {
        return true;
      }
    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    } finally {
      httpClient.getConnectionManager().shutdown();
    }
    return false;
  }

}
