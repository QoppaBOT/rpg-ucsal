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
		<h3>lista de Sala Inner Join</h3>
		<ul>
			<c:forEach var="dangeon" items="${dangeon}"> 
				Nome Dangeon:<li>${dangeon.nome}</li>	<br>
				Nome Monstro:<li>${dangeon.monstro}</li>	<br>

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