<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de Dangeon</title>
	</head>
	<body>
		<h3>lista de Dangeon</h3>
		<ul>
			<c:forEach var="dangeon" items="${dangeon}"> 
				<li>${dangeon.id}</li>
				Nome:<li>${dangeon.nome}</li>	
				Descrição:<li>${dangeon.descricao}</li>			
			<%--    <a href="AlterarDangeonServlet?id=${dangeon.id}" type="submit">Editar</a> --%>			
					<a href="DeletarDangeonServlet?id=${dangeon.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>