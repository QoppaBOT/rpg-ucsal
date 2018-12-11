<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>FORMULARIO ALTERAR RACA</h1>
	<form action="AlterarRacaServlet" method="post">
		<input type="hidden" name="id" value="${raca.id}">
		Nome:<br> <input type="text" name="nome"  value="${raca.nome}"><br>
		Forca:<br> <input type="number" name="forca" value="${raca.forca}"><br>
		Destreza:<br> <input type="number" name="destreza" value="${raca.destreza}"><br>
		Constituicao:<br> <input type="number" name="contituicao" value="${raca.contituicao}"><br>
		Inteligencia:<br> <input type="number" name="inteligencia" value="${raca.inteligencia}"><br>
		Percepcao:<br> <input type="number" name="percepicao" value="${raca.percepicao}"><br>
		Carisma:<br> <input type="number" name="carisma" value="${raca.carisma}"><br>		
		
		<input type="submit" value="Submit"><br>
	</form>

		<div>
		<c:import url="rodape.jsp"></c:import>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>