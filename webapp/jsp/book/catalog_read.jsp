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
<link rel="stylesheet" href="css/book/catalog_read.css" type="text/css">
<link rel="stylesheet" href="css/common/novel_detail.css"
	type="text/css">
</head>
<body>
	<div class="layout_header div_postion">
		<div class="layout_header_title">
			<div class="back_left" onclick="goBack()">
				<img src="images/more.png">
			</div>
			<span class="login_cont">${bookName}</span>
		</div>
		<div class="header_home" onclick="toIndexJsp()">
			<img src="images/zhuye.png">
		</div>
	</div>
	<div id="chapter_title" class="layout_header div_postion catalog_titel"></div>
	<div class="h5_novel_titel div_upOrdown" style="margin-bottom: 0">
		<div class="div_button"
			onclick="toBookDetail('next','${last.chapterId}')">
			<span>上一页</span>
		</div>
		<div class="div_button" onclick="toBookDetail('home')">
			<span>首页</span>
		</div>
		<div class="div_button"
			onclick="toBookDetail('next','${next.chapterId}')">
			<span>下一页</span>
		</div>
	</div>
	<div class="catalog_content backgroud_color">
		<div>
			<pre id="contentPre" class="pre_content"></pre>
		</div>
	</div>

	<div class="h5_novel_titel div_upOrdown"
		style="position: absolute; bottom: 0.2rem">
		<div class="div_button"
			onclick="toBookDetail('next','${last.chapterId}')">
			<span>上一页</span>
		</div>
		<div class="div_button" onclick="toBookDetail('home')">
			<span>首页</span>
		</div>
		<div class="div_button"
			onclick="toBookDetail('next','${next.chapterId}')">
			<span>下一页</span>
		</div>
	</div>
</body>

<script type="text/javascript">
	bookId = ${chapterInfo.bookId};
	$(function(){
		init();
	});
	
	function init(){
		if(!checkIsLogin()){
			return;
		}
		if(!checkVipLevel(bookId)){
			return;
		}
		$("body").css("min-height",$(window).height());
		loadContent();
	}
	
	function loadContent(){
		$.ajax({
			url:"book/catalog/ajax/content.do?chapterId="+${chapterInfo.chapterId}+"&bookId="+bookId,
			type:"GET",
			success:function(data){
				var info = eval('('+data+')');
				$('#contentPre').append(info.chapterContent);
				$('#chapter_title').append(info.chapterTitle);
			},
			error:function(){
				console.log(e);
			}
		});
	}
	
	function toBookDetail(buttonType,index){
		if(buttonType === 'home'){
			location.href="book/detail.do?bookId=${chapterInfo.bookId}";
		}else{
			if(index){
				location.href="book/catalog/read.do?chapterId="+index+"&bookId=${chapterInfo.bookId}";
			}
		}
	}
</script>