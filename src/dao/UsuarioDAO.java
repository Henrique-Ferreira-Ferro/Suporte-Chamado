package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import entities.Usuario;
import net.proteanit.sql.DbUtils;

public class UsuarioDAO {
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	/*
	 * Aplicando principios da orientação a objetos e praticas do mercado.
	 * Separando o que é interface, do que é logica e comunicação com o banco de dados
	 */
	public UsuarioDAO() {
		this.con = ModuloConexao.conector();
	}
	
	public boolean adicionarUsuario(Usuario usuario) {
		
		String sql = "INSERT INTO usuario (nomeUsu,senhaUsu, emailUsu, nivelUsu, loginUsu, idDepart) VALUES(?,?,?,?,?,?)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getName());
			pstm.setInt(2, usuario.getSenha());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getNivel());
			pstm.setString(5, usuario.getLogin());
			pstm.setInt(6, usuario.getDepartamento().getId());
			int linhaAcrecida = pstm.executeUpdate();
			if(linhaAcrecida > 0)
			return true;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir no banco de dados: " + e);
		}
		return false;
	}
		
	public boolean atualizarUsuario(Usuario usuario) {
		String sql = "UPDATE usuario SET nomeUsu = ?, senhaUsu = ?, emailUsu = ?, nivelUsu = ?, loginUsu = ?, idDepart = ? WHERE idUsu = ?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getName());
			pstm.setInt(2, usuario.getSenha());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getNivel());
			pstm.setString(5, usuario.getLogin());
			pstm.setInt(6, usuario.getDepartamento().getId());
			pstm.setInt(7, usuario.getId());
			int linhaAlterada = pstm.executeUpdate();
			if (linhaAlterada > 0)
			return true;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar no banco de dados: " + e);

		}
		return false;
	}
	
	public void pesquisaAvancada(String nome, JTable tabela) {
		String sql = "SELECT idUsu as ID, nomeUsu as Nome, senhaUsu as Senha,"
				+ " emailUsu as Email , nivelUsu as Nivel, loginUsu as Login, idDepart FROM usuario WHERE nomeUsu Like ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nome + "%");
			rs = pstm.executeQuery();
			tabela.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na pesquisa aplicada: " + e);
		}
		
	}
	
	
	public boolean deletarUsuario(int id) {
		String sql = "DELETE FROM usuario WHERE idUsu = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            int delete = stmt.executeUpdate();
            stmt.close();
            return delete > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao tentar apagar do banco. O Usuario já abriu um chamado e por isso não pode ser deletado!: " + e.getMessage());
            return false;
        }
		
	}
	
	
	
	
}
