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
			<c:forEach var="mestre" items="${mestre}"> 
				Nome:<li>${mestre.nome}</li>	<br>
				Descricao:<li>${mestre.descricao}</li>		<br>		
				<a href="AlterarMestreServlet?id=${mestre.id}" type="submit">Editar</a>
				<a href="DeletarMestreServlet?id=${mestre.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>