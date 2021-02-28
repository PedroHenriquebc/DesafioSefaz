<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/phone.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>
</head>
<body>
<center style="margin-top: 200px" >
	<h1 class="display-3">Cadastro de Usuário</h1>
	<form name="frmCadastro" action="cadastrar">
		<table>
			<tr>
				<td><input type="text"  name="nome"
					placeholder="Nome" required name="nome" class=Caixa></td>
			</tr>
			<tr>
				<td><input type="email" name="email"
					placeholder="Email" required name="email" class=Caixa></td>
			</tr>
			<tr>
				<td><input type="password" name="senha"
					placeholder="Senha" required name="senha" class=Caixa></td>
			</tr>
			
			<tr>
				<td><input type="text" name="ddd" maxlength="2" placeholder="DDD" required name="ddd" class=CaixaDDD></td>
			</tr>
			<tr>
				<td><input type="text" name="numero" maxlength="9" placeholder="Número de telefone" required name="numero" class=Caixa></td>
			</tr>
			<tr>
			<td>
			<select name="tipotelefone" class="Select">
			<option value="Residencial">Residencial</option>
			<option value="Comercial">Comercial</option>
			<option value="Celular">Celular</option>
			</select>
			</td>
			</tr>
		</table>
		<input type="submit" value="Finalizar" class="btn btn-success" style="margin-right:50px"> <input type="button"
			value="Voltar" onclick="window.location.href='index.jsp';" class="btn btn-secondary">
	</form>
	</center>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>