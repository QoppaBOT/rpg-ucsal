<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de mestre</title>
	</head>
	<body>
		<h3>lista de mestre</h3>
		<ul>
			<c:forEach var="sala" items="${sala}"> 
				<li>${raca.nome_id}</li>
				<a href="AlterarSalaServlet?id=${sala.id}" type="submit">Editar</a>
				<a href="DeletarSalaServlet?id=${sala.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>