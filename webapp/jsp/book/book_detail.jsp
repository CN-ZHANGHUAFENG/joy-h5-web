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
<link rel="stylesheet" href="css/classify.css" type="text/css" />
<link rel="stylesheet" href="css/book/book_detail.css" type="text/css">
<link rel="stylesheet" href="css/common/novel_detail.css"
	type="text/css">
</head>
<body>
	<input type="hidden" id="bookIdHide" value="${bookInfo.id}" />
	<div class="head-parent">
		<div class="layout_header">
			<div class="layout_header_title">
				<div class="back_left" onclick="goBack()">
					<img src="images/more.png" />
				</div>
				<span class="login_cont">书籍详情</span>
			</div>
			<div class="header_home" onclick="toIndexJsp()">
				<img src="images/zhuye.png" />
			</div>
		</div>
	</div>
	<div class="nd_content">
		<div class="nd_title fc">
			<div class="nd_title_imgbox fl">
				<img src="${bookInfo.imgUrl}" class="book_detail_img">
			</div>

			<div style="overflow: hidden; padding-left: .22rem;">
				<div class="nd_imgtext fl">
					<h3>${bookInfo.bookName}</h3>
					<p class="book_detail_author">${bookInfo.author}</p>
					<p class="book_detail_over">
						状态：<span> 已完结 
						</span>
					</p>
					<p class="book_detail_type">
						分类：<span> ${type}
						</span>
					</p>
				</div>
			</div>
		</div>
		<div class="ndt_btn">
			<div class="btn_width kepp_reading" onclick="toRead(${firstChapter.chapterId})">阅读</div>
			<!-- <div class="btn_width add_book">加入书架</div> -->
		</div>
		<div class="line_through"></div>
		<div class="content_validity" id="div1">
			<h3>内容简介</h3>
			<div class="introduce">
				<p id="real-desc">${bookInfo.briefContent}</p>
				<pre id="copy-desc"></pre>
			</div>
			<div class="read_more"></div>
		</div>
		<div class="line_through_two"></div>
		<div class="nd_list fc">
			<div class="fl">
				<span>目录</span>
			</div>
			<div class="fr new_chapter">
				<span>最新章节</span> <span>${newestChapter.chapterTitle}</span> <em
					class="ndl_img"> <img src="images/more@2x.png" />
				</em>
			</div>
		</div>
		<div id="book_catalog"></div>
</body>
</html>

<script type="text/javascript">
	var bookInfo;
	var catalogId;//正在阅读的章节号
	/*通过地址栏的url拿到书籍的id值*/
	var bookId;
	var titleName;
	
	var itemPerPage;
	var totalCount;

	$(function() {
		if(!checkIsLogin()){
			return ;
		}
		bookId = $("#bookIdHide").val();
		init();
		loadCatalog();
	});

	function init() {
		bindClick();
	}

	flag = null;
	function bindClick() {
		$('.read_more').append(
				"展开<span><img src='images/open@2x.png' /></span>");
		flag = 1;
		$('.read_more')
				.click(
						function() {
							if (flag == 1) {
								$('.introduce').height('auto');
								$('.read_more').empty();
								$('.read_more')
										.append(
												"收起<span><img src='images/retract@2x.png' /></span>");
								flag = 2;
							} else if (flag == 2) {
								$('.introduce').height('1.2rem');
								$('.read_more').empty();
								$('.read_more')
										.append(
												"展开<span><img src='images/open@2x.png' /></span>");
								flag = 1;
							}
						});
	}

	function loadCatalog() {
		$.ajax({
			type : "get",
			url : "book/catalog.do",
			data : {
				bookId : bookId
			},
			success : function(data) {
				$('#book_catalog').append(data);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

	function getCatalogPage(currentPage) {
		$.ajax({
			type : "get",
			url : "book/catalog.do",
			data : {
				bookId : bookId,
				currentPage : currentPage,
				itemPerPage : itemPerPage,
				totalCount : totalCount
			},
			success : function(data) {
				$('#book_catalog').empty();
				$('#book_catalog').append(data);
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
	
	function toRead(catalogId){
		if(!checkVipLevel(bookId)){
			return;
		}
		location.href="book/catalog/read.do?chapterId="+catalogId+"&bookId="+bookId;
	}
</script>
