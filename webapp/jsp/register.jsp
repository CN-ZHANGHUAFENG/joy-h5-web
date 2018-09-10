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
<link rel="stylesheet" href="/css/register.css" type="text/css" />
<head>

</head>
<body>
	<div class="container">
		<div class="layout_header">
			<div class="layout_header_title">
				<div class="back_left" onclick="goBack()">
					<img src="/images/more.png" />
				</div>
				<span class="login_cont">注册</span>
			</div>
			<div class="header_home" onclick="toIndexJsp()">
				<img src="/images/zhuye.png" />
			</div>
		</div>
	</div>
	<!--请用户输入手机号码-->
	<div class="pass_layout">
		<form action="javascript:void(0);" method="post">
			<div class="input_style">
				<!-- onchange="RegUserInput();" -->
				<input type="text" name="phone_mess" id="phone_mess"
					placeholder="请输入手机号码" maxlength="11" />
			</div>
			<div class="input_style pwd_input">
				<input type="text" id='pwdOnce' placeholder="密码长度为6-16位大小字母，符号或数字"
					maxlength="20" />
			</div>
			<div class="input_style pwd_input">
				<input type="text" id='pwdTwo' placeholder="再次输入密码" maxlength="20" />
			</div>
		</form>
	</div>
	<div class="message_div">
		<div style='overflow: hidden; display: none;' class="getMessage_show">
			<div class="sj_notinput">
				<img src="/resources/img/tishi.png" />
			</div>
			<span id="warningText">asdsa</span>
		</div>
	</div>
	<!--注册-->
	<div class="nextPass" onclick="register()">注册</div>
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

	function register() {
		phone = $('#phone_mess').val();
		pwdO = $('#pwdOnce').val();
		pwdT = $('#pwdTwo').val();
		var reg = /^1[0-9]{10,}$/;
		if (!phone || '' === phone || !reg.test(phone)) {
			$.message.alert('info', '提示信息', '请输入正确的手机号！');
			return false;
		}
		if (pwdO === '' || pwdO.length > 16 || pwdO.length <5) {
			$.message.alert('info', '提示信息', '请输入正确的密码！');
			$('#pwdOnce').val();
			$('#pwdTwo').val();
			return;
		}
		if (pwdT != pwdO) {
			$('#pwdOnce').val();
			$('#pwdTwo').val();
			$.message.alert('info', '提示信息', '两次密码输入不一致');
			return;
		}

		$.ajax({
			url : "/login/register.do",
			type : "post",
			data : {
				phone : phone,
				password : pwdO
			},
			success : function(data) {
				ob = eval('(' + data + ')');
				if (ob.result == 'success') {
					localStorage.usrFlag = phone + '_' + ob.token;
					location.href = "/index.do";
				} else {
					$.message.alert("info", "提示", "手机号未注册或密码错误！");
					$('#pwdOnce').val();
					$('#pwdTwo').val();
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

	
</script>