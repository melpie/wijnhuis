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

	<h1>Wijn toevoegen aan mandje</h1>
	Land
	<br>
	<b>${land.naam}</b>
	<br>
	<br> Soort
	<br>
	<b>${soort.naam}</b>
	<br>
	<br> Jaar
	<br>
	<b>${wijn.jaar}</b>
	<br>
	<br> Beoordeling
	<br>
	<c:url value="/images/ster.jpg" var="sterImage" />
	<c:forEach begin="1" end="${wijn.beoordeling}">
		<img src="${sterImage}" title="ster" alt="ster" height="13" width="13" />
	</c:forEach>
	<br>
	<br> Prijs
	<br>
	<b>${wijn.prijs}</b>
	<br>
	<br>
	<form action="<c:url value='/mandje.htm'/>" method="post">
		<label>Aantal flessen: <br> <input name="aantal"
			value="${param.aantal}" autofocus size="10" />
			<input name="wijnid"
			value="${wijn.wijnNr}" type="hidden"/>
		</label> <br>
		<br> <input type="submit" value="Toevoegen" />
	</form>
</body>
</html>