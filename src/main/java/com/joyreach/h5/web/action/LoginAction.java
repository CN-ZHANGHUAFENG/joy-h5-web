package com.joyreach.h5.web.action;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.joyreach.h5.web.common.CacheKey;
import com.joyreach.h5.web.entity.UserEntity;
import com.joyreach.h5.web.query.UserInfoQuery;
import com.joyreach.h5.web.service.IUserService;
import com.joyreach.h5.web.service.util.PasswordEncryptUtil;

@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginAction extends BaseAction {
//  验证码缓存redis,暂时不用
//  @Resource(name = "h5VerifyCodeRedisTemplate")
  private RedisTemplate<String, String> h5VerifyCodeRedisTemplate;

  @Resource(name = "userService")
  private IUserService                  userServiceImpl;

  @RequestMapping("loginHome.do")
  public ModelAndView loginPage() {
    Map<String, Object> map = preMap();
    return new ModelAndView("/login", map);
  }

  @RequestMapping("login.do")
  public void login(UserInfoQuery query) {
    UserEntity user = userServiceImpl.getUserInfo(query);
    if (user == null || !user.getPassword().equals(PasswordEncryptUtil.encryptPassword(query.getPhone(), query.getPassword()))) {
      this.sendResponse("{\"result\":\"fail\"}");
      return;
    } else {
      userServiceImpl.updateUserTokenInfo(user);
    }
    this.sendResponse("{\"result\":\"success\",\"message\":\"\",\"token\":\"" + user.getId() + "_" + user.getToken() + "\"}");
  }

  @RequestMapping("/login/registerPage.do")
  public ModelAndView toRedirectRegisterPage() {
    Map<String, Object> map = preMap();
    return new ModelAndView("/register", map);
  }

  @RequestMapping("/login/register.do")
  public void toRegister(UserInfoQuery query) {
    UserEntity user = userServiceImpl.getUserInfo(query);
    if (user != null) {
      this.sendResponse("{\"result\":\"fail\"}");
      return;
    }
    user = new UserEntity();
    user.setPhone(query.getPhone());
    user.setPassword(PasswordEncryptUtil.encryptPassword(query.getPhone(), query.getPassword()));
    user.setVipLevel(0);
    userServiceImpl.insertUserInfo(user);
    userServiceImpl.inserUserTokenInfo(user);
    this.sendResponse("{\"result\":\"success\",\"message\":\"\",\"token\":\"" + user.getId() + "_" + user.getToken() + "\"}");
  }

  @RequestMapping("login/ajax/getVerifyCode.do")
  public void sendVerifyCodeToPhone(UserEntity user) {
    String verifyCode = Double.toString(Math.random()).substring(2, 8);
    String cacheKey = CacheKey.getVerifyCodeCachaKey(user.getPhone());
    ValueOperations<String, String> valueOperations = h5VerifyCodeRedisTemplate.opsForValue();
    valueOperations.set(cacheKey, verifyCode, 5, TimeUnit.MINUTES);
    System.out.println(cacheKey + "-" + verifyCode);
    // 发送短信验证码
    // SmsSendInfo.sendSms("15757161434", verifyCode);
  }

  @RequestMapping("/ajax/check.do")
  public void checkIsLogined(String checkKey) {
    if (StringUtils.isBlank(checkKey)) {
      this.sendResponse("{\"result\":\"-1\"}");
      return;
    }
    String strArr[] = checkKey.split("_");
    UserInfoQuery query = new UserInfoQuery();
    query.setPhone(strArr[0]);
    query.setUserId(strArr[1]);
    UserEntity entity = userServiceImpl.getUserInfo(query);
    if (strArr == null || strArr.length < 3 || entity == null || !strArr[2].equals(entity.getToken())) {
      this.sendResponse("{\"result\":\"-1\"}");
      return;
    }
    this.sendResponse("{\"result\":\"success\"}");
  }

}
