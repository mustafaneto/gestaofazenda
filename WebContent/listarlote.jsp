<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestão Fazenda - Listar Lotes</title>
</head>
<body>
<c:forEach var="lote" items="${lotes}">
	<p> ${lote.id} - ${lote.nome} - ${lote.area} m² <br>			
</c:forEach>
</body>
</html>