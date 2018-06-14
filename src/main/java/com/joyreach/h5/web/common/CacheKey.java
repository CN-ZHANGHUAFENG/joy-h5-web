package com.joyreach.h5.web.common;

public class CacheKey {

  private static String H5_USER_VERIFY_CODE = "H5_USER_VERIFY_CODE";

  public static String getVerifyCodeCachaKey(String phone) {
    return H5_USER_VERIFY_CODE + "_" + phone;
  }
}
