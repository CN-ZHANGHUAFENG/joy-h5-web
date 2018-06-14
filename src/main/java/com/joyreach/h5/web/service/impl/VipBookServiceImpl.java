package com.joyreach.h5.web.service.impl;

import java.util.List;

import com.joyreach.h5.web.dao.IVipBookDAO;
import com.joyreach.h5.web.entity.BookChapterEntity;
import com.joyreach.h5.web.entity.VipBookEntity;
import com.joyreach.h5.web.query.VipBookInfoQuery;
import com.joyreach.h5.web.service.IVipBookService;

import edu.hziee.common.lang.Paginator;

public class VipBookServiceImpl implements IVipBookService {

  private IVipBookDAO vipBookDAO;

  @Override
  public List<VipBookEntity> getAllVipBookList(VipBookInfoQuery query, Paginator paginator) {
    return vipBookDAO.getAllVipBookList(query, paginator);
  }

  @Override
  public List<VipBookEntity> searchBookInfo(VipBookInfoQuery query) {
    return vipBookDAO.searchBookInfo(query);
  }

  @Override
  public BookChapterEntity getBookNewestChapter(VipBookInfoQuery query) {
    return vipBookDAO.getBookNewestChapter(query);
  }

  @Override
  public List<BookChapterEntity> getBookCatalogPage(VipBookInfoQuery query, Paginator paginator) {
    return vipBookDAO.getBookCatalogPage(query, paginator);
  }

  @Override
  public BookChapterEntity getBookLastChapter(VipBookInfoQuery query) {
    return vipBookDAO.getBookLastChapter(query);
  }

  @Override
  public BookChapterEntity getBookNextChapter(VipBookInfoQuery query) {
    return vipBookDAO.getBookNextChapter(query);
  }

  @Override
  public BookChapterEntity getBookChaterEntity(VipBookInfoQuery query) {
    return vipBookDAO.getBookChapterEntity(query);
  }

  public IVipBookDAO getVipBookDAO() {
    return vipBookDAO;
  }

  public void setVipBookDAO(IVipBookDAO vipBookDAO) {
    this.vipBookDAO = vipBookDAO;
  }

}
