package com.joyreach.h5.web.entity;

import java.util.Date;

public class VipBookEntity {

  private int    id;

  private String bookName;

  private String author;

  private String briefContent;

  private int    type;

  private String imgUrl;

  private int    wordNumber;

  private int    vipLevel;

  private Date   createTime;

  public int getVipLevel() {
    return vipLevel;
  }

  public void setVipLevel(int vipLevel) {
    this.vipLevel = vipLevel;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getBriefContent() {
    return briefContent;
  }

  public void setBriefContent(String briefContent) {
    this.briefContent = briefContent;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public int getWordNumber() {
    return wordNumber;
  }

  public void setWordNumber(int wordNumber) {
    this.wordNumber = wordNumber;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

}
