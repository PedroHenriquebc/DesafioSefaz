package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TelefoneDAO;
import com.dao.UsuarioDAO;
import com.model.Telefone;
import com.model.Usuario;

@WebServlet(urlPatterns = { "/UsuarioServlet", "/login", "/cadastrar", "/telaAlteracao", "/alterar", "/excluir",
		"/logout" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Telefone telefone = new Telefone();
	TelefoneDAO telefoneDao = new TelefoneDAO();

	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/login":
			validarLogin(request, response);
			break;
		case "/cadastrar":
			cadastrar(request, response);
			break;
		case "/telaAlteracao":
			telaAlteracao(request, response);
			break;
		case "/alterar":
			alterar(request, response);
			break;
		case "/excluir":
			excluir(request, response);
			break;
		case "/logout":
			logout(request, response);
		default:
			response.sendRedirect("index.jsp");
		}
	}

	protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		if (usuarioDao.existeUsuario(email, senha)) {
			int id = usuarioDao.lerIdByEmail(email);
			usuario = usuarioDao.lerUsuario(id);
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("telaLogado.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("telaFalhaLogin.jsp");
		}
	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipotelefone");
		if (usuarioDao.existeEmail(email)) {
			response.sendRedirect("telaFalhaCadastroEmail.jsp");
		} else if(telefoneDao.existeNumero(numero)) {
			response.sendRedirect("telaFalhaCadastroNumero.jsp");
		}else {
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuarioDao.inserirUsuario(usuario);
			telefone.setDdd(ddd);
			telefone.setNumero(numero);
			telefone.setTipo(tipo);
			telefoneDao.inserirTelefone(usuarioDao.lerIdByEmail(email), telefone); // Inserindo um telefone a um usuario
																					// que é selecionado no banco pelo
																					// email
																					// "usuarioDao.getUsuarioId(email)"
			response.sendRedirect("index.jsp");
		}
	}

	protected void telaAlteracao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idusuario"));
		usuario = usuarioDao.lerUsuario(id);
		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("usuarioAlterar.jsp");
		rd.forward(request, response);
	}

	protected void alterar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		usuarioDao.alterarUsuario(id, nome, email, senha);
		response.sendRedirect("telaLogado.jsp");
	}

	protected void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idusuario"));
		usuarioDao.deletarUsuario(id);
		response.sendRedirect("telaLogado.jsp");
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}