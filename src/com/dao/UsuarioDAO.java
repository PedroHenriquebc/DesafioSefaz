package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.conexao.Conexao;
import com.model.Usuario;

public class UsuarioDAO {
	Conexao conexao = new Conexao();

	//LER USUARIO PELO ID
	public Usuario lerUsuario(int id) {
		Usuario usuario = new Usuario();
		String lerId = "select * from usuarios where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(lerId);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int idusuario = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				usuario.setId(idusuario);
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setSenha(senha);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}
	
	// CRIAR
	public void inserirUsuario(Usuario usuario) {
		String inserir = "insert into usuarios(nome, email, senha) values (?,?,?)";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(inserir);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	// ALTERAR
	public void alterarUsuario(int id, String novonome, String novoemail, String novasenha) {
		String alterar = "update usuarios set nome = ?, email = ?, senha = ? where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(alterar);
			pst.setString(1, novonome);
			pst.setString(2, novoemail);
			pst.setString(3, novasenha);
			pst.setInt(4, id);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	// DELETAR
	public void deletarUsuario(int id) {
		String deletartelefone = "delete from telefones where idusuario = ?";
		String deletar = "delete from usuarios where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst2 = con.prepareStatement(deletartelefone);
			pst2.setInt(1, id);
			pst2.executeUpdate();
 			PreparedStatement pst = con.prepareStatement(deletar);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// LISTAR USUARIOS
	public ArrayList<Usuario> listaUsuarios() {
		ArrayList<Usuario> listausuarios = new ArrayList<>();
		String usuarios = "select * from usuarios order by id";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(usuarios);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				listausuarios.add(new Usuario(id, nome, email, senha));
			}
			con.close();
			return listausuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// LER ID DE UM USUARIO ATRAVÉS DE EMAIL
	public int lerIdByEmail(String email) {
		int id = 0;
		String lerId = "select id from usuarios where email = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(lerId);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return id;
	}

	// CHECAR SE EXISTE UM USUARIO NO BANCO DE DADOS COM TAIS EMAIL && SENHA
	public boolean existeUsuario(String email, String senha) {
		boolean existe = false;
		String query = "select * from usuarios where email = ? and senha = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				existe = true;
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return existe;
	}

	// CHECAR SE EXISTE UM USUARIO NO BANCO DE DADOS COM TAL EMAIL
		public boolean existeEmail(String email) {
			boolean existe = false;
			String query = "select * from usuarios where email = ?";
			try {
				Connection con = conexao.conectar();
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, email);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					existe = true;
				}
			} catch (Exception e) {
				System.out.println(e);

			}
			return existe;
		}	
}
