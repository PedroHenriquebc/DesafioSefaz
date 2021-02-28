<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.*"%>
<%@ page import="com.dao.*"%>
<%@ page import="java.util.*"%>
<%
UsuarioDAO usuarioDao = new UsuarioDAO();
ArrayList<Usuario> lista = usuarioDao.listaUsuarios();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/phone.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Lista Usuarios</title>
</head>
<body>
<center style="margin-top: 200px" >
<table id="tabela">
<h1 class="display-3">Usuários</h1>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++){ %>
			<tr>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><a href="telefones?idusuario=<%=lista.get(i).getId()%>"><button class="btn btn-primary" style="margin-right:15px"><img src="svg/telephone.svg" alt="Bootstrap" width="20" height="20"> Telefones</button></a> 
					<a href="telaAlteracao?idusuario=<%=lista.get(i).getId()%>"><button class="btn btn-warning" style="margin-right:15px"><img src="svg/pencil.svg" alt="Bootstrap" width="20" height="20"> Alterar</button></a>
					<a href="excluir?idusuario=<%=lista.get(i).getId()%>" onclick="return deletar()" ><button class="btn btn-danger" ><img src="svg/trash.svg" alt="Bootstrap" width="20" height="20"> Excluir</button></a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<a href="index.jsp">
   <button class="btn btn-secondary">Logout</button>
	</a>
	</center>
</body>
<script src="scripts/alerts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</html>