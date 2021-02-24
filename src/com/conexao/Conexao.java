package com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/qualitibank?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}