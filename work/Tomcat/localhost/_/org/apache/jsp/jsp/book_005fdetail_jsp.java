/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2018-06-01 08:39:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class book_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsp/common/head.jsp", Long.valueOf(1527755579009L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/common/common.css");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${readVerNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/common/reset.css");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${readVerNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/common/title.css");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${readVerNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common/common.js?v=6\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common/jr.js?v=2\"></script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html style=\"font-size: 50px;\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"-1\">\r\n");
      out.write("<meta content=\"yes\" name=\"apple-mobile-web-app-capable\">\r\n");
      out.write("<meta content=\"yes\" name=\"apple-touch-fullscreen\">\r\n");
      out.write("<meta content=\"black\" name=\"apple-mobile-web-app-status-bar-style\">\r\n");
      out.write("<meta content=\"telephone=no, email=no\" name=\"format-detection\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/classify.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/book_detail.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/common/novel_detail.css\"\r\n");
      out.write("\ttype=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<input type=\"hidden\" id=\"bookIdHide\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bookId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t<div class=\"head-parent\">\r\n");
      out.write("\t\t<div class=\"layout_header\">\r\n");
      out.write("\t\t\t<div class=\"layout_header_title\">\r\n");
      out.write("\t\t\t\t<div class=\"back_left\">\r\n");
      out.write("\t\t\t\t\t<img src=\"/images/more.png\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<span class=\"login_cont\">书籍详情</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"header_home\">\r\n");
      out.write("\t\t\t\t<img src=\"/images/zhuye.png\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"nd_content\">\r\n");
      out.write("\t\t<div class=\"nd_title fc\">\r\n");
      out.write("\t\t\t<div class=\"nd_title_imgbox fl\">\r\n");
      out.write("\t\t\t\t<img src=\"null\" class=\"book_detail_img\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"overflow: hidden; padding-left: .22rem;\">\r\n");
      out.write("\t\t\t\t<div class=\"nd_imgtext fl\">\r\n");
      out.write("\t\t\t\t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bookInfo.bookName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("\t\t\t\t\t<p class=\"book_detail_author\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bookInfo.author}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"book_detail_over\">\r\n");
      out.write("\t\t\t\t\t\t状态：<span> <!-- 已完结 -->\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"book_detail_type\">\r\n");
      out.write("\t\t\t\t\t\t分类：<span> <!-- 玄幻 -->\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"ndt_btn\">\r\n");
      out.write("\t\t\t<div class=\"btn_width kepp_reading\">继续阅读</div>\r\n");
      out.write("\t\t\t<div class=\"btn_width add_book\">加入书架</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"line_through\"></div>\r\n");
      out.write("\t\t<div class=\"content_validity\" id=\"div1\">\r\n");
      out.write("\t\t\t<h3>内容简介</h3>\r\n");
      out.write("\t\t\t<div class=\"introduce\">\r\n");
      out.write("\t\t\t\t<p id=\"real-desc\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bookInfo.briefContent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t<pre id=\"copy-desc\"></pre>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"read_more\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"line_through_two\"></div>\r\n");
      out.write("\t\t<div class=\"nd_list fc\">\r\n");
      out.write("\t\t\t<div class=\"fl\">\r\n");
      out.write("\t\t\t\t<span>目录</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"fr new_chapter\">\r\n");
      out.write("\t\t\t\t<span>最新章节</span> <span>超级长的章节名字</span> <em class=\"ndl_img\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"/resources/img/more@2x.png\" />\r\n");
      out.write("\t\t\t\t</em>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"line_through_thee\"></div>\r\n");
      out.write("\t\t<!--书评部分 start-->\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"con_nav\">\r\n");
      out.write("\t\t\t\t<div class=\"nav_left\">\r\n");
      out.write("\t\t\t\t\t<p>书评区</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"nav_right\">\r\n");
      out.write("\t\t\t\t\t<img src=\"/resources/img/comment@2x.png\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"review_listbox\"></div>\r\n");
      out.write("\t\t\t<div class=\"btn_more\">查看全部评论</div>\r\n");
      out.write("\t\t\t<div class=\"no_cont\" style=\"display: none;\">发布第一条评论吧</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--书评部分 end-->\r\n");
      out.write("\t\t<div class=\"nd_recommend\">\r\n");
      out.write("\t\t\t<div class=\"nd_recommend_title\">\r\n");
      out.write("\t\t\t\t<div class=\"shu\"></div>\r\n");
      out.write("\t\t\t\t<h4>你或许会喜欢</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"ndr_list fc\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--版权-->\r\n");
      out.write("\t\t<div class=\"copyright\">\r\n");
      out.write("\t\t\t<div class=\"copyright_left\">\r\n");
      out.write("\t\t\t\t<p class=\"copyright_info\">版权信息</p>\r\n");
      out.write("\t\t\t\t<p class=\"add_shift_time\">\r\n");
      out.write("\t\t\t\t\t<!-- 2017-06-08 -->\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p class=\"publisher\"></p>\r\n");
      out.write("\t\t\t\t<p class=\"copyright_foot\">版权所有.侵权必究</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"copyright_right\">\r\n");
      out.write("\t\t\t\t<!-- \t\t\t\t<p class=\"copyright_right_title\">微信公众号二维码</p> -->\r\n");
      out.write("\t\t\t\t<!-- \t\t\t\t<div class=\"copyright_right_qrcode\"> -->\r\n");
      out.write("\t\t\t\t<!-- \t\t\t\t\t<img src=\"/resources/img/qr_code.jpg\" alt=\"二维码\"> -->\r\n");
      out.write("\t\t\t\t<!-- \t\t\t\t</div> -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"show_three_seconds\" style=\"display: none;\"></div>\r\n");
      out.write("\t#include(\"/resources/common/footer.html\")\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar bookInfo;\r\n");
      out.write("\tvar catalogId;//正在阅读的章节号\r\n");
      out.write("\t/*通过地址栏的url拿到书籍的id值*/\r\n");
      out.write("\tvar bookId;\r\n");
      out.write("\tvar titleName;\r\n");
      out.write("\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tlocalStorage.removeItem(\"flagCat\");\r\n");
      out.write("\t\tbookId = $(\"#bookIdHide\").val();\r\n");
      out.write("\t\tinit();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tbindClick();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tflag = null;\r\n");
      out.write("\tfunction bindClick() {\r\n");
      out.write("\t\t$('.read_more').append(\r\n");
      out.write("\t\t\t\t\"展开<span><img src='/images/open@2x.png' /></span>\");\r\n");
      out.write("\t\tflag = 1;\r\n");
      out.write("\t\t$('.read_more')\r\n");
      out.write("\t\t\t\t.click(\r\n");
      out.write("\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\tif (flag == 1) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.introduce').height('auto');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.read_more').empty();\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.read_more')\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\"收起<span><img src='/images/retract@2x.png' /></span>\");\r\n");
      out.write("\t\t\t\t\t\t\t\tflag = 2;\r\n");
      out.write("\t\t\t\t\t\t\t} else if (flag == 2) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.introduce').height('1.2rem');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.read_more').empty();\r\n");
      out.write("\t\t\t\t\t\t\t\t$('.read_more')\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t.append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\"展开<span><img src='/images/open@2x.png' /></span>\");\r\n");
      out.write("\t\t\t\t\t\t\t\tflag = 1;\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
