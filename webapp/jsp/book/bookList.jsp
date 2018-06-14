<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/head.jsp"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
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
<link rel="stylesheet" href="/css/book/bookList.css" type="text/css">
</head>
<body>
	<c:forEach items="${bookEntities}" var="be" varStatus="vs">
		<div class="my_r_box fc bookStyle-rank">
			<a href="/book/detail.do?bookId=${be.id}">
				<div class="mrb_img fl" style="position: relative">
					<img src="${be.imgUrl}">
					<div class="rank_num">
						<img
							style="background-color: transparent; width: 72%; position: relative; left: 0.1rem; top: -0.27rem;"
							src="/images/rank1@2x.png" /> <span
							style="position: absolute; top: -0.21rem; left: 0.21rem; color: white; font-size: 0.26rem;"
							class="rankLabel1span">${vs.count+(currentPage-1)*10}</span>
					</div>
				</div>
				<div class="mrb_imgtext rank_imgtext">
					<h4>${be.bookName}</h4>
					<div
						style="height: 1.2rem; text-overflow: ellipsis; overflow: hidden;">
						<p>${be.briefContent}</p>
					</div>
				</div>
			</a>
		</div>
	</c:forEach>
	<div id="moreDiv" class="my_r_box fc bookStyle-rank topLine" align="center"
		style="width: 100%; margin: 0.2rem 0rem;">
		<span class="span_more"
			onclick="appendContent('${currentPage+1}','${totalCount}')">more</span>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function() {
		var arr = new Array();
		 <c:forEach items="${bookEntities}" var="t">
		 arr.push('${t}'); //js中可以使用此标签，将EL表达式中的值push到数组中
         </c:forEach>
		if(arr.length==0){
			var span = $("#moreDiv span");
			span.empty();
			span.removeAttr("onclick");
		}
	});
</script>