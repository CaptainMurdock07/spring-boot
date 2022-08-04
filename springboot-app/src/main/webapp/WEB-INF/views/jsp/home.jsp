<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Je suis la page HOME</h1>
	<p>${ perso.nom }</p>
	<h2>Liste de personnes</h2>
	<c:forEach items = "${ personnes }" var = "personne">
		<c:out value ="${ personne.nom } ${ personne.prenom }"/>
	</c:forEach>
	<p>${ nom }</p>
</body>
</html>