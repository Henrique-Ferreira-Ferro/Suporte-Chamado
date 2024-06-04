package services;

import javax.swing.JTable;

import dao.UsuarioDAO;
import entities.Usuario;

public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	//Feito
	public boolean registrarUsuario(Usuario usuario) {
		return usuarioDAO.adicionarUsuario(usuario);
	}
	
	
	public void pesquisaAvancada(String nome, JTable tabela) {
		usuarioDAO.pesquisaAvancada(nome, tabela);
	}
	
	
	public boolean deletarUsuario(int id) {
		return usuarioDAO.deletarUsuario(id);
	}
	
	
	public boolean atualizarUsuario(Usuario usuario) {
		return usuarioDAO.atualizarUsuario(usuario);
	}
	
}
