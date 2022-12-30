package br.com.javaweb.java_web2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.javaweb.java_web2.entity.Carro;
import br.com.javaweb.java_web2.utils.FabricaConexao;

public class CarroDAO {

	// conexao.commit();
	// "INSERT INTO
	// `sistema-carros`.`carro`(`modelo`,`fabricante`,`cor`,`ano`)VALUES(?,?,?,?)");

	public void salvar(Carro carro) {

		try {

			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps;
			if (carro.getId() == null) {

				ps = conexao.prepareStatement("INSERT INTO carro (modelo, fabricante, cor, ano)VALUES(?,?,?,?)");

			}else {
				ps = conexao.prepareStatement("UPDATE `carro`SET `modelo`=?,`fabricante`=?, `cor`=? ,`ano`=? WHERE `id`=?");
				ps.setInt(5, carro.getId());
			}

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

	public List<Carro> buscar() {

		try {

			Connection conexao = FabricaConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement("select * from carro");
			ResultSet resultSet = ps.executeQuery();
			List<Carro> carros = new ArrayList<>();

			while (resultSet.next()) {
				Carro carro = new Carro();
				carro.setId(resultSet.getInt("id"));
				carro.setModelo(resultSet.getString("modelo"));
				carro.setFabricante(resultSet.getString("fabricante"));
				carro.setCor(resultSet.getString("cor"));
				carro.setAno(resultSet.getDate("ano"));
				carros.add(carro);

			}
			return carros;

		} catch (SQLException ex) {

			Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;

		}

	}

}
