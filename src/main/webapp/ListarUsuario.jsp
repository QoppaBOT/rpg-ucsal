<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de Usuario</title>
	</head>
	<body>
		<h3>lista de Usuario</h3>
		<ul>
			<c:forEach var="usuario" items="${usuario}"> 
				Nome:<li>${usuario.nome}</li>	<br>
				Email:<li>${usuario.email}</li>		<br>		
				<a href="AlterarUsuarioServlet?id=${usuario.id}" type="submit">Editar</a>
				<a href="DeletarUsuarioServlet?id=${usuario.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>