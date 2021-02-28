package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.conexao.Conexao;
import com.model.Telefone;
import com.model.Usuario;

public class TelefoneDAO {
	Conexao conexao = new Conexao();
	
	//CRIAR
	public void inserirTelefone(int idusuario, Telefone telefone) {
		String inserir = "insert into telefones(ddd, numero, tipo, idusuario) values (?,?,?,?)";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(inserir);
			pst.setInt(1, telefone.getDdd());
			pst.setString(2, telefone.getNumero());
			pst.setString(3, telefone.getTipo());
			pst.setInt(4, idusuario);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//LISTAR TELEFONES
	public ArrayList<Telefone> listaTelefones() {
		ArrayList<Telefone> listatelefones = new ArrayList<>();
		String telefones = "select * from telefones order by id";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(telefones);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int ddd = rs.getInt("ddd");
				String numero = rs.getString("numero");
				String tipo = rs.getString("tipo");
				int idusuario = rs.getInt("idusuario");
				listatelefones.add(new Telefone(id, ddd, numero, tipo, idusuario));
			}
			con.close();
			return listatelefones;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//LISTAR TELEFONES DE ALGUM USUARIO
	public ArrayList<Telefone> listaTelefonesById(int id) {
		ArrayList<Telefone> listatelefones = new ArrayList<>();
		String telefones = "select * from telefones where idusuario = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(telefones);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int idtelefone = rs.getInt("id");
				int ddd = rs.getInt("ddd");
				String numero = rs.getString("numero");
				String tipo = rs.getString("tipo");
				int idusuario = rs.getInt("idusuario");
				listatelefones.add(new Telefone(idtelefone, ddd, numero, tipo, idusuario));
			}
			con.close();
			return listatelefones;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//DELETAR
	public void deletarTelefone(int id) {
		String deletar = "delete from telefones where id = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(deletar);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//EXISTE NUMERO
	public boolean existeNumero(String numero) {
		boolean existe = false;
		String existeNumero = "select * from telefones where numero = ?";
		try {
			Connection con = conexao.conectar();
			PreparedStatement pst = con.prepareStatement(existeNumero);
			pst.setString(1, numero);
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
