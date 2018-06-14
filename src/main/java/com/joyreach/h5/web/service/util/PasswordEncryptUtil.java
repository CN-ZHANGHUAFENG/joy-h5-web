package com.joyreach.h5.web.service.util;

import edu.hziee.cap.common.util.Md5Utils;

/**
 * 
 * @author yunfu.wang
 * @version $ PasswordEncryptUtil 2014-9-23 上午10:45:06 $
 */
public class PasswordEncryptUtil {

  private static String encryptKey = "^$s1y%2~2,m8"; // j29&@^Y

  /**
   * 大推平台账号密码加密
   * 
   * @param userName
   * @param password
   * @return
   */
  public static String encryptPassword(String userName, String password) {
    return Md5Utils.getMd5(userName + password + encryptKey);
  }

  /**
   * 大推平台账号密码加密
   * 
   * @param userName
   * @param password
   * @return
   */
  public static String encryptPassword(String encryptStr) {
    return Md5Utils.getMd5(encryptStr);
  }

  public void setEncryptKey(String encryptKey) {
    PasswordEncryptUtil.encryptKey = encryptKey;
  }

  public static String getEncryptKey() {
    return encryptKey;
  }

  public static void main(String[] args) {
    System.out.println(PasswordEncryptUtil.encryptPassword("hui.chen@joyreach.com", "123456"));
  }
}
