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

	<div>

		<ul class=menu>

			<c:url value="/index.htm" var="wijnenURL" />
			<c:url value="/mandje.htm" var="mandjeURL" />

			<li><a href="<c:out value='${wijnenURL}'/>">Wijnen</a></li>
			<li><a href="<c:out value='${mandjeURL}'/>">Mandje</a></li>

		</ul>

	</div>

	<h1>Bestelbonnen</h1>

	<c:forEach items="${bestelbonnen}" var="bestelbon">
		<ul>
			<li> Bestelbon nummer ${bestelbon.bonNr}: ${bestelbon.naam}
			<ul>
			<c:forEach items="${bestelbon.bestelBonLijnen}" var="bestelbonlijn">
				<li>${bestelbonlijn.aantal} x ${bestelbonlijn.wijn.soort.naam} (${bestelbonlijn.wijn.jaar}) uit ${bestelbonlijn.wijn.soort.land.naam}</li>
			</c:forEach>
			</ul>
			</li>
		</ul>
	</c:forEach>


</body>
</html>