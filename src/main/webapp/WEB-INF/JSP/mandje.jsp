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
<script type="text/javascript">
    function validateForm() {
	    var naam = checkNaam();
	    var straat = checkStraat();
	    var huisnummer = checkHuisnummer();
	    var postcode = checkPostcode();
	    var gemeente = checkGemeente();
	    return naam && straat && huisnummer && postcode && gemeente;
    }

    function checkNaam(){
	    var naam=document.forms["bevestigingForm"]["naam"].value;
	    if (naam==null || naam=="") {
	    	document.getElementById("naamError").innerHTML = "Geef een geldige naam AUB!";
	    	return false;
	    }
	    else {
	    	document.getElementById("naamError").innerHTML = "";
	    	return true;
		}
    }
    
    function checkStraat(){
	    var straat=document.forms["bevestigingForm"]["straat"].value;
	    if (straat==null || straat=="") {
	    	document.getElementById("straatError").innerHTML = "Geef een geldige straat AUB!";
	    	return false;
	    }
	    else {
	    	document.getElementById("straatError").innerHTML = "";
	    	return true;
		}
    }
    
    function checkHuisnummer(){
	    var nummer=document.forms["bevestigingForm"]["huisnummer"].value;
	    if (nummer==null || nummer=="") {
	    	document.getElementById("huisnummerError").innerHTML = "Geef een geldig huisnummer AUB!";
	    	return false;
	    }
	    else {
	    	document.getElementById("huisnummerError").innerHTML = "";
	    	return true;
		}
    }
    
    function checkPostcode(){
	    var postcode=document.forms["bevestigingForm"]["postcode"].value;
	    if (postcode==null || postcode=="") {
	    	document.getElementById("postcodeError").innerHTML = "Geef een geldige postcode AUB!";
	    	return false;
	    }
	    else {
	    	document.getElementById("postcodeError").innerHTML = "";
	    	return true;
		}
    }
    
    function checkGemeente(){
	    var gemeente=document.forms["bevestigingForm"]["gemeente"].value;
	    if (gemeente==null || gemeente=="") {
	    	document.getElementById("gemeenteError").innerHTML = "Geef een geldige gemeente AUB!";
	    	return false;
	    }
	    else {
	    	document.getElementById("gemeenteError").innerHTML = "";
	    	return true;
		}
    }
    </script>
</head>
<body>

	<c:import url="/WEB-INF/JSP/menu.jsp" />

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
			
			<form name="bevestigingForm" action="<c:url value='/bevestiging.htm'/>" method="post" onSubmit="return validateForm()">
				<label>Naam <br> 
					<input id="naam" name="naam" value="${param.naam}" autofocus size="20" /> 
					<span class="fout" id="naamError"></span> 
				</label> <br>
				<label>Straat <br> 
					<input id="straat" name="straat" value="${param.straat}" autofocus size="20" /> 
					<span class="fout" id="straatError"></span> 
				</label> <br>
				<label>Huisnummer <br> 
					<input id="huisnummer" name="huisnummer" value="${param.huisnummer}" autofocus size="20" /> 
					<span class="fout" id="huisnummerError"></span> 
				</label> <br>
				<label>Postcode <br> 
					<input id="postcode" name="postcode" value="${param.postcode}" autofocus size="20" /> 
					<span class="fout" id="postcodeError"></span> 
				</label> <br>
				<label>Gemeente <br> 
					<input id="gemeente" name="gemeente" value="${param.gemeente}" autofocus size="20" /> 
					<span class="fout" id="gemeenteError"></span> 
				</label> <br>
				<input type="radio" name="bestelwijze" value="0">Afhalen<br>
 				<input type="radio" name="bestelwijze" value="1">Opsturen
				
				<br> <input type="submit" value="Als bestelbon bevestigen" />
			</form>
 		
 		</c:if>

</body>