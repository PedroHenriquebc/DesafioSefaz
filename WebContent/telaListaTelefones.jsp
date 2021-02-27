<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.model.Telefone"%>
<%@ page import="java.util.*"%>
<%
ArrayList<Telefone> lista = (ArrayList<Telefone>) request.getAttribute("listaTelefones");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Telefones</title>
</head>
<body>
<center>
<h1>Lista de telefones</h1>
<%for (int i = 0; i < lista.size(); i++){ %>

<table>
		<thead>
			<tr>
				<th>DDD</th>
				<th>Numero</th>
				<th>Tipo</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td><%=lista.get(i).getDdd()%></td>
				<td><%=lista.get(i).getNumero()%></td>
				<td><%=lista.get(i).getTipo()%></td>
				<td><a href="excluirTelefone?id=<%=lista.get(i).getId()%>" onclick="return deletar()" ><button>Excluir</button></a></td>
			</tr>
		
			
		</tbody>
	</table>
	
	
	<form name="frmAdicionar" action="adicionarTelefone">
		<table>
			<tr>
				<td><input type="hidden" value="<%=lista.get(i).getIdusuario()%>" name="idusuario"></td>
			</tr>
				<%} %>
				<h1>Adicionar Telefone</h1>
			<tr><tr>
				<td><input type="text" name="ddd" maxlength="2"
					placeholder="DDD" required name="ddd"></td>
				<td><input type="text" name="numero" maxlength="9"
					placeholder="Numero de telefone" required name="numero"></td>
			</tr>
			<tr>
				<td><select name="tipotelefone">
						<option value="Residencial">Residencial</option>
						<option value="Comercial">Comercial</option>
						<option value="Celular">Celular</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Adicionar"> <input type="button"
			value="Voltar" onclick="window.location.href='telaLogado.jsp';">

</body>
</center>
<script src="scripts/alerts.js"></script>
</html>