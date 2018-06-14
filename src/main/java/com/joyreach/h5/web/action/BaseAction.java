package com.joyreach.h5.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.hziee.common.lang.Paginator;

/**
 * 
 * 
 * @author yunfu.wang
 * @version $ BaseAction 2014-9-15 下午8:46:03 $
 */
@Controller
public class BaseAction {

  private Logger              logger      = LoggerFactory.getLogger(BaseAction.class);

  private String              errorMessage;

  private Paginator           paginator;

  private int                 itemPerPage = 20;

  private int                 currentPage = 1;

  private long                contentLength;

  private InputStream         inputStream;

  private String              filename;

  private HttpServletRequest  request;

  private HttpServletResponse response;

  private HttpSession         session;

  public void downloadExcel(String fileName, byte[] byteArray) {
    if (byteArray.length <= 0) {
      logger.warn(">>>> Export data file starting.But the data file is not have content.");
      return;
    }

    try {
      HttpServletResponse httpServletResponse = this.getResponse();
      httpServletResponse.setContentType("application/x-excel");
      httpServletResponse.setCharacterEncoding("UTF-8");
      httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
      httpServletResponse.setHeader("Content-Length", String.valueOf(byteArray.length));
      InputStream in = new BufferedInputStream(new ByteArrayInputStream(byteArray));
      OutputStream out = new BufferedOutputStream(httpServletResponse.getOutputStream());
      byte[] data = new byte[1024];
      int len = 0;
      while (-1 != (len = in.read(data, 0, data.length))) {
        out.write(data, 0, len);
      }
      out.flush();
      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(">>>> Export data file is failed! fileName=[{}]", new Object[] { fileName });
    }
  }

  @ModelAttribute
  public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {

    this.request = request;
    this.response = response;
    this.session = request.getSession(true);
    if (StringUtils.isNotBlank(request.getParameter("itemPerPage"))) {
      itemPerPage = Integer.parseInt(request.getParameter("itemPerPage"));
    }
    if (StringUtils.isNotBlank(request.getParameter("currentPage"))) {
      currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }
    int totalCount = 0;
    if (StringUtils.isNotBlank(request.getParameter("totalCount"))) {
      totalCount = Integer.parseInt(request.getParameter("totalCount"));
    }
    paginator = new Paginator();
    paginator.setItems(totalCount);
    paginator.setItemsPerPage(itemPerPage);
    paginator.setPage(currentPage - 1);
  }

  public Map<String, Object> converMVCReturnMap(String[] keys, Object[] values) {

    Map<String, Object> map = new HashMap<String, Object>();
    try {
      if (keys != null && values != null) {
        if (keys.length > 0 && values.length > 0) {
          for (int index = 0; index < keys.length; index++) {
            map.put(keys[index], values[index]);
          }
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      logger.error(e.getMessage(), e);
      logger.error("conver spring mvc return map is error. The number of keys not equal to the number of values.");
    }
    return map;
  }

  @SuppressWarnings("rawtypes")
  public Map<String, Object> converMVCReturnMap(Object obj) {

    Map<String, Object> map = new HashMap<String, Object>();

    try {
      Class objClass = obj.getClass();
      for (Field field : objClass.getDeclaredFields()) {
        String key = field.getName();
        field.setAccessible(true);
        Object value = field.get(obj);
        if (value != null) {
          if (value instanceof Integer || value instanceof Long || value instanceof Short) {
            map.put(key, String.valueOf(value));
          } else if (value instanceof Float) {
            Float num = (Float) value;
            DecimalFormat df = new DecimalFormat("#.##");
            map.put(key, df.format(num));
          } else if (value instanceof Double) {
            Double num = (Double) value;
            DecimalFormat df = new DecimalFormat("#.##");
            map.put(key, df.format(num));
          } else {
            map.put(key, value);
          }
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return new HashMap<String, Object>();
    }

    return map;
  }

  public HttpServletRequest getRequest() {
    return request;
  }

  public HttpServletResponse getResponse() {
    response.setContentType("text/html;charset=utf-8");
    return response;
  }

  public void exportExcel(byte[] bytes, String fileName) {
    response.reset();
    response.setContentType("application/vnd.ms-excel;charset=utf-8");
    OutputStream os = null;
    try {
      response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
      os = response.getOutputStream();
      os.write(bytes);
      os.flush();
    } catch (Exception e) {
      throw new RuntimeException("==>>>export excel is throw exception,userName=" + this.getUserName() + ",fileName=" + fileName);
    } finally {
      try {
        os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public HttpSession getSession() {
    return session;
  }

  public void sendResponse(String message) {
    try {
      HttpServletResponse response = getResponse();
      response.getWriter().write(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getUserName() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || auth.getPrincipal() == null) {
      return null;
    }

    return ((UserDetails) auth.getPrincipal()).getUsername();
  }

  public String getPageHtml(int totalCount) {

    if (totalCount <= 0) {
      return "";
    }

    String path = request.getRequestURI();

    return getPageHtml(totalCount, path);
  }

  public String getPageHtml(int totalCount, String path) {

    if (totalCount <= 0) {
      return "";
    }

    paginator.setItems(totalCount);

    StringBuffer sb = new StringBuffer();

    sb.append("<div class=\"pagelist\"><ul>");
    if (getCurrentPage() == 1) {
      sb.append("<li class=\"cancelCursor\">首页</li>");
    } else {
      sb.append("<li onclick=\"pageLinkClick(this,'" + path + "','1','" + getItemPerPage() + "','" + totalCount + "');\" >首页</li>");
    }
    if (getCurrentPage() > 1) {
      sb.append("<li onclick=\"pageLinkClick(this,'" + path + "','" + (getCurrentPage() - 1) + "','" + getItemPerPage() + "','" + totalCount + "');\">上页</li>");
    } else {
      sb.append("<li class=\"cancelCursor\">上页</li>");
    }

    int start = 0;
    int end = 0;

    if (getCurrentPage() <= 4) {
      start = 1;
    } else {
      if (paginator.getPageCount() - getCurrentPage() < 2) {
        start = paginator.getPageCount() - 4;
      } else {
        start = getCurrentPage() - 2;
      }
    }

    end = paginator.getPageCount();
    if (end > start + 4) {
      end = start + 4;
    }

    for (int i = start; i <= end; i++) {
      if (i == getCurrentPage()) {
        sb.append("<li class=\"currentPage cancelCursor\" pageSize=\"" + getItemPerPage() + "\" currentPage=\"" + i + "\" totalCount=\"" + totalCount + "\">"
            + i + "</li>");
      } else {
        sb.append("<li onclick=\"pageLinkClick(this,'" + path + "','" + i + "','" + getItemPerPage() + "','" + totalCount + "');\">" + i + "</li>");
      }
    }

    if (getCurrentPage() == paginator.getPageCount() || paginator.getPageCount() == 0) {
      sb.append("<li class=\"cancelCursor\">下页</li>");
      sb.append("<li class=\"cancelCursor\">尾页</li>");
    } else {
      sb.append("<li onclick=\"pageLinkClick(this,'" + path + "','" + (getCurrentPage() + 1) + "','" + getItemPerPage() + "','" + totalCount + "');\">下页</li>");
      sb.append(
          "<li onclick=\"pageLinkClick(this,'" + path + "','" + paginator.getPageCount() + "','" + getItemPerPage() + "','" + totalCount + "');\">尾页</li>");
    }

    sb.append(
        "<li class=\"textInput\"><div><input type=\"text\" onkeyup=\"javascript:this.value=this.value.replace(/\\D/g,'');\" value=\"\" class=\"MInputTT W50\" /></div></li><li onclick=\"goPageLink(this,'"
            + path + "','" + getItemPerPage() + "','" + paginator.getPageCount() + "','" + totalCount + "');\">跳页</li>");

    sb.append("<li class=\"cancelCursor\">共" + paginator.getPageCount() + "页</li>");
    sb.append("<li class=\"cancelCursor\">共" + totalCount + "条记录</li>");
    sb.append("</ul></div>");

    return sb.toString();
  }

  public String getCatalogPageHtml(String path) {
    int pageSize = getItemPerPage();
    if (paginator.getItems() <= 0) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    // 上一页按钮
    sb.append("<div class='foot_catalog_sel'><div class='page_button");
    if (getCurrentPage() == 1) {
      sb.append(" cancel'");
    } else {
      sb.append("' onclick='getCatalogPage(" + (getCurrentPage() - 1) + ")'");
    }
    sb.append(">上一页</div>");

    sb.append("<span><select id='catalog_list_select'>");
    for (int i = 1; i <= paginator.getPageCount(); i++) {
      sb.append("<option value='" + i + "'");
      if (getCurrentPage() == i) {
        sb.append(" selected='selected'");
      }
      sb.append(">" + ((i - 1) * pageSize + 1) + "  -  " + (i * pageSize) + "</option>");
    }
    sb.append("</select></span>");

    // 下一页按钮
    sb.append("<div class='page_button");
    if (getCurrentPage() == paginator.getPageCount() || paginator.getPageCount() == 0) {
      sb.append(" cancel'");
    } else {
      sb.append("' onclick='getCatalogPage(" + (getCurrentPage() + 1) + ")'");
    }
    sb.append(">下一页</div>");

    sb.append("</div>");

    return sb.toString();
  }

  protected Map<String, Object> preMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    return map;
  }

  public String getRespJson(int errorCode, String errorMessage) {
    return "{\"result\":\"" + String.valueOf(errorCode) + "\",\"msg\": \"" + errorMessage + "\"}";
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public Paginator getPaginator() {
    return paginator;
  }

  public int getItemPerPage() {
    return itemPerPage;
  }

  public void setItemPerPage(int itemPerPage) {
    this.itemPerPage = itemPerPage;
    paginator.setItemsPerPage(itemPerPage);
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getTotalCount() {
    return paginator.getItems();
  }

  public long getContentLength() {
    return contentLength;
  }

  public void setContentLength(long contentLength) {
    this.contentLength = contentLength;
  }

  public InputStream getInputStream() {
    return inputStream;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

}
