<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>
	<h1>Login</h1>
	
	<form name="frmLogin" action="login">
		<table>
			<tr>
				<td><input type="email" name="email"
					placeholder="Digite seu email" required name="email"></td>
			</tr>
			<tr>
				<td><input type="password" name="senha"
					placeholder="Digite sua senha" required name="senha"></td>
			</tr>
		</table>
		<input type="submit" value="Entrar"> <input type="button" value="Cadastrar" onclick="window.location.href='usuarioCadastrar.jsp';">

	</form>
	</center>
</body>
</html>