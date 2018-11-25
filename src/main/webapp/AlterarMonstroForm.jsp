<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ALTERAR MONSTRO</h1>
	<form action="AlterarMonstroServlet" method="post">
		<input type="hidden" name="id" value="${monstro.id}">
		Nome:<br> <input type="text" name="nome" value="${monstro.nome}"><br>
		pontos De Vida:<br> <input type="text" name="pontosDeVida" value="${monstro.pontosDeVida}"><br>
		Descrição:<br> <input type="text" name="descricao" value="${monstro.descricao}"><br>
		
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>