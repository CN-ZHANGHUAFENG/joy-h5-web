<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="/c" prefix="c"%>
<%@ taglib prefix="fmt" uri="/fmt"%>
<%@ taglib prefix="fn" uri="/fn"%>
<c:set var="urlContextPath">${pageContext.request.requestURL}</c:set>
<html>
	<head>
		<base href="${fn:substring(urlContextPath, 0, fn:length(urlContextPath) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>登录系统</title>
		<script type="text/javascript" src="js/jquery/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/jquery/jquery.form.js"></script>
		<script type="text/javascript" src="js/common/jr.js"></script>
		<script type="text/javascript" src="js/common/jrSlide.js"></script>
		<script type="text/javascript" src="js/common/common.js"></script>
		<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="/css/chLogin.css" />
		<link rel="stylesheet" type="text/css" href="/css/dialog.css" />
		<link rel="stylesheet" type="text/css" href="/css/loading.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				if(navigator.cookieEnabled == false){
					$.message.alert('warn','警告信息','您的浏览器禁用了cookie，将无法正常完成登录，请开启cookie功能！');
				}
				
				forIE6();
			});

			function login(){
				if($('#userName').val() == ''){
					$.message.alert('info','提示信息','请填写账号！');
					return;
				}
				if($('#password').val() == ''){
					$.message.alert('info','提示信息','请填写密码！');
					return;
				}
				if($('#verificationCode').val() == ''){
					$.message.alert('info','提示信息','请填写验证码！');
					return;
				}
				$('#errorMsgSpan').empty();
				$('#loginForm').submit();
			}
			
			function changeVerImg(){
				$('#verificationImage').attr('src',"jsp/common/registerImg.jsp?version=" + (new Date()).getTime());
			}

			function verificationCodeEnter() {
				var e = window.event
						|| arguments.callee.caller.arguments[0];
				if (e && e.keyCode == 13) {
					login();
				}
			}
		</script>
	</head>
	<body>
		<div class="chContainer">
			<form id="loginForm" name="loginForm" action="j_spring_security_check" method="post" style="margin:0px;padding:0px;">
				<div class="chContent">
					<div class="loginTitle"></div>
					<div class="loginWarp">
						<div class="chMainDiv">
							<div class="login">
								<div class="title">
									<div class="titleImg"><img src="images/login/user.png" border="0" width="20px" height="20px" /></div>
									<div class="titleText">登录</div>
								</div>
								<div class="data-show">
									<div class="inputText">
										<span style="width:48px;text-align:right;">账号：</span>
										<div><input type="text" name="j_username" value="${userName }" id="userName"/></div>
									</div>
									<div class="inputText">
										<span style="width:48px;text-align:right;">密码：</span>
										<div><input type="password" name="j_password" value="" id="password"/></div>
									</div>
									<div class="inputText">
										<span style="width:48px;text-align:right;">验证码：</span>
										<div><input type="text" name="verificationCode" value="" id="verificationCode" class="verificationCode" onkeyup="verificationCodeEnter();"/></div><img id="verificationImage" src="jsp/common/registerImg.jsp" border="0"/><a href="javascript:void(0);" onclick="changeVerImg();" class="changeVer">换一张</a>
									</div>
									<div class="button">
										<a href="javascript:void(0);" class="btn" id="loginButton" onclick="login();">登　录</a>
									</div>
									<div class="error" id="errorMsgSpan">${errorMsg }</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>