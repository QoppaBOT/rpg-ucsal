<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ADICIONAR Usuario</h1>
	<form action="AdicionarUsuarioServlet" method="post">
		Nome:<br> <input type="text" name="nome"><br>
		Senha:<br> <input type="text" name="senha"><br>
		E-mail:<br> <input type="text" name="email"><br>
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>