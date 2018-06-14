package com.joyreach.h5.web.dao.impl;

import java.util.List;

import com.joyreach.h5.web.dao.IVipBookDAO;
import com.joyreach.h5.web.entity.BookChapterEntity;
import com.joyreach.h5.web.entity.VipBookEntity;
import com.joyreach.h5.web.query.VipBookInfoQuery;

import edu.hziee.common.dbroute.BaseDAO;
import edu.hziee.common.lang.Paginator;

@SuppressWarnings("unchecked")
public class VipBookDAOImpl extends BaseDAO implements IVipBookDAO {

  @Override
  public List<VipBookEntity> getAllVipBookList(VipBookInfoQuery query, Paginator paginator) {
    return super.queryForPagedList("H5_VIP_BOOK.SELECT_VIP_BOOK_LIST_COUNT", "H5_VIP_BOOK.SELECT_VIP_BOOK_LIST_PAGE", query, paginator);
  }

  @Override
  public List<VipBookEntity> searchBookInfo(VipBookInfoQuery query) {
    return super.queryForList("H5_VIP_BOOK.SELECT_VIP_BOOK_BY_SEARCH_QUERY", query);
  }

  @Override
  public BookChapterEntity getBookNewestChapter(VipBookInfoQuery query) {
    return (BookChapterEntity) super.queryForObject("H5_VIP_BOOK.SELELCT_BOOK_NEWEST_CHAPTER", query);
  }

  @Override
  public List<BookChapterEntity> getBookCatalogPage(VipBookInfoQuery query, Paginator paginator) {
    return super.queryForPagedList("H5_VIP_BOOK.SELECT_BOOK_CATALOG_COUNT", "H5_VIP_BOOK.SELECT_BOOK_CATALOG_PAGE", query, paginator);
  }

  @Override
  public BookChapterEntity getBookLastChapter(VipBookInfoQuery query) {
    return (BookChapterEntity) super.queryForObject("H5_VIP_BOOK.SELELCT_BOOK_LAST_CHAPTER", query);
  }

  @Override
  public BookChapterEntity getBookNextChapter(VipBookInfoQuery query) {
    return (BookChapterEntity) super.queryForObject("H5_VIP_BOOK.SELELCT_BOOK_NEXT_CHAPTER", query);
  }

  @Override
  public BookChapterEntity getBookChapterEntity(VipBookInfoQuery query) {
    return (BookChapterEntity) super.queryForObject("H5_VIP_BOOK.SELELCT_BOOK_CHAPTER_ENTITY", query);
  }

}
