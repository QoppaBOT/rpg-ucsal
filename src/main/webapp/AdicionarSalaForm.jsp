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
	<h1>FORMULARIO ADICIONAR SALA</h1>
	<form action="AdicionarSalaServlet" method="post">
		Nome:<br> <input type="text" name="nome"><br>
		Senha:<br> <input type="password" name="Senha"><br>
		Descrição:<br> <input type="text" name="descricao"><br>
		Mestre:
		<select name="mestre" >
			<option value="" selected>Selecione</option>
			<c:forEach var="mestre" items="${mestre}">
				<option value="${mestre.id}">${mestre.nome}</option>
			</c:forEach>
		</select>
		<br>
		Dangeon: 
		<select name="dangeon" >
			<option value="" selected>Selecione</option>
			<c:forEach var="dangeon" items="${dangeon}">
				<option value="${dangeon.id}">${dangeon.nome}</option>
			</c:forEach>
		</select>
		<br>
		
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>