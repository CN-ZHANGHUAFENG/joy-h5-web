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
<link rel="stylesheet" href="css/book/book_catalog.css" type="text/css">
</head>
<body>
	<input type="hidden" value="${totalCount}" id="totalCount_input" />
	<input type="hidden" value="${itemPerPage}" id="itemPerPage_input" />
	<div class="book_caatalog_list">
		<ul>
			<c:forEach items="${bookChapterEntities}" var="bc" varStatus="vs">
				<li><div
						style="margin-left: -0.2rem; min-width: 1.2rem; display: inline-block;">【${vs.count+cIndex}】</div>
					<a href="javascript:void(0);" onclick="toRead('${bc.chapterId}')">${bc.chapterTitle.trim()}</a></li>
			</c:forEach>
		</ul>
	</div>
	${html}
</body>
</html>
<script type="text/javascript">
	totalCount = $('#totalCount_input').val();
	itemPerPage = $('#itemPerPage_input').val();
	$(function() {
		initSelect();
	});

	function initSelect() {
		$('#catalog_list_select').change(function() {
			catalogIndex = $(this).children('option:selected').val();
			getCatalogPage(catalogIndex);
		})
	}
	
</script>