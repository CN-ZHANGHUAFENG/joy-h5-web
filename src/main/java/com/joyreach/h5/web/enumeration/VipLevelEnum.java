package com.joyreach.h5.web.enumeration;

public enum VipLevelEnum {
  visitor(0,"游客"),primaryVip(1, "初级会员"), middleVip(2, "中级会员"), seniorVip(3, "高级会员");

  private int    type;

  private String desc;

  private VipLevelEnum(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public static String getDesc(int type) {
    for (VipLevelEnum ve : VipLevelEnum.values()) {
      if (ve.type == type) {
        return ve.desc;
      }
    }
    return null;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

}
