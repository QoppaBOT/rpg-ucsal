<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem de monstros</title>
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/css/app.css" rel="stylesheet">
	</head>
	<body>
<div>
<c:import url="topo.jsp"></c:import>
</div>
		<h3>lista de monstros</h3>
		<ul>
			<c:forEach var="monstro" items="${monstro}"> 
				<li>${monstro.id}</li>	<br>
				Nome:<li>${monstro.nome}</li>		<br>
				Descri��o:<li>${monstro.descricao}</li>		<br>		
				
				<a href="DeletarMonstroServlet?id=${monstro.id}" type="submit">Excluir</a>
				<a href="AlterarMonstroServlet?id=${monstro.id}" type="submit">Alterar</a>
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