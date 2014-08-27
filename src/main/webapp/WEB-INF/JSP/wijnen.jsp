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

	<h1>Het wijnhuis</h1>
	<h2>Kies een land</h2>

	<c:forEach items="${landen}" var="land">
		<div class="floatedImage">
			<c:url value="/images/${land.landNr}.png" var="landImage" />
			<c:url value="/index.htm" var="wijnenURL1">
				<c:param name="landid" value="${land.landNr}" />
			</c:url>
			<a href="<c:out value='${wijnenURL1}'/>"> <img src="${landImage}"
				title="${land.naam}" alt="${land.naam}" height="32" width="46" />
			</a>
		</div>
	</c:forEach>

	<br>
	<br>

	<c:if test="${not empty land}">
		<h2>Kies een soort uit ${land.naam}</h2>
		<ul>
			<c:forEach items="${soorten}" var="soort">
				<c:url value="/index.htm" var="wijnenURL2">
					<c:param name="landid" value="${land.landNr}" />
					<c:param name="soortid" value="${soort.soortNr}" />
				</c:url>
				<li><a href="<c:out value='${wijnenURL2}'/>"> ${soort.naam}
				</a></li>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test="${not empty soort}">
		<h2>Kies een wijn uit ${soort.naam}</h2>
		<ul>
			<c:forEach items="${wijnen}" var="wijn">
				<c:url value="/toevoegen.htm" var="toevoegenURL">
					<c:param name="landid" value="${land.landNr}" />
					<c:param name="soortid" value="${soort.soortNr}" />
					<c:param name="wijnid" value="${wijn.wijnNr}" />
				</c:url>
				<li><a href="<c:out value='${toevoegenURL}'/>">
						${wijn.jaar} </a> <c:url value="/images/ster.jpg" var="sterImage" />
					<c:forEach begin="1" end="${wijn.beoordeling}">
						<img src="${sterImage}" title="ster" alt="ster" height="13"
							width="13" />
					</c:forEach></li>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>