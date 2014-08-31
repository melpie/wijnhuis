<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<ul class=menu>
		<c:url value="/index.htm" var="wijnenURL" />
		<c:url value="/mandje.htm" var="mandjeURL" />
		<c:url value="/bestelbonnen.htm" var="bestelbonnenURL" />
		<li><a href="<c:out value='${wijnenURL}'/>">Wijnen</a></li>
		<li><a href="<c:out value='${mandjeURL}'/>">Mandje</a></li>
		<li><a href="<c:out value='${bestelbonnenURL}'/>">Bestelbonnen</a></li>
	</ul>
</div>