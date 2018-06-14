package com.joyreach.h5.web.entity;

import java.util.Date;

public class BookChapterEntity {

  private int    chapterId;

  private int    bookId;

  private String chapterTitle;

  private String chapterContent;

  private Date   createTime;

  public int getChapterId() {
    return chapterId;
  }

  public void setChapterId(int chapterId) {
    this.chapterId = chapterId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getChapterTitle() {
    return chapterTitle;
  }

  public void setChapterTitle(String chapterTitle) {
    this.chapterTitle = chapterTitle;
  }

  public String getChapterContent() {
    return chapterContent;
  }

  public void setChapterContent(String chapterContent) {
    this.chapterContent = chapterContent;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

}
