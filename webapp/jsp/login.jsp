<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/head.jsp"%>
<!DOCTYPE html>
<html style="font-size: 50px;">
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="-1">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="yes" name="apple-touch-fullscreen">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no, email=no" name="format-detection">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="/css/classify.css" type="text/css" />
<link rel="stylesheet" href="/css/login.css" type="text/css" />
<head>

</head>
<body>
	<div class="head-parent">
		<div class="layout_header">
			<div class="layout_header_title">
				<div class="back_left" onclick="goBack()">
					<img src="/images/more.png" />
				</div>
				<span class="login_cont">登录</span>
			</div>
			<div class="header_home" onclick="toIndexJsp()">
				<img src="/images/zhuye.png" />
			</div>
		</div>
	</div>
	<!-- 
	<div class="refresh">
		<div class="refresh_img">
			<img class="needRotate" src="/resources/img/refresh.png" alt="" />
		</div>
		<div class="refresh_jump">页面正在跳转中</div>
	</div>
	 -->
	<div class="container">
		<div class="login_from">
			<div class="user_pass">
				<!--输入用户名-->
				<div class="uinfo_input">
					<div class="uinfo_img">
						<img src="/images/dengl.png" />
					</div>
					<input type="text" name="phone" id="phoneId" placeholder="手机号"
						maxlength="20" />
				</div>
				<!--输入密码-->
				<div class="uinfo_input">
					<div class="uinfo_img">
						<img src="/images/suo.png"/>
					</div>
					<input type="text" name="password" id="pwdId" placeholder="密码"
						maxlength="20" />
					<!-- 
					<div class="x_or_d" onclick="changeShow();">
						<img src="/resources/img/yanjing-b.png" class="changeImg" />
					</div>
					 -->
				</div>
			</div>
			<!--Ajax无刷新异步获取用户 -- 判断输入的手机号是否注册-->
			<div class="getMessage">
				<div style='overflow: hidden; display: none;'
					class="getMessage_show">
					<div class="sj_notinput">
						<img src="/resources/img/tishi.png" />
					</div>
					<span> <!-- 手机号未注册 -->
					</span>
				</div>
			</div>
			<!--登录按钮-->
			<div class="user_login fix" onclick="login();">登录</div>
			<div class="register_forget">
				<p class="register_user">
					<a href="/login/registerPage.do">立即注册</a>
				</p>
				<!-- 
				<p class="forget_pass">
					<a>忘记密码</a>
				</p>
				 -->	
			</div>
		</div>
		<!--更多登录方式-->
	</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(
			function() {
				if (navigator.cookieEnabled == false) {
					$.message.alert('warn', '警告信息',
							'您的浏览器禁用了cookie，将无法正常完成登录，请开启cookie功能！');
				}
				forIE6();
			});

	function login() {
		phone = $('#phoneId').val();
		pwd = $('#pwdId').val();
		if (phone === '') {
			$.message.alert('info', '提示信息', '请输入手机号！');
			return;
		}
		if (pwd === '') {
			$.message.alert('info', '提示信息', '请输入密码！');
			return;
		}
		$.ajax({
			url : "/login.do",
			type : "post",
			data : {
				phone : phone,
				password : pwd
			},
			success : function(data) {
				ob = eval('(' + data + ')');
				if (ob.result == 'success') {
					localStorage.usrFlag = phone + '_' + ob.token;
					location.href = "/index.do";
				} else {
					$.message.alert("info", "提示", "手机号未注册或密码错误！");
				}
			},
			error : function(e) {
				console.log(e);
			}
		})
	}

	function clickAButton() {
		waitTime = 60;
		//手机号校验
		if (!toGetVerifyCode()) {
			$.message.alert('info', '提示信息', '手机号错误！');
			return;
		}
		//点击按钮置灰
		changeVerifyADiv();
	}

	function changeVerifyADiv() {
		aDiv = $('#sendCodeId');
		if (waitTime > 0) {
			waitTime--;
			aDiv.removeAttr("onclick");
			aDiv.addClass("click_a");
			aDiv.html('剩余' + waitTime + '秒');
			setTimeout(function() {
				changeVerifyADiv();
			}, 1000);
		} else {
			aDiv.removeClass("click_a");
			aDiv.click(changeVerifyADiv);
			aDiv.empty();
			aDiv.append("发送短信验证码");
			waitTime = 60;
		}
	}

	function toGetVerifyCode() {
		var phone = $('#phoneId').val();
		var reg = /^1[0-9]{10}$/;
		if (!phone || '' === phone || !reg.test(phone)) {
			return false;
		}

		$.ajax({
			url : '/login/ajax/getVerifyCode.do',
			type : 'get',
			data : {
				phone : phone
			},
			error : function(e) {
				console.log(e);
			}
		})

		return true;
	}
</script>