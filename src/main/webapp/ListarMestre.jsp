<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de mestre</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/css/app.css" rel="stylesheet">
	</head>
	<body>
<div>
<c:import url="topo.jsp"></c:import>
</div>
		<h3>lista de mestre</h3>
		<ul>
			<c:forEach var="mestre" items="${mestre}"> 
				Nome:<li>${mestre.nome}</li>	<br>
				Descricao:<li>${mestre.descricao}</li>		<br>		
				<a href="AlterarMestreServlet?id=${mestre.id}" type="submit">Editar</a>
				<a href="DeletarMestreServlet?id=${mestre.id}" type="submit">Excluir</a>
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