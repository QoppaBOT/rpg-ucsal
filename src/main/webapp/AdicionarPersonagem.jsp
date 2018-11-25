<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ADICIONAR PERSONAGEM</h1>
	<form action="AdicionarMestreServlet" method="post">
		Nome:<br> <input type="text" name="nome"><br>
		Maior Personalidade:<br> <input type="text" name=maiorPersonalidade><br>
		Pontos de vida:<br> <input type="text" name="pontosDeVida"><br>
		Pontos de energia:<br> <input type="text" name="pontosDeEnergia"><br>
		xp:<br> <input type="text" name="xP"><br>
		level:<br> <input type="text" name="level"><br>
	Usuario:
	  <select name="usuario" >
		<option value="" selected>Selecione</option>
					<c:forEach var="usuario" items="${usuario}"> 
					<option value="${usuario.id}">${usuario.nome}</option>
			</c:forEach>
		</select>
	
		<br>
		Sala:
		  <select name="sala" >
		<option value="" selected>Selecione</option>
			<c:forEach var="sala" items="${sala}">
				<option value="${sala.id}">${sala.nome}</option>
			</c:forEach>
		</select>
	
		<br>
		Raca:
			  <select name="raca" >
		<option value="" selected>Selecione</option>
			<c:forEach var="raca" items="${raca}">
				<option value="${raca.id}">${raca.nome}</option>
			</c:forEach>
		</select>
	
		<br>
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>