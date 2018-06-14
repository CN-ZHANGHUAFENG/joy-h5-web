package com.joyreach.h5.web.service.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpUtils {

  private static Logger logger = LoggerFactory.getLogger(IpUtils.class);

  public static long ip2Long(String ip) throws Exception {
    if (StringUtils.isEmpty(ip)) {
      return 0L;
    }
    String[] digits = ip.split("\\.");
    long[] temp = (long[]) null;
    boolean invalid = true;

    if (digits.length == 4) {
      temp = new long[] { Long.parseLong(digits[0]), Long.parseLong(digits[1]), Long.parseLong(digits[2]), Long.parseLong(digits[3]) };

      invalid = (temp[0] <= 0L) || (temp[0] > 255L) || (temp[1] < 0L) || (temp[1] > 255L) || (temp[2] < 0L) || (temp[2] > 255L) || (temp[3] < 0L)
          || (temp[3] > 255L);
    }
    if (invalid) {
      if (logger.isErrorEnabled()) {
        logger.error("无效的IP地址 [" + ip + "].");
      }
      throw new Exception("无效的IP地址 [" + ip + "].");
    }

    temp[0] <<= 24;
    temp[1] <<= 16;
    temp[2] <<= 8;

    return temp[0] | temp[1] | temp[2] | temp[3];
  }

  public static boolean isValid(String ip) {
    String[] digits = ip.split("\\.");
    long[] temp = (long[]) null;

    boolean invalid = true;

    if (digits.length == 4) {
      temp = new long[] { Long.parseLong(digits[0]), Long.parseLong(digits[1]), Long.parseLong(digits[2]), Long.parseLong(digits[3]) };

      invalid = (temp[0] <= 0L) || (temp[0] > 255L) || (temp[1] < 0L) || (temp[1] > 255L) || (temp[2] < 0L) || (temp[2] > 255L) || (temp[3] < 0L)
          || (temp[3] > 255L);
    }
    if (invalid) {
      if (logger.isErrorEnabled()) {
        logger.error("无效的IP地址 [" + ip + "].");
      }
      return false;
    }

    return true;
  }

  public static String getIpAddress(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");
    if (logger.isDebugEnabled()) {
      logger.debug("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
        if (logger.isDebugEnabled()) {
          logger.debug("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
        }
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
        if (logger.isDebugEnabled()) {
          logger.debug("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
        }
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("HTTP_CLIENT_IP");
        if (logger.isDebugEnabled()) {
          logger.debug("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
        }
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (logger.isDebugEnabled()) {
          logger.debug("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
        }
      }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
        if (logger.isDebugEnabled()) {
          logger.debug("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
        }
      }
    } else if (ip.length() > 15) {
      String[] ips = ip.split(",");
      for (int index = 0; index < ips.length; index++) {
        String strIp = (String) ips[index];
        if (!("unknown".equalsIgnoreCase(strIp))) {
          ip = strIp;
          break;
        }
      }
    }
    return ip;
  }
}
