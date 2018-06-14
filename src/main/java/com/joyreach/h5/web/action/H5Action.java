package com.joyreach.h5.web.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.joyreach.h5.web.entity.BookChapterEntity;
import com.joyreach.h5.web.entity.UserEntity;
import com.joyreach.h5.web.entity.VipBookEntity;
import com.joyreach.h5.web.enumeration.BookTypeEnum;
import com.joyreach.h5.web.enumeration.VipLevelEnum;
import com.joyreach.h5.web.query.UserInfoQuery;
import com.joyreach.h5.web.query.VipBookInfoQuery;
import com.joyreach.h5.web.service.IUserService;
import com.joyreach.h5.web.service.IVipBookService;

@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class H5Action extends BaseAction {

  @Autowired
  private IVipBookService vipBookService;

  @Resource(name = "userService")
  private IUserService    userServiceImpl;

  @RequestMapping(value = "/index.do", method = RequestMethod.GET)
  public ModelAndView index() {
    return new ModelAndView("index");
  }

  @RequestMapping(value = "/index/{tabId}.do", method = RequestMethod.GET)
  public ModelAndView home(@PathVariable String tabId) {
    Map<String, Object> valMap = preMap();
    valMap.put("tabId", tabId);
    return new ModelAndView("index", valMap);
  }

  @RequestMapping(value = "/index/ajax/books.do", method = RequestMethod.GET)
  public ModelAndView homeVipBooks(VipBookInfoQuery query) {
    if (query.getVipLevel() == null) {
      return null;
    }
    Map<String, Object> map = preMap();
    this.getPaginator().setItemsPerPage(10);
    List<VipBookEntity> bookEntities = vipBookService.getAllVipBookList(query, this.getPaginator());
    if (getCurrentPage() > getPaginator().getPageCount()) {
      return new ModelAndView("book/bookList", map);
    }
    map.put("bookEntities", bookEntities);
    map.put("totalCount", getPaginator().getItems());
    map.put("currentPage", getCurrentPage());
    return new ModelAndView("book/bookList", map);
  }

  @RequestMapping(value = "/index/ajax/bookInfo.do", method = RequestMethod.GET)
  public ModelAndView searchBookInfo(VipBookInfoQuery query) {
    List<VipBookEntity> bookEntities = vipBookService.searchBookInfo(query);
    Map<String, Object> map = preMap();
    map.put("bookEntities", bookEntities);
    map.put("currentPage", 1);
    return new ModelAndView("book/bookList", map);
  }

  @RequestMapping(value = "/book/detail.do")
  public ModelAndView getBookDetail(VipBookInfoQuery query) {
    Map<String, Object> map = preMap();
    List<VipBookEntity> bookEntities = vipBookService.searchBookInfo(query);
    BookChapterEntity bookChapterEntity = vipBookService.getBookNewestChapter(query);
    query.setChapterId(-1);
    BookChapterEntity bookFirstChapterEntity = vipBookService.getBookNextChapter(query);
    VipBookEntity vbe = bookEntities != null && bookEntities.size() > 0 ? bookEntities.get(0) : null;
    map.put("bookInfo", vbe);
    if (vbe != null) {
      map.put("type", BookTypeEnum.getDescByType(vbe.getType()));
    }
    map.put("firstChapter", bookFirstChapterEntity);
    map.put("newestChapter", bookChapterEntity);
    return new ModelAndView("book/book_detail", map);
  }

  @RequestMapping(value = "/book/catalog.do")
  public ModelAndView getBookCatalog(VipBookInfoQuery query) {
    List<BookChapterEntity> bookChapterEntities = vipBookService.getBookCatalogPage(query, this.getPaginator());
    Map<String, Object> map = preMap();
    String html = this.getCatalogPageHtml("/book/catalog.do");
    map.put("cIndex", this.getPaginator().getBeginIndex());
    map.put("bookChapterEntities", bookChapterEntities);
    map.put("html", html);
    map.put("itemPerPage", getItemPerPage());
    map.put("totalCount", this.getPaginator().getItems());
    return new ModelAndView("book/book_catalog", map);
  }

  @RequestMapping("/book/catalog/read.do")
  public ModelAndView getBookCatalogContent(VipBookInfoQuery query) {
    Map<String, Object> map = preMap();
    BookChapterEntity nextChapter = vipBookService.getBookNextChapter(query);
    BookChapterEntity lastChapter = vipBookService.getBookLastChapter(query);
    List<VipBookEntity> bookEntities = vipBookService.searchBookInfo(query);
    map.put("bookName", bookEntities.get(0).getBookName());
    map.put("last", lastChapter);
    map.put("next", nextChapter);
    map.put("chapterInfo", query);
    return new ModelAndView("book/catalog_read", map);
  }

  @RequestMapping("/book/catalog/ajax/content.do")
  public void ajaxGetContent(VipBookInfoQuery query) {
    BookChapterEntity chapter = vipBookService.getBookChaterEntity(query);
    chapter.setChapterContent(chapter.getChapterContent().replace("。", "。<br/>"));
    this.sendResponse(new Gson().toJson(chapter));
  }

  @RequestMapping("book/ajax/checkVipLevel.do")
  public void checVipLevel(Integer bookId, String checkKey) {
    VipBookInfoQuery query = new VipBookInfoQuery();
    query.setBookId(bookId);
    List<VipBookEntity> bookEntities = vipBookService.searchBookInfo(query);
    if (bookEntities == null || bookEntities.size() < 1) {
      this.sendResponse(this.getRespJson(-1, "此书籍不存在"));
      return;
    }
    UserInfoQuery uiQuery = new UserInfoQuery();
    uiQuery.setUserId(checkKey.split("_")[1]);
    UserEntity userEntity = userServiceImpl.getUserInfo(uiQuery);
    if (userEntity == null) {
      this.sendResponse(this.getRespJson(-1, "用户存在异常,请联系管理人员"));
      return;
    }
    if (bookEntities.get(0).getVipLevel() > userEntity.getVipLevel()) {
      String vipLevelDesc = VipLevelEnum.getDesc(bookEntities.get(0).getVipLevel());
      this.sendResponse(this.getRespJson(1, "该小说只有" + vipLevelDesc + "以上的用户可以阅读"));
      return;
    }
    this.sendResponse(this.getRespJson(0, "符合权限"));
  }

  @RequestMapping("/pay/payPage.do")
  public ModelAndView toEnterPayPage(String checkKey, Integer bookId) {
    Map<String, Object> map = preMap();

    UserInfoQuery uiQuery = new UserInfoQuery();
    uiQuery.setUserId(checkKey.split("_")[1]);
    UserEntity user = userServiceImpl.getUserInfo(uiQuery);
    map.put("locaLevel", user.getVipLevel());
    Integer type = null;
    if (bookId == null) {
      type = user.getVipLevel() + 1;
    } else {
      VipBookInfoQuery query = new VipBookInfoQuery();
      query.setBookId(bookId);
      List<VipBookEntity> bookEntities = vipBookService.searchBookInfo(query);
      type = bookEntities.get(0).getVipLevel();
    }

    map.put("orderVipType", type);
    map.put("vipEnum", VipLevelEnum.values());
    return new ModelAndView("/pay/payPage", map);
  }

  public IVipBookService getVipBookService() {
    return vipBookService;
  }

  public void setVipBookService(IVipBookService vipBookService) {
    this.vipBookService = vipBookService;
  }

}
