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
		ID_Mestre:<br> <input type="number" name="mestre"><br>
		Senha:<br> <input type="password" name="Senha"><br>
		Descri��o:<br> <input type="text" name="descricao"><br>
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>