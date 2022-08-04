<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<p>Ceci est ma premiere JSP !</p>
	<p>
		Bonjour
		<%
	String maVariable = (String) request.getAttribute("name");
	out.println(maVariable);
	%>
	</p>
	<p>Bonjour ${name }</p>
	<p>Bonjour ${empty name ? "Madame, Monsieur" : name }</p>
	<%-- 	<p>Bonjour ${ !emplty name and name == "Yoda" ? "Que la force soit avec toi !" : name }</p>--%>
	<p>Bonjour ${ maVariable[0] }</p>
	<p>Bonjour ${ maVariable[1] }</p>
	<p>Bonjour ${ maVariable[2] }</p>
	<p>
		<c:out value="Coucou !" />
	</p>
	<p>
		<c:out value="${ maVariable[0] }" />
	</p>
	<c:set var="nomComplet" value="${ civilite } ${ prenom } ${ name }"
		scope="session" />
	<p>
		Bonjour
		<c:out value="${ nomComplet }" />
	</p>
	<p>
		Si vous n'etes pas
		<c:out value="${ nomComplet }" />
		Merci de cliquer sur le lien de deconnexion.
	</p>
	<p>
		Bonjour
		<c:out value="${ nomComplet }" />
		,
	</p>
	<c:if test="${ name == Bond }">
		<p>Vous etes l'agent 007, vous avez le permis de tuer.</p>
	</c:if>
<%-- 	<c:choose>
		<c:when test="${ civilite == ‘Mr’ } ">Bonjour Monsieur </c:when>
		<c:when test="${ civilite == 'Mme’ }">Bonjour Madame </c:when>
		<c:when test="${ civilite == 'Mlle’ }">Bonjour Mademoiselle </c:when>
		<c:otherwise>Bonjour </c:otherwise>
	</c:choose> --%>
	<p>${ name }</p>
	<p>
		<c:out value="${ name }" />
	</p>
	<p>
		<c:out value="${ name }" escapeXml="false" />
	</p>
	<%-- 	<p>bonjour <c:out value="${ name }" default 
 --%>
 	<form action="/demoJEE/bonjour" method="post">
 		<label for="auteur">Quel est votre auteur prefere ?</label>
 		<input type="text" name="auteur" id="auteur" />
 		<input type="submit" />
 	</form>
 	<c:if test="${ !empty auteur }">
 		<p>Bonjour, votre auteur prefere est : <c:out value="${ auteur }" /></p>
 	</c:if>
 	<form action="/demoJEE/bonjour" method="post">
 		<label for="auteurs">Quel est votre auteur prefere ?</label>
 		<select name="auteurs">
 			<c:forEach items="${ auteurs }" varStatus="auteur">
 				<option value="<c:out value="${ auteur.index }" />" />
 				<c:out value="${ auteur.current }" />
 			</c:forEach>
 		</select>
 		<input type="submit" />
 	</form>
 	<c:if test="${ !empty idAuteur }">
 		<p>Bonjour, votre auteur prefere est : <c:out value="${ auteurs[idAuteur] }" />(id=<c:out value="${ idAuteur }"></c:out>)</p>
 	</c:if>
 	<form action="/demoJEE/bonjour" method="post">
 	<p>
 		<label for="nom">Entrer votre nom</label>
 		<input type="text" name="nom" id="nom" />
 	</p>
 	<p>
 		<label for="password">Entrer votre mot de passe</label>
 		<input type="password" name="password" id="password" />
 	</p>
 	<input type="submit" />
 	</form>
 	<c:out value="${ form.message }" />
 	<c:if test="${ form.loginId > 0 }">
 		<p>Bonjour, vous etes bien connecte, votre numero 'employe est : <c:out value="${ form.loginId }" /></p>
 	</c:if>
</body>
</html>