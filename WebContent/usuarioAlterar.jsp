<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.model.Usuario"%>
<%
Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Usuario</title>
</head>
<body>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/phone.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<center style="margin-top: 200px" >
<h1 class="display-4">Alteração de usuário</h1>
<form name="frmAlterar" action="alterar">
		<table>
			<tr>
				<td><input type="hidden" value="<%=usuario.getId()%>" name="id" ></td>
			</tr>
			<tr>
				<td><input type="text" value="<%=usuario.getNome()%>" name="nome"
					placeholder="Digite o novo nome" required name="nome"  class="Caixa"></td>
			</tr>
			<tr>
				<td><input type="email" value="<%=usuario.getEmail()%>" name="email"
					placeholder="Digite o novo email" required name="email" class="Caixa"></td>
			</tr>
			<tr>
				<td><input type="password"  value="<%=usuario.getSenha()%>" name="senha"
					placeholder="Digite sua senha" required name="senha" class="Caixa"></td>
			</tr>
		</table>
		<input type="submit" value="Finalizar" class="btn btn-success" style="margin-right:50px"> <input type="button"
			value="Voltar" onclick="window.location.href='telaLogado.jsp';" class="btn btn-secondary">
	</form>
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>