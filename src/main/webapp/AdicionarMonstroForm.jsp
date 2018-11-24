<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ADICIONAR MONSTRO</h1>
	<form action="AdicionarMonstroServlet" method="post">
		Nome:<br> <input type="text" name="nome"><br>
		Pontos De Vida:<br> <input type="text" name="pontosDeVida"><br>
		Descrição:<br> <input type="text" name="descricao"><br>
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>