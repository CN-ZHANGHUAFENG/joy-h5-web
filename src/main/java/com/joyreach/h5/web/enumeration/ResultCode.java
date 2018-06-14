package com.joyreach.h5.web.enumeration;

public enum ResultCode {

  SUCCESS(1, "成功"), FAIL(-1, "失败");

  private int    result;

  private String msg;

  private ResultCode(int result, String msg) {
    this.result = result;
    this.msg = msg;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}
