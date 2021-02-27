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
<h1>Alteracao de usuario</h1>
<form name="frmAlterar" action="alterar">
		<table>
			<tr>
				<td><input type="hidden" value="<%=usuario.getId()%>" name="id"></td>
			</tr>
			<tr>
				<td><input type="text" value="<%=usuario.getNome()%>" name="nome"
					placeholder="Digite o novo nome" required name="nome" ></td>
			</tr>
			<tr>
				<td><input type="email" value="<%=usuario.getEmail()%>" name="email"
					placeholder="Digite o novo email" required name="email" ></td>
			</tr>
			<tr>
				<td><input type="password"  value="<%=usuario.getSenha()%>" name="senha"
					placeholder="Digite sua senha" required name="senha" ></td>
			</tr>
		</table>
		<input type="submit" value="Finalizar"> <input type="button"
			value="Voltar" onclick="window.location.href='telaLogado.jsp';">
	</form>
</body>
</html>