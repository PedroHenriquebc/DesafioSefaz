package com.model;

//import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
//	private ArrayList<Telefone> telefones;
	
	//CONSTRUTORES
	public Usuario(int id,String nome, String email, String senha) {   //ArrayList<Telefone> telefones
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
//		this.telefones = telefones;
	}

	public Usuario() {
		super();
	}

		
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

//	public ArrayList<Telefone> getTelefones() {
//		return telefones;
//	}
//
//	public void setTelefones(ArrayList<Telefone> telefones) {
//		this.telefones = telefones;
//	}
	
	

}