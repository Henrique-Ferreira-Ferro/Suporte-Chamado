package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao {
	
	public static Connection conector() {
		
		Connection con = null;
		String path = "jdbc:postgresql://localhost:5432/suporte";
		String nome = "postgres";
		String senha = "46182001";
		
		try {
			con = DriverManager.getConnection(path,nome,senha);
			return con;
		}catch(SQLException e) {
			return null;
		}
	}
	
	
}
