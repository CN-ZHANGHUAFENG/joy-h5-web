package com.joyreach.h5.web.entity;

import com.google.gson.annotations.SerializedName;

public class PayHttpReqRespJson {

  @SerializedName("result_code")
  private Integer resultCode;

  @SerializedName("linkId")
  private String  linkId;

  @SerializedName("type")
  private Integer type;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getLinkId() {
    return linkId;
  }

  public void setLinkId(String linkId) {
    this.linkId = linkId;
  }

  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

}
