<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/head.jsp"%>
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
<link rel="stylesheet" href="/css/classify.css" />
<link rel="stylesheet" href="/css/index.css" type="text/css">
<title>H-Book</title>
</head>
<body>
	<input type="hidden" id="codeHide" value="${code}">
	<input type="hidden" id="tabIdHide" value="${tabId}">
	<input type="hidden" id="isHomeHide" value="1">
	<div class='head-parent'>
		<div class="my_head fc my_head-home">
			<div class="fl fc">
				<i class="home_logo fl"> </i>
				<div class="my_title fl"></div>
			</div>
			<div class="mh_right fr">
				<div class="my_person fr" onclick="checkIsLogin('notNeed');">
					<img src="/images/person@2x.png" />
				</div>
			</div>
		</div>
	</div>
	<!--频道选择-->
	<div class="my_nav fc">
		<ul class="myul"></ul>
	</div>

	<div class="my_foot">
		<div class="nav_search">
			<input type="text" placeholder="搜索" id="footSearchInput" />
			<div class="ns_img" onclick="serachBook();">
				<img src="/images/search.png" />
			</div>
		</div>
	</div>

	<!-- home页面的 '最近阅读' 与 '书架' -->
	<div style="background-color: #d26c3129">
		<div class="my_record">
			<div class="my_record_recent">
				<div class="mr_img_left">
					<img src="/images/record@2x.png" />
				</div>
				<div class="my_r_name"></div>
			</div>
			<div class="my_record_shift">
				<div class="shu_line"></div>
				<img class="mr_img_right" src="/images/bookshelft.png" /> <span
					id="toMyCollect" class="my_r_text">书架</span>
			</div>
		</div>
	</div>
	<div class="all_content">
		<div id="moreDiv">
			<a href="javascript:void(0);" onclick="appendContent()"></a>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	var tabList;
	var IndexBookPerPageItem=10;
	$(function() {
		init();
	});

	function init() {
		localStorage.removeItem("flagCat");
		initVipLabel();
		appendContent();
	}
	function initVipLabel() {
		$('.my_title').html("H-Book");
		tabList = new Array({
			'id' : 1,
			'name' : '初级会员'
		}, {
			'id' : 2,
			'name' : '中级会员 '
		}, {
			'id' : 3,
			'name' : '高级会员'
		});
		var html = '';
		for (var i = 0, lg = tabList.length; i < lg; i++) {
			html += '<li class="tab' + tabList[i].id + '">' + '<a id="tab'
					+ tabList[i].id + '" onclick="toListHome(' + tabList[i].id
					+ ')">'
					// html += '<li class="tab'+tabList[i].id+'">' + '<span
					// class="nav-top" id="tab'+tabList[i].id +'"
					// onclick="toHome(' + tabList[i].id + ')">'
					+ tabList[i].name + '</span></li>';
		}
		// html += '<li id="toPayBeanBtn"><a>充值</a></li>';
		$('.my_nav .myul').append(html);
		$('.foot_nav .myul').append(html);
		wrapTab();
	}

	function toListHome(tabId) {
		window.location.href = '/index/' + tabId + ".do";
	}

	function wrapTab() {
		var tabId = null;
		tabId = $("#tabIdHide").val();
		if (null == tabId || '' == tabId) {
			tabId = tabList[0].id;
			if (null != tabId) {
				$("#tabIdHide").val(tabId);
			}
		}
		if (null == tabId || '' == tabId) {
			alert("无法获取当前频道信息");
		}
		$(".my_nav li").removeClass('nv_active');
		$(".tab" + tabId).addClass('nv_active');
		$("#tab" + tabId).css("width", "1.5rem");
	}

	function appendContent(currentPage, totalCount) {
		tabId = $('#tabIdHide').val();
		$.ajax({
			type : 'get',
			url : '/index/ajax/books.do',
			data : {
				vipLevel : tabId,
				currentPage : currentPage,
				itemPerPage : IndexBookPerPageItem,
				totalCount : totalCount
			},
			async : false,
			success : function(obj) {
				var moreDiv = $('#moreDiv');
				if (moreDiv) {
					moreDiv.remove();
				}
				$('.all_content').append(obj);
			},
			error : function(e) {
			}
		})
	}

	function serachBook() {
		var bookName = $('#footSearchInput').val();
		if (!bookName || bookName == '') {
			appendContent();
			return;
		}
		$.ajax({
			type : 'get',
			url : '/index/ajax/bookInfo.do',
			data : {
				'bookName' : bookName,
				'vipLevel':$('#tabIdHide').val()
			},
			async : false,
			success : function(obj) {
				$('.all_content').empty();
				$('.all_content').append(obj);
				var moreDiv = $('#moreDiv');
				if (moreDiv) {
					moreDiv.remove();
				}
			},
			error : function(e) {
			}
		})
	}
</script>
