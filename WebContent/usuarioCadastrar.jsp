<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>
</head>
<body>
<center>
	<h1>Cadastro de Usuario</h1>
	<form name="frmCadastro" action="cadastrar">
		<table>
			<tr>
				<td><input type="text"  name="nome"
					placeholder="Digite seu nome" required name="nome"></td>
			</tr>
			<tr>
				<td><input type="email" name="email"
					placeholder="Digite seu email" required name="email"></td>
			</tr>
			<tr>
				<td><input type="password" name="senha"
					placeholder="Digite sua senha" required name="senha"></td>
			</tr>
			
			<tr>
				<td><input type="text" name="ddd" maxlength="2" placeholder="DDD" required name="ddd"></td>
				<td><input type="text" name="numero" maxlength="9" placeholder="Numero de telefone" required name="numero"></td>
			</tr>
			<tr>
			<td>
			<select name="tipotelefone" >
			<option value="Residencial">Residencial</option>
			<option value="Comercial">Comercial</option>
			<option value="Celular">Celular</option>
			</select>
			</td>
			</tr>
		</table>
		<input type="submit" value="Finalizar"> <input type="button"
			value="Voltar" onclick="window.location.href='index.jsp';">
	</form>
	</center>
</body>
</html>