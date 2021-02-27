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
	
	//POST
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
	
	public ArrayList<Telefone> listaTelefonesById(int id) {
		ArrayList<Telefone> listatelefones = new ArrayList<>();
		String telefones = "select * from telefones where id = ?";
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
}
