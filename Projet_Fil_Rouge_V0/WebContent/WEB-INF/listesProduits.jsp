<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/Projet_Fil_Rouge_V0/css/style.css" rel="stylesheet" />
</head>
<body>
	<c:if test="${ !empty livre }">
		<section class="selection">
			<div>
				<img src="<c:out value="${ livre.url_image }" />"  alt="Couverture du livre <c:out value="${ livre.titre }" />" />
			</div>
			<div>
				<h2><c:out value="${ livre.titre }" /></h2>
				<%-- <h3><c:out value="${ livre.auteur }" /></h3>
				<h3><c:out value="${ livre.editeur }" /></h3>
				<h3><c:out value="${ livre.prix }" /></h3> --%>
				<p><c:out value="${ livre.auteur }" /></p>
				<p><c:out value="${ livre.editeur }" /></p>
				<p><c:out value="${ livre.prix }" /></p>
			</div>
		</section>
	</c:if>
	<section class="carroussel">
		<c:forEach items="${ livres }" var="livre">
			<div>
				<a href="/Projet_Fil_Rouge_V0/listesProduits?id=<c:out value="${ livre.idLivre }" />" />
				<div>				
					<h2><c:out value="${ livre.titre }" /></h2>
					<%-- <h3><c:out value="${ livre.auteur }" /></h3>
					<h3><c:out value="${ livre.editeur }" /></h3>
					<h3><c:out value="${ livre.prix }" /></h3> --%>
					<p><c:out value="${ livre.auteur }" /></p>
					<p><c:out value="${ livre.editeur }" /></p>
					<p><c:out value="${ livre.prix }" /></p>
				</div>
				<img src="<c:out value="${ livre.url_image }" />"  alt="Couverture du livre <c:out value="${ livre.titre }" />" />
			</div>
		</c:forEach>
	</section>
</body>
</html>