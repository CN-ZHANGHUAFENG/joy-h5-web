package com.joyreach.h5.web.service;

import java.util.List;

import com.joyreach.h5.web.entity.BookChapterEntity;
import com.joyreach.h5.web.entity.VipBookEntity;
import com.joyreach.h5.web.query.VipBookInfoQuery;

import edu.hziee.common.lang.Paginator;

public interface IVipBookService {

  List<VipBookEntity> getAllVipBookList(VipBookInfoQuery query, Paginator paginator);

  List<VipBookEntity> searchBookInfo(VipBookInfoQuery query);

  BookChapterEntity getBookNewestChapter(VipBookInfoQuery query);

  List<BookChapterEntity> getBookCatalogPage(VipBookInfoQuery query, Paginator paginator);

  BookChapterEntity getBookNextChapter(VipBookInfoQuery query);

  BookChapterEntity getBookLastChapter(VipBookInfoQuery query);

  BookChapterEntity getBookChaterEntity(VipBookInfoQuery query);
}
