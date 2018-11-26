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
		<h3>lista de Sala</h3>
		<ul>
			<c:forEach var="sala" items="${sala}"> 
				Nome:<li>${sala.nome}</li>
				Descrição:<li>${sala.descricao}</li>
				Mestre:<li>${sala.nome}</li>
				Dangeon:<li>${sala.nome}</li>
				
				<%-- <a href="AlterarSalaServlet?id=${sala.id}" type="submit">Editar</a> --%>
				<a href="DeletarSalaServlet?id=${sala.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
	</body>
</html>