/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2018-06-12 01:57:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class catalog_005fread_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsp/common/head.jsp", Long.valueOf(1528712144770L));
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
      out.write("<link rel=\"stylesheet\" href=\"/css/common/dialog.css");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${readVerNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery/jquery-1.4.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common/common.js?v=6\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common/jr.js?v=2\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction toIndexJsp() {\r\n");
      out.write("\t\tlocation.href = \"/index.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction goBack() {\r\n");
      out.write("\t\tlocation.href = \"javascript:history.go(-1);\"\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction forIE6() {\r\n");
      out.write("\t\tvar bar = getBow();\r\n");
      out.write("\t\tif (bar == 'IE6') {\r\n");
      out.write("\t\t\t$('#forIe6Div').dialog('open', {\r\n");
      out.write("\t\t\t\turl : 'jsp/updateIE.html',\r\n");
      out.write("\t\t\t\ttitle : '更新浏览器',\r\n");
      out.write("\t\t\t\tneedClose : false,\r\n");
      out.write("\t\t\t\twidth : '600',\r\n");
      out.write("\t\t\t\theight : '200'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkIsLogin(needInfo) {\r\n");
      out.write("\t\tusrFlag = localStorage.usrFlag;\r\n");
      out.write("\t\tisLogin = false;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : '/ajax/check.do',\r\n");
      out.write("\t\t\ttype : 'get',\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tcheckKey : usrFlag\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tob = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tif (ob.result == 'success') {\r\n");
      out.write("\t\t\t\t\tisLogin = true;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tif (!needInfo) {\r\n");
      out.write("\t\t\t\t\t\t$.message.alert(\"info\", \"提示\", \"用户未登录，将跳转至登录页\",\r\n");
      out.write("\t\t\t\t\t\t\t\tfunction(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlocation.href = \"/loginHome.do\";\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\tisLogin = false;\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tlocation.href = \"/loginHome.do\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(e) {\r\n");
      out.write("\t\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\treturn isLogin;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkVipLevel(bookId) {\r\n");
      out.write("\t\tusrFlag = localStorage.usrFlag;\r\n");
      out.write("\t\tconformToVip = false;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : '/book/ajax/checkVipLevel.do',\r\n");
      out.write("\t\t\ttype : 'post',\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tcheckKey : usrFlag,\r\n");
      out.write("\t\t\t\tbookId : bookId\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tob = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tif (ob.result == '0') {\r\n");
      out.write("\t\t\t\t\tconformToVip = true;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.message.alert('info', '提示', ob.msg, function() {\r\n");
      out.write("\t\t\t\t\t\tlocation.href = '/pay/payPage.do?checkKey='+usrFlag+'&bookId='+bookId;\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\tconformToVip = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(e) {\r\n");
      out.write("\t\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\treturn conformToVip;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"/css/book/catalog_read.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/common/novel_detail.css\"\r\n");
      out.write("\ttype=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"layout_header div_postion\">\r\n");
      out.write("\t\t<div class=\"layout_header_title\">\r\n");
      out.write("\t\t\t<div class=\"back_left\" onclick=\"goBack()\">\r\n");
      out.write("\t\t\t\t<img src=\"/images/more.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<span class=\"login_cont\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bookName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"header_home\" onclick=\"toIndexJsp()\">\r\n");
      out.write("\t\t\t<img src=\"/images/zhuye.png\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"chapter_title\" class=\"layout_header div_postion catalog_titel\"></div>\r\n");
      out.write("\t<div class=\"h5_novel_titel div_upOrdown\" style=\"margin-bottom: 0\">\r\n");
      out.write("\t\t<div class=\"div_button\"\r\n");
      out.write("\t\t\tonclick=\"toBookDetail('next','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${last.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("\t\t\t<span>上一页</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"div_button\" onclick=\"toBookDetail('home')\">\r\n");
      out.write("\t\t\t<span>首页</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"div_button\"\r\n");
      out.write("\t\t\tonclick=\"toBookDetail('next','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${next.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("\t\t\t<span>下一页</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"catalog_content backgroud_color\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<pre id=\"contentPre\" class=\"pre_content\"></pre>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"h5_novel_titel div_upOrdown\"\r\n");
      out.write("\t\tstyle=\"position: absolute; bottom: 0.2rem\">\r\n");
      out.write("\t\t<div class=\"div_button\"\r\n");
      out.write("\t\t\tonclick=\"toBookDetail('next','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${last.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("\t\t\t<span>上一页</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"div_button\" onclick=\"toBookDetail('home')\">\r\n");
      out.write("\t\t\t<span>首页</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"div_button\"\r\n");
      out.write("\t\t\tonclick=\"toBookDetail('next','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${next.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("\t\t\t<span>下一页</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tbookId = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chapterInfo.bookId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tinit();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction init(){\r\n");
      out.write("\t\tif(!checkIsLogin()){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(!checkVipLevel(bookId)){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"body\").css(\"min-height\",$(window).height());\r\n");
      out.write("\t\tloadContent();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction loadContent(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl:\"/book/catalog/ajax/content.do?chapterId=\"+");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chapterInfo.chapterId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("+\"&bookId=\"+bookId,\r\n");
      out.write("\t\t\ttype:\"GET\",\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tvar info = eval('('+data+')');\r\n");
      out.write("\t\t\t\t$('#contentPre').append(info.chapterContent);\r\n");
      out.write("\t\t\t\t$('#chapter_title').append(info.chapterTitle);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(){\r\n");
      out.write("\t\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction toBookDetail(buttonType,index){\r\n");
      out.write("\t\tif(buttonType === 'home'){\r\n");
      out.write("\t\t\tlocation.href=\"/book/detail.do?bookId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chapterInfo.bookId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif(index){\r\n");
      out.write("\t\t\t\tlocation.href=\"/book/catalog/read.do?chapterId=\"+index+\"&bookId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${chapterInfo.bookId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>");
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
