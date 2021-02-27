package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TelefoneDAO;
import com.dao.UsuarioDAO;
import com.model.Telefone;
import com.model.Usuario;


@WebServlet(urlPatterns={"/TelefoneServlet", "/telefones", "/adicionarTelefone", "/excluirTelefone"})
public class TelefoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Telefone telefone = new Telefone();
	TelefoneDAO telefoneDao = new TelefoneDAO();
	
    public TelefoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/telefones":
			listarTelefones(request, response);
			break;
		case "/adicionarTelefone":
			adicionarTelefone(request, response);
			break;
		case "/excluirTelefone":
			excluirTelefone(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");	
		}
	}


	protected void listarTelefones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idusuario"));
		ArrayList<Telefone> listaTelefones = telefoneDao.listaTelefonesById(id);
		request.setAttribute("listaTelefones", listaTelefones);
		RequestDispatcher rd = request.getRequestDispatcher("telaListaTelefones.jsp");
		rd.forward(request, response);
		}
	
	protected void adicionarTelefone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		telefone.setDdd(Integer.parseInt(request.getParameter("ddd")));
		telefone.setNumero(request.getParameter("numero"));
		telefone.setTipo(request.getParameter("tipotelefone"));
		telefoneDao.inserirTelefone(idusuario, telefone);
		response.sendRedirect("telaLogado.jsp");
	}
	
	protected void excluirTelefone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		telefoneDao.deletarTelefone(id);
		response.sendRedirect("telaLogado.jsp");
	}
}
