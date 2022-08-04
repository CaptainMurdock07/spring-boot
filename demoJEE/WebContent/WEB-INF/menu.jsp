<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${ !empty sessionScope.noEmploye }">
	<p>Bonjour, vous etes connecte, votre numero employe est : <c:out value="${ sessionScope.noEmploye }" /></p>
</c:if>
<ul>
	<li><a href = "/demoJEE/accueil">Accueil</a></li>
	<li><a href = "/demoJEE/bonjour">Dis bonjour</a></li>
	<li><c:out value="${ nomComplet }" /></li>
	<li><a href="/demoJEE/accueil">Employes</a></li>
</ul>