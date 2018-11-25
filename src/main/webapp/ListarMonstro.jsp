<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de monstros</title>
	</head>
	<body>
		<h3>lista de monstros</h3>
		<ul>
			<c:forEach var="monstro" items="${monstro}"> 
				<li>${monstro.id}</li>
				Nome:<li>${monstro.nome}</li>	
				Descri��o:<li>${monstro.descricao}</li>			
				
				<a href="DeletarMonstroServlet?id=${monstro.id}" type="submit">Excluir</a>
<%-- 				<a href="AlterarMonstroServlet?id=${monstro.id}" type="submit">Alterar</a>
 --%>			</c:forEach>
		</ul>
	</body>
</html>