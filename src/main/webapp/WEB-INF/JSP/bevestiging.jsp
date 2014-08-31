<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!doctype html>
<html lang="nl">
<head>
<title>WIJNEN</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />
	
	<br>
	
	<h1>Je mandje is bevestigd als bestelbon ${bestelBon.bonNr}.</h1>
	
</body>