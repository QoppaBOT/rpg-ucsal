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
	<h1>FORMULARIO ALTERAR PERSOANGEM</h1>
	<form action="AlterarPersonagemServlet" method="post">
		<input type="hidden" name="id" value="${monstro.id}">
		pontos De Vida:<br> <input type="text" name="pontosDeVida" value="${monstro.pontosDeVida}"><br>
		Descri��o:<br> <input type="text" name="descricao" value="${monstro.descricao}"><br>
	
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>