package com.joyreach.h5.web.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class GenerateIdUtils {

  public static int            baseNum          = 100000;

  public static int            maxNum           = 999999;

  private static AtomicInteger autoIncrementNum = new AtomicInteger(baseNum);

  public static int getAutoIncrementNum() {
    int value = autoIncrementNum.getAndIncrement();
    if (value == maxNum) {
      autoIncrementNum.set(baseNum);
    }
    return value;
  }
}
