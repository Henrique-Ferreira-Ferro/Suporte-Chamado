package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {
	
	public static Connection conector() {
		
		Connection con = null;
		String path = "jdbc:mysql://localhost:3306/suporte";
		String nome = "root";
		String senha = "46182001";
		
		try {
			con = DriverManager.getConnection(path,nome,senha);
			return con;
		}catch(SQLException e) {
			return null;
		}
		
	}
}
