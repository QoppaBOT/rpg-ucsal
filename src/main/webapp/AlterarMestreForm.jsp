<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO ALTERAR MESTRE</h1>
	<form action="AlterarMestreServlet" method="post">
		<input type="hidden" name="id" value="${mestre.id}">
		Nome:<br> <input type="text" name="nome" value="${mestre.nome}"><br>
		Descrição:<br> <input type="text" name="descricao" value="${mestre.descricao}"><br>
		
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>