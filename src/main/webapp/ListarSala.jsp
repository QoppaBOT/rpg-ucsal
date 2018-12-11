<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de Sala</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/css/app.css" rel="stylesheet">
	</head>
	<body>
<div>
<c:import url="topo.jsp"></c:import>
</div>
		<h3>lista de Sala</h3>
		<ul>
			<c:forEach var="sala" items="${sala}"> 
				Nome:<li>${sala.nome}</li>	<br>
				Descri��o:<li>${sala.descricao}</li>	<br>
				Mestre:<li>${sala.nome}</li>	<br>
				Dangeon:<li>${sala.nome}</li>	<br>
				
				<%-- <a href="AlterarSalaServlet?id=${sala.id}" type="submit">Editar</a> --%>
				<a href="DeletarSalaServlet?id=${sala.id}" type="submit">Excluir</a>
			</c:forEach>
		</ul>
			<div>
		<c:import url="rodape.jsp"></c:import>

	</div>
			<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>