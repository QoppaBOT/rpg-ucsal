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
	<h1>FORMULARIO ADICIONAR MESTRE</h1>
	<form action="AdicionarMestreServlet" method="post">
		Nome:<br> <input type="text" name="nome"><br>
		Descri��o:<br> <input type="text" name="descricao"><br>
	
		<input type="submit" value="Submit"><br>
	</form>

</body>
</html>