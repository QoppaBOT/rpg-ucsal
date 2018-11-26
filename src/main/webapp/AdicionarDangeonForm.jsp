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
		Descrição:<br> <input type="text" name="descricao"><br>
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>