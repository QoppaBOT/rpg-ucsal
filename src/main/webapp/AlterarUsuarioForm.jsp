<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ALTERAR USUARIO</h1>
	<form action="AlterarUsuarioServlet" method="post">
		<input type="hidden" name="id" value="${usuario.id}">
		Nome:<br> <input type="text" name="nome" value="${usuario.nome}"><br>
		Senha:<br> <input type="password" name="senha" value="${usuario.senha}"><br>
		Email:<br> <input type="email" name="email" value="${usuario.email}"><br>
		
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>