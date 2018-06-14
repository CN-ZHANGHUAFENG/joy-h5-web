<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/head.jsp"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
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
<link rel="stylesheet" href="/css/pay/payPage.css" type="text/css" />
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
				<span class="login_cont">开通会员</span>
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
		<div class="vip_ul_style">
			<input type="hidden" value="${vipType}" id="order_VIP_id">
			<ul>
				<c:forEach items="${vipEnum}" var="ve">
					<c:if test="${ve.type != 0}">
						<li>
							<div id="div_vip_${ve.type}" style="height: 100%; vertical-align: bottom;"
								onclick="chooseVip('${ve.type}')">${ve.desc}
							</div>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="pay_pass">
			<!--输入用户名-->
			<div class="pay_pass_inpit">
				<input type="text" name="phone" id="phoneId" placeholder="手机号"
					maxlength="11" />
			</div>
			<!--输入密码-->
			<div class="pay_pass_inpit">
				<input type="text" name="verifyCode" id="verifyCodeId"
					placeholder="验证码" maxlength="8" style="width: 50%" />
				<div style="padding-top: 0.2rem; line-height: 0.38rem">
					<a href="javascript:void(0);" onclick="clickAButton()"
						class="verify_code">发送验证码</a>
				</div>
				<!-- 
					<div class="x_or_d" onclick="changeShow();">
						<img src="/resources/img/yanjing-b.png" class="changeImg" />
					</div>
					 -->
			</div>
		</div>

		<div class="vip_order_message">价格：${(type+1)*5}元</div>
		<div class="button_div" align="center">
			<div class="order_button" onclick="orderVip()">订购</div>
		</div>
		<div class="vip_description">
			<span>注：购买VIP会员，可阅读该级别及低级会员书库中的小说。( 注: 部分书籍只供更高级别的会员阅读)</span>
		</div>
	</div>

</body>
</html>
<script type="text/javascript">
	$(function() {
		//checkIsLogin();
		chooseVipLevel = '${orderVipType}';
		if(!chooseVipLevel){
			chooseVipLevel = 1;
		}
		chooseVip(chooseVipLevel);
	});

	var linkId = '';
	var chooseType = '';

	function orderVip() {
		phone = $('#phoneId').val();
		verifyCode = $('#verifyCodeId').val();
		if (phone === '') {
			$.message.alert('info', '提示信息', '手机号不能为空！');
			return;
		}
		if (verifyCode === '') {
			$.message.alert('info', '提示信息', '请输入验证码！');
			return;
		}
		$.ajax({
			url : "/pay/submitVerifyCode.do",
			type : "post",
			data : {
				linkId : linkId,
				verifyCode : verifyCode,
				type:chooseType,
				cacheKey: localStorage.usrFlag
			},
			success : function(data) {
				ob = eval('(' + data + ')');
				if (ob.result_code == '0') {
					$.message.alert('info','提示','订购成功',function(){
						location.href = "/index.do";
					})
				} else {
					$.message.alert("info", "提示", "订购失败！");
				}
			},
			error : function(e) {
				console.log(e);
			}
		})
	}

	function chooseVip(type) {
		locaLevel = '${locaLevel}';
		if (locaLevel >= type) {
			$.message.alert("info", "提示", "无需订购低级会员");
			return;
		}
		divName = 'div_vip_' + type;
		$('#order_VIP_id').val(type);
		$('li div').removeClass("selected_li");
		$('#' + divName).addClass("selected_li");
		$('.vip_order_message').empty();
		price = (new Number(type) + 1) * 5;
		$('.vip_order_message').append("价格：" + price + "元");

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
		aDiv = $('.verify_code');
		if (waitTime > 0) {
			waitTime--;
			aDiv.removeAttr("onclick");
			aDiv.addClass("invaild_click");
			aDiv.html('剩余' + waitTime + '秒');
			setTimeout(function() {
				changeVerifyADiv();
			}, 1000);
		} else {
			aDiv.removeClass("invaild_click");
			aDiv.click(clickAButton);
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
			url : '/pay/reqVerifyCode.do',
			type : 'post',
			data : {
				phone : phone,
				type : $('#order_VIP_id').val()
			},
			success : function(data) {
				ob = eval('(' + data + ')');
				if (ob.result_code == 1) {
					linkId = ob.linkId;
					chooseType = ob.type;
				}
			},
			error : function(e) {
				console.log(e);
			}
		})

		return true;
	}
</script>