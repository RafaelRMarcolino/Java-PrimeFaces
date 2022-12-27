package br.com.javaweb.java_web2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FabricaConexao {
	
	//"jdbc:mysql://localhost:3312/sistema-carros"
	
	//jdbc:mysql://localhost/sistema-carros curso

	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:mysql://localhost:3312/sistema-carros";
	private static final String USUARIO = "root";
	private static final String SENHA = "95157535";

	public static String getUrlConexao() {
		return URL_CONEXAO;
	}

	public static String getUsuario() {
		return USUARIO;
	}

	public static String getSenha() {
		return SENHA;
	}

	public static Connection getConexao() {
		if (conexao == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			} catch (SQLException ex) {
				Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);

			} catch (ClassNotFoundException ex) {

				Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);

			}
		}
		return conexao;
	}

	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
				conexao = null;

			} catch (SQLException ex) {

				Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);

			}
		}
	}
}
