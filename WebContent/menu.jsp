<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestão Fazenda - Menu Principal</title>
</head>
<body>
<p> Usuário: ${pecuarista.nome} <br> <br> <br>
	
<a href="/gestaofaz/frmraca.html"> Registrar Raça </a> <br>
<a href="/gestaofaz/ServletRacaListar?nextPage=listarraca.jsp"> Listar Raça </a> <br>

<a href="/gestaofaz/frmlote.html"> Registrar Lote </a> <br>
<a href="/gestaofaz/ServletLoteListar?nextPage=listarlote.jsp"> Listar Lote </a> <br>

<a href="/gestaofaz/ServletRacaListar?nextPage=frmanimal.jsp"> Registrar Animal </a> <br>
<a href="/gestaofaz/ServletAnimalListar?nextPage=listaranimal.jsp"> Listar Animal </a> <br>


	
</body>
</html>