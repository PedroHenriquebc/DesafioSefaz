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
<h1>Lista de telefones</h1>
<table>
		<thead>
			<tr>
				<th>DDD</th>
				<th>Numero</th>
				<th>Tipo</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++){ %>
			<tr>
				<td><%=lista.get(i).getDdd()%></td>
				<td><%=lista.get(i).getNumero()%></td>
				<td><%=lista.get(i).getTipo()%></td>
			</tr>
			<%} %>
			
		</tbody>
	</table>
	<a href="telaLogado.jsp">
   <button>Voltar</button>
	</a>
</body>
</html>