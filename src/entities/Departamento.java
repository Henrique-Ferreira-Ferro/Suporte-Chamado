package entities;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	private int id;
	private String nome;
	
	private List<Usuarios> usuarios = new ArrayList<>();
	
	public Departamento() {
		
	}

	public Departamento(String nome, List<Usuarios> usuarios) {
		super();
		this.nome = nome;
		this.usuarios = usuarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios.add(usuarios);
	}
	
	
	
	
}
