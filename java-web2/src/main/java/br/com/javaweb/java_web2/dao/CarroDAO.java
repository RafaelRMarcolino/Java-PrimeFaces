package br.com.javaweb.java_web2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.javaweb.java_web2.entity.Carro;
import br.com.javaweb.java_web2.utils.FabricaConexao;

public class CarroDAO {
	
	//            conexao.commit();
//					"INSERT INTO `sistema-carros`.`carro`(`modelo`,`fabricante`,`cor`,`ano`)VALUES(?,?,?,?)");


	public void salvar(Carro carro) {

		try {

			Connection conexao = FabricaConexao.getConexao();
			System.out.println(" passou pelo try do salvar");
			PreparedStatement ps = conexao.prepareCall("INSERT INTO carro (modelo, fabricante, cor, ano)VALUES(?,?,?,?)");
			ps.setString(1, carro.getModelo());
			System.out.println(ps + " ps");
			ps.setString(2, carro.getFabricante());
			ps.setString(3, carro.getCor());
			ps.setDate(4, new Date(carro.getAno().getTime()));
			
			
			ps.execute();
			conexao.setAutoCommit(false);
			FabricaConexao.fecharConexao();

		} catch (SQLException ex) {
			Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

}
