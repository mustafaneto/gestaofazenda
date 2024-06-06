<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Pecuarista</title>
</head>
<body>
	<form action="/gestaofaz/ServletPecuaristaLogar" method="post">
		<label>Login:
			<input type="text" name="login"> <br>
		</label>
		
		<label>Senha: 
			<input type="password" name="senha"> <br>
		</label>
		
	<input type="submit">
	</form>
	<p> ${erro}
	<a href="/gestaofaz/frmpecuarista.html"> Registrar-se</a>
</body>
</html>

