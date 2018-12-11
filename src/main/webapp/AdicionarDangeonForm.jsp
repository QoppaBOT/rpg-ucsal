<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/css/app.css" rel="stylesheet">
</head>
<body>
<div>
<c:import url="topo.jsp"></c:import>
</div>
	<h1>FORMULARIO ADICIONAR DANGEON</h1>
	<form action="AdicionarDangeonServlet" method="post">
	Monstro:
	<select name="idMonstro">
			<option value="" selected>Selecione</option>
			<c:forEach var="monstro" items="${monstro}">
				<option value="${monstro.id}">${monstro.nome}</option>
			</c:forEach>
		</select>
		<br>
		Nome:<br> <input type="text" name="nome"><br>
		Descri��o:<br> <input type="text" name="descricao"><br>
	
		<input type="submit" value="Submit"><br>
	</form>
	<c:import url="rodape.jsp"></c:import>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>