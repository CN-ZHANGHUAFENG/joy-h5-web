/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2018-06-13 03:15:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.pay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class payPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/c.tld", Long.valueOf(1527750698968L));
    _jspx_dependants.put("/jsp/common/head.jsp", Long.valueOf(1528712144770L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<link rel=\"stylesheet\" href=\"/css/pay/payPage.css\" type=\"text/css\" />\r\n");
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
      out.write("\t\t\t\t<span class=\"login_cont\">开通会员</span>\r\n");
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
      out.write("\t\t<div class=\"vip_ul_style\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vipType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"order_VIP_id\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"pay_pass\">\r\n");
      out.write("\t\t\t<!--输入用户名-->\r\n");
      out.write("\t\t\t<div class=\"pay_pass_inpit\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"phone\" id=\"phoneId\" placeholder=\"手机号\"\r\n");
      out.write("\t\t\t\t\tmaxlength=\"11\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--输入密码-->\r\n");
      out.write("\t\t\t<div class=\"pay_pass_inpit\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"verifyCode\" id=\"verifyCodeId\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"验证码\" maxlength=\"8\" style=\"width: 50%\" />\r\n");
      out.write("\t\t\t\t<div style=\"padding-top: 0.2rem; line-height: 0.38rem\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:void(0);\" onclick=\"clickAButton()\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"verify_code\">发送验证码</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<div class=\"x_or_d\" onclick=\"changeShow();\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/resources/img/yanjing-b.png\" class=\"changeImg\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"vip_order_message\">价格：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(type+1)*5}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("元</div>\r\n");
      out.write("\t\t<div class=\"button_div\" align=\"center\">\r\n");
      out.write("\t\t\t<div class=\"order_button\" onclick=\"orderVip()\">订购</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"vip_description\">\r\n");
      out.write("\t\t\t<span>注：购买VIP会员，可阅读该级别及低级会员书库中的小说。( 注: 部分书籍只供更高级别的会员阅读)</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t//checkIsLogin();\r\n");
      out.write("\t\tchooseVipLevel = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${orderVipType}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\tif(!chooseVipLevel){\r\n");
      out.write("\t\t\tchooseVipLevel = 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tchooseVip(chooseVipLevel);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tvar linkId = '';\r\n");
      out.write("\tvar chooseType = '';\r\n");
      out.write("\r\n");
      out.write("\tfunction orderVip() {\r\n");
      out.write("\t\tphone = $('#phoneId').val();\r\n");
      out.write("\t\tverifyCode = $('#verifyCodeId').val();\r\n");
      out.write("\t\tif (phone === '') {\r\n");
      out.write("\t\t\t$.message.alert('info', '提示信息', '手机号不能为空！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (verifyCode === '') {\r\n");
      out.write("\t\t\t$.message.alert('info', '提示信息', '请输入验证码！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"/pay/submitVerifyCode.do\",\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tlinkId : linkId,\r\n");
      out.write("\t\t\t\tverifyCode : verifyCode,\r\n");
      out.write("\t\t\t\ttype:chooseType,\r\n");
      out.write("\t\t\t\tcacheKey: localStorage.usrFlag\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tob = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tif (ob.result_code == '0') {\r\n");
      out.write("\t\t\t\t\t$.message.alert('info','提示','订购成功',function(){\r\n");
      out.write("\t\t\t\t\t\tlocation.href = \"/index.do\";\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.message.alert(\"info\", \"提示\", \"订购失败！\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(e) {\r\n");
      out.write("\t\t\t\tconsole.log(e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction chooseVip(type) {\r\n");
      out.write("\t\tlocaLevel = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${locaLevel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\tif (locaLevel >= type) {\r\n");
      out.write("\t\t\t$.message.alert(\"info\", \"提示\", \"无需订购低级会员\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdivName = 'div_vip_' + type;\r\n");
      out.write("\t\t$('#order_VIP_id').val(type);\r\n");
      out.write("\t\t$('li div').removeClass(\"selected_li\");\r\n");
      out.write("\t\t$('#' + divName).addClass(\"selected_li\");\r\n");
      out.write("\t\t$('.vip_order_message').empty();\r\n");
      out.write("\t\tprice = (new Number(type) + 1) * 5;\r\n");
      out.write("\t\t$('.vip_order_message').append(\"价格：\" + price + \"元\");\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction clickAButton() {\r\n");
      out.write("\t\twaitTime = 60;\r\n");
      out.write("\t\t//手机号校验\r\n");
      out.write("\t\tif (!toGetVerifyCode()) {\r\n");
      out.write("\t\t\t$.message.alert('info', '提示信息', '手机号错误！');\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//点击按钮置灰\r\n");
      out.write("\t\tchangeVerifyADiv();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction changeVerifyADiv() {\r\n");
      out.write("\t\taDiv = $('.verify_code');\r\n");
      out.write("\t\tif (waitTime > 0) {\r\n");
      out.write("\t\t\twaitTime--;\r\n");
      out.write("\t\t\taDiv.removeAttr(\"onclick\");\r\n");
      out.write("\t\t\taDiv.addClass(\"invaild_click\");\r\n");
      out.write("\t\t\taDiv.html('剩余' + waitTime + '秒');\r\n");
      out.write("\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\tchangeVerifyADiv();\r\n");
      out.write("\t\t\t}, 1000);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\taDiv.removeClass(\"invaild_click\");\r\n");
      out.write("\t\t\taDiv.click(clickAButton);\r\n");
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
      out.write("\t\t\turl : '/pay/reqVerifyCode.do',\r\n");
      out.write("\t\t\ttype : 'post',\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\tphone : phone,\r\n");
      out.write("\t\t\t\ttype : $('#order_VIP_id').val()\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tob = eval('(' + data + ')');\r\n");
      out.write("\t\t\t\tif (ob.result_code == 1) {\r\n");
      out.write("\t\t\t\t\tlinkId = ob.linkId;\r\n");
      out.write("\t\t\t\t\tchooseType = ob.type;\r\n");
      out.write("\t\t\t\t}\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /jsp/pay/payPage.jsp(49,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/jsp/pay/payPage.jsp(49,4) '${vipEnum}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${vipEnum}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /jsp/pay/payPage.jsp(49,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("ve");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /jsp/pay/payPage.jsp(50,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ve.type != 0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<li>\r\n");
        out.write("\t\t\t\t\t\t\t<div id=\"div_vip_");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ve.type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" style=\"height: 100%; vertical-align: bottom;\"\r\n");
        out.write("\t\t\t\t\t\t\t\tonclick=\"chooseVip('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ve.type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("')\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ve.desc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
