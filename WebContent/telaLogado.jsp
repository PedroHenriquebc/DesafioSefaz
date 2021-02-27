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
<meta charset="ISO-8859-1">
<title>Lista Usuarios</title>
</head>
<body>
<table>
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
				<td><a href="telefones?idusuario=<%=lista.get(i).getId()%>"><button>Telefones</button></a>
					<a href="telaAlteracao?idusuario=<%=lista.get(i).getId()%>"><button>Alteração</button></a>
					<a href="excluir?idusuario=<%=lista.get(i).getId()%>" onclick="return excluir()" ><button>Excluir</button></a>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<a href="index.jsp">
   <button>Logout</button>
	</a>
</body>
<script src="scripts/alerts.js"></script>
</html>