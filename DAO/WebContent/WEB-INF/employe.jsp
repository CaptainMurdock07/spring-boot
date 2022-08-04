<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Employes</h1>
		<section class="ajouter-employe">
			<form action="" method="post">
				<p>
					<label for="noEmploye">Entrer votre numero Employe :</label> 
					<input type="number" name="noEmploye" id="noEmploye" placeholder="Numero Employe" />
				</p>
				<p>
					<label for="nom">Entrer votre nom :</label> 
					<input type="text" name="nom" id="nom" placeholder="Nom" />
				</p>
				<p>
					<label for="prenom">Entrer votre prenom :</label> 
					<input type="text" name="prenom" id="prenom" placeholder="Prenom" />
				</p>
				<p>
					<label for="fonction">Entrer votre fonction :</label> 
					<input type="text" name="fonction" id="fonction" placeholder="Fonction" />
				</p>
				<p>
					<label for="salaire">Entrer votre salaire :</label> 
					<input type="number" name="salaire" id="salaire" placeholder="Salaire" />
				</p>
				<input type="submit" />
			</form>
		</section>
		<section class="List-employes">
			<table>
				<c:forEach items="${ employes }" var="employe">
					<tr>
						<td><c:out value="${ employe.noEmploye }" /></td>
						<td><c:out value="${ employe.nom }" /></td>
						<td><c:out value="${ employe.prenom }" /></td>
						<td><c:out value="${ employe.fonction }" /></td>
						<td><c:out value="${ employe.salaire }" /></td>
					</tr>
				</c:forEach>
			</table>
		</section>
		<%-- <form action="/DAO/employe" method="post">
			<label for="employes"></label> <select name="employes">
				<c:forEach items="${ employes }" var="employe">
					<option value="<c:out value="${ employe.index }" />" />
					<c:out value="${ employe.current }" />
				</c:forEach>
			</select> <input type="submit" />
		</form>
		<c:if test="${ !empty noEmploye }">
			<p>Bonjour, votre employe prefere est :<c:out value="${ employes[noEmploye] }" />(id=<c:out value="${ noEmploye }"></c:out>)</p>
		</c:if> --%>
	</div>
</body>
</html>