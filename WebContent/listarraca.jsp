<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestão Fazenda - Listar Raças</title>
</head>
<body>
<c:forEach var="raca" items="${racas}">
	<p> ${raca.id} - ${raca.nome} <br>			
</c:forEach>
</body>
</html>