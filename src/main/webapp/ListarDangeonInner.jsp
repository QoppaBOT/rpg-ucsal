<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de Sala</title>
	</head>
	<body>
		<h3>lista de Sala Inner Join</h3>
		<ul>
			<c:forEach var="dangeon" items="${dangeon}"> 
				Nome Dangeon:<li>${dangeon.nome}</li>	<br>
				Nome Monstro:<li>${dangeon.monstro}</li>	<br>

			</c:forEach>
		</ul>
	</body>
</html>