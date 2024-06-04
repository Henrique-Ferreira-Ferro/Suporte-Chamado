package entities;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	private int id;
	private String nome;
	
	//Um departamento possui muitos funcionarios
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Departamento() {
		
	}

	public Departamento(String nome, List<Usuario> usuarios) {
		super();
		this.nome = nome;
		this.usuarios = usuarios;
	}
	
	

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}
	
	
	
	
}
