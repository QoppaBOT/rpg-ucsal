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
	<h1>FORMULARIO ALTERAR DANGEON</h1>
	<form action="AlterarDangeonServlet" method="post">
		<input type="hidden" name="id" value="${mestre.id}">
		Monstro:
	<select name="monstro" >
			<option value="" selected>Selecione</option>
			<c:forEach var="monstro" items="${lista}">
				<option value="${monstro.id}">${monstro.nome}</option>
			</c:forEach>
		</select>
		<br>
		Nome:<br> <input type="text" name="nome" value="${dangeon.nome}"><br>
		Descri��o:<br> <input type="text" name="descricao" value="${dangeon.descricao}"><br>
		
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>