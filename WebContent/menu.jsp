<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gest�o Fazenda - Menu Principal</title>
</head>
<body>
<p> Usu�rio: ${pecuarista.nome} <br> <br> <br>
	
<a href="/gestaofaz/frmraca.html"> Registrar Ra�a </a> <br>
<a href="/gestaofaz/ServletRacaListar?nextPage=listarraca.jsp"> Listar Ra�a </a> <br>

<a href="/gestaofaz/frmlote.html"> Registrar Lote </a> <br>
<a href="/gestaofaz/ServletLoteListar?nextPage=listarlote.jsp"> Listar Lote </a> <br>

<a href="/gestaofaz/ServletRacaListar?nextPage=frmanimal.jsp"> Registrar Animal </a> <br>
<a href="/gestaofaz/ServletAnimalListar?nextPage=listaranimal.jsp"> Listar Animal </a> <br>


	
</body>
</html>