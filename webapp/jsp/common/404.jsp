<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="/c" prefix="c"%>
<%@ taglib prefix="fn" uri="/fn"%>
<c:set var="urlContextPath">${pageContext.request.requestURL}</c:set>
<html>
<head>
<base
	href="${fn:substring(urlContextPath, 0, fn:length(urlContextPath) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
</head>
<body style="background: #F8F8F8">
	<div style="width: 457px; height: 193px; margin: auto;">
		<img width="457px" height="193px" src="images/404.gif" />
	</div>
</body>
</html>