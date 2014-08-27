<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

	<h1>Mandje</h1>
	
	<c:if test="${not empty wijnenInMandje}">
 		
 			<table cellspacing='0'> 
									
				<thead>
					<tr>
						<th>Wijn</th>
						<th>Prijs</th>
						<th>Aantal</th>
						<th>Te Betalen</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="entry" items="${wijnenInMandje}">
						<tr>
							<td>${entry.key.soort.naam}</td>
							<td>&euro; <fmt:formatNumber value="${entry.key.prijs}" minFractionDigits="2" maxFractionDigits="2"/></td>
							<td>${entry.value}</td>
							<td>&euro; <fmt:formatNumber value="${entry.key.prijs * entry.value}" minFractionDigits="2" maxFractionDigits="2"/></td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
			<br>
			
			Totaal: &euro; <fmt:formatNumber value="${totaal}" minFractionDigits="2" maxFractionDigits="2"/>
			
			<br><br>
			
			<form action="<c:url value='/bevestiging.htm'/>" method="post">
				<label>Naam <br> 
					<input name="naam" value="${param.naam}" autofocus size="20" />
				</label> <br>
				<label>Straat <br> 
					<input name="straat" value="${param.straat}" autofocus size="20" />
				</label> <br>
				<label>Huisnummer <br> 
					<input name="huisnummer" value="${param.huisnummer}" autofocus size="20" />
				</label> <br>
				<label>Postcode <br> 
					<input name="postcode" value="${param.postcode}" autofocus size="20" />
				</label> <br>
				<label>Gemeente <br> 
					<input name="gemeente" value="${param.gemeente}" autofocus size="20" />
				</label> <br>
				<input type="radio" name="bestelwijze" value="0">Afhalen<br>
 				<input type="radio" name="bestelwijze" value="1">Opsturen
				
				<br> <input type="submit" value="Als bestelbon bevestigen" />
			</form>
 		
 		</c:if>
	
		
		
		
		
	
	

</body>