<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/phone.png">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<center style="margin-top: 200px">
		<img src="imagens/agenda.png">
		<h1 class="display-2">Login</h1>
		<form name="frmLogin" action="login">
			<table>
				<tr>
					<td><input type="email" name="email"
						placeholder="Digite seu email" required name="email" class=Caixa></td>
				</tr>
				<tr>
					<td><input type="password" name="senha"
						placeholder="Digite sua senha" required name="senha" class=Caixa></td>
				</tr>
			</table>
			<input type="submit" value="Entrar" class="btn btn-success"
				style="margin-right: 50px"> <input
				type="button" value="Cadastrar"
				onclick="window.location.href='usuarioCadastrar.jsp';"
				class="btn btn-primary">

		</form>
</body>
</center>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
	crossorigin="anonymous"></script>
<script src="scripts/alerts.js"></script>
</html>