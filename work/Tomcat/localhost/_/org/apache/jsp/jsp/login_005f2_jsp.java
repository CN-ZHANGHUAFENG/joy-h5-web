/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2018-06-08 02:25:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsp/common/head.jsp", Long.valueOf(1528364189724L));
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
      out.write("\t\t\t\t\t\tlocation.href = '/index.do';\r\n");
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
      out.write("<link rel=\"stylesheet\" href=\"/css/login.css\" type=\"text/css\" />\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"head-parent\">\r\n");
      out.write("\t\t<div class=\"layout_header\">\r\n");
      out.write("\t\t\t<div class=\"layout_header_title\">\r\n");
      out.write("\t\t\t\t<div class=\"back_left\" onclick=\"goBack()\">\r\n");
      out.write("\t\t\t\t\t<img src=\"/images/more.png\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<span class=\"login_cont\">登录</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"header_home\" onclick=\"toIndexJsp()\">\r\n");
      out.write("\t\t\t\t<img src=\"/images/zhuye.png\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t<div class=\"refresh\">\r\n");
      out.write("\t\t<div class=\"refresh_img\">\r\n");
      out.write("\t\t\t<img class=\"needRotate\" src=\"/resources/img/refresh.png\" alt=\"\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"refresh_jump\">页面正在跳转中</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"login_from\">\r\n");
      out.write("\t\t\t<div class=\"user_pass\">\r\n");
      out.write("\t\t\t\t<!--输入用户名-->\r\n");
      out.write("\t\t\t\t<div class=\"uinfo_input\">\r\n");
      out.write("\t\t\t\t\t<div class=\"uinfo_img\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/images/dengl.png\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"phone\" id=\"phone\" placeholder=\"手机号\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"20\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--输入密码-->\r\n");
      out.write("\t\t\t\t<div class=\"uinfo_input\">\r\n");
      out.write("\t\t\t\t\t<div class=\"uinfo_img\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/images/suo.png\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"password\" id=\"pwdId\" placeholder=\"密码\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"20\" />\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<div class=\"x_or_d\" onclick=\"changeShow();\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/resources/img/yanjing-b.png\" class=\"changeImg\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--Ajax无刷新异步获取用户 -- 判断输入的手机号是否注册-->\r\n");
      out.write("\t\t\t<div class=\"getMessage\">\r\n");
      out.write("\t\t\t\t<div style='overflow: hidden; display: none;'\r\n");
      out.write("\t\t\t\t\tclass=\"getMessage_show\">\r\n");
      out.write("\t\t\t\t\t<div class=\"sj_notinput\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/resources/img/tishi.png\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<span> <!-- 手机号未注册 -->\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--登录按钮-->\r\n");
      out.write("\t\t\t<div class=\"user_login fix\" onclick=\"login();\">登录</div>\r\n");
      out.write("\t\t\t<div class=\"register_forget\">\r\n");
      out.write("\t\t\t\t<p class=\"register_user\">\r\n");
      out.write("\t\t\t\t\t<a>立即注册</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t<p class=\"forget_pass\">\r\n");
      out.write("\t\t\t\t\t<a>忘记密码</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--更多登录方式-->\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(\r\n");
      out.write("\t\t\tfunction() {\r\n");
      out.write("\t\t\t\tif (navigator.cookieEnabled == false) {\r\n");
      out.write("\t\t\t\t\t$.message.alert('warn', '警告信息',\r\n");
      out.write("\t\t\t\t\t\t\t'您的浏览器禁用了cookie，将无法正常完成登录，请开启cookie功能！');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tforIE6();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction login() {\r\n");
      out.write("\t\tphone = $('#phoneId').val();\r\n");
      out.write("\t\tpwd = $('#pwdId').val();\r\n");
      out.write("\t\tif (phone === '') {\r\n");
      out.write("\t\t\t$.message.alert('info', '提示信息', '请输入手机号！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (pwd === '') {\r\n");
      out.write("\t\t\t$.message.alert('info', '提示信息', '请输入密码！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"/login.do\",\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tphone : phone,\r\n");
      out.write("\t\t\t\tpassword : pwd\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tob = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tif (ob.result == 'success') {\r\n");
      out.write("\t\t\t\t\tlocalStorage.usrFlag = phone + '_' + ob.token;\r\n");
      out.write("\t\t\t\t\tlocation.href = \"/index.do\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.message.alert(\"info\", \"提示\", \"验证码错误！\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(e) {\r\n");
      out.write("\t\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction clickAButton() {\r\n");
      out.write("\t\twaitTime = 60;\r\n");
      out.write("\t\t//手机号校验\r\n");
      out.write("\t\tif (!toGetVerifyCode()) {\r\n");
      out.write("\t\t\t$.message.alert('info', '提示信息', '手机号有误！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//点击按钮置灰\r\n");
      out.write("\t\tchangeVerifyADiv();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction changeVerifyADiv() {\r\n");
      out.write("\t\taDiv = $('#sendCodeId');\r\n");
      out.write("\t\tif (waitTime > 0) {\r\n");
      out.write("\t\t\twaitTime--;\r\n");
      out.write("\t\t\taDiv.removeAttr(\"onclick\");\r\n");
      out.write("\t\t\taDiv.addClass(\"click_a\");\r\n");
      out.write("\t\t\taDiv.html('剩余' + waitTime + '秒');\r\n");
      out.write("\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\tchangeVerifyADiv();\r\n");
      out.write("\t\t\t}, 1000);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\taDiv.removeClass(\"click_a\");\r\n");
      out.write("\t\t\taDiv.click(changeVerifyADiv);\r\n");
      out.write("\t\t\taDiv.empty();\r\n");
      out.write("\t\t\taDiv.append(\"发送短信验证码\");\r\n");
      out.write("\t\t\twaitTime = 60;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction toGetVerifyCode() {\r\n");
      out.write("\t\tvar phone = $('#phoneId').val();\r\n");
      out.write("\t\tvar reg = /^1[0-9]{10}$/;\r\n");
      out.write("\t\tif (!phone || '' === phone || !reg.test(phone)) {\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : '/login/ajax/getVerifyCode.do',\r\n");
      out.write("\t\t\ttype : 'get',\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tphone : phone\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(e) {\r\n");
      out.write("\t\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\treturn true;\r\n");
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
