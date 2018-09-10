<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="/c" prefix="c"%>
<%@ taglib uri="/fn" prefix="fn"%>

<c:set var="urlContextPath">${pageContext.request.requestURL}</c:set>
<base
	href="${fn:substring(urlContextPath, 0, fn:length(urlContextPath) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="/css/common/common.css${readVerNum}" />
<link rel="stylesheet" href="/css/common/reset.css${readVerNum}" />
<link rel="stylesheet" href="/css/common/title.css${readVerNum}" />
<link rel="stylesheet" href="/css/common/dialog.css${readVerNum}" />

<script type="text/javascript" src="/js/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="/js/common/common.js?v=6"></script>
<script type="text/javascript" src="/js/common/jr.js?v=2"></script>

<script type="text/javascript">
	function toIndexJsp() {
		location.href = "/index.do";
	}

	function goBack() {
		location.href = "javascript:history.go(-1);"
	}

	function forIE6() {
		var bar = getBow();
		if (bar == 'IE6') {
			$('#forIe6Div').dialog('open', {
				url : 'jsp/updateIE.html',
				title : '更新浏览器',
				needClose : false,
				width : '600',
				height : '200'
			});
			return false;
		}
		return true;
	}

	//校验是否登入,舍去
	function checkIsLogin(needInfo) {
		if (true)
			return true;
		usrFlag = localStorage.usrFlag;
		isLogin = false;
		$.ajax({
			url : '/ajax/check.do',
			type : 'get',
			data : {
				checkKey : usrFlag
			},
			async : false,
			success : function(data) {
				ob = eval('(' + data + ')');
				if (ob.result == 'success') {
					isLogin = true;
				} else {
					if (!needInfo) {
						$.message.alert("info", "提示", "用户未登录，将跳转至登录页",
								function(data) {
									location.href = "/loginHome.do";
								});
						isLogin = false;
					} else {
						location.href = "/loginHome.do";
					}
				}
			},
			error : function(e) {
				console.log(e);
			}
		})

		return isLogin;
	}

	//校验是否有权限观看,舍去
	function checkVipLevel(bookId) {
		if (true)
			return true;
		usrFlag = localStorage.usrFlag;
		conformToVip = false;
		$.ajax({
			url : '/book/ajax/checkVipLevel.do',
			type : 'post',
			async : false,
			data : {
				checkKey : usrFlag,
				bookId : bookId
			},
			success : function(data) {
				ob = eval('(' + data + ')');
				if (ob.result == '0') {
					conformToVip = true;
				} else {
					$.message.alert('info', '提示', ob.msg, function() {
						location.href = '/pay/payPage.do?checkKey=' + usrFlag
								+ '&bookId=' + bookId;
					});
					conformToVip = false;
				}
			},
			error : function(e) {
				console.log(e);
			}
		});

		return conformToVip;
	}

	//验证码请求
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
