package com.joyreach.h5.web.enumeration;

public enum BookTypeEnum {
  LY(1, "灵异"),
  QC(2, "青春"),
  CY(3, "穿越"),
  KH(4, "科幻"),
  LS(4, "历史"),
  XY(6, "悬疑"),
  JJ(7, "竞技"),
  XX(8, "仙侠"),
  SH(9, "生活"),
  YQ(10, "言情"),
  DS(11, "都市"),
  GY(12, "古言"),
  WX(13, "武侠"),
  YM(14, "幽默"),
  XH(15, "玄幻"),
  JS(16, "军事"),
  YX(17, "游戏"),
  QH(18, "奇幻");

  private int    type;

  private String desc;

  private BookTypeEnum(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public static Integer getTypeByDesc(String desc) {
    for (BookTypeEnum e : BookTypeEnum.values()) {
      if (desc.trim().equals(e.desc)) {
        return e.type;
      }
    }
    return null;
  }

  public static String getDescByType(int type) {
    for (BookTypeEnum e : BookTypeEnum.values()) {
      if (type == e.type) {
        return e.desc;
      }
    }
    return null;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

}
