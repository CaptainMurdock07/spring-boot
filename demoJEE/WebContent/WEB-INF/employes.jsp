<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
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
	</div>
</body>
</html>