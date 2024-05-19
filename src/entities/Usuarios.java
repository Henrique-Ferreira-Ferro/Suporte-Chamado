package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
	private int id;
	private String name;
	private String senha;
	private String email;
	private String nivel;
	private String login;
	
	//Um funcionario pertence a um departamento
	private Departamento departamento;

	//Um usuario pode realizar varios chamados
	private List<Chamado> chamados = new ArrayList<>();
	
	
	public Usuarios() {
		
	}

	public Usuarios(String name, String senha, String email, String posicao, String login) {
		this.name = name;
		this.senha = senha;
		this.email = email;
		this.nivel = posicao;
		this.login = login;
	}


	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPosicao() {
		return nivel;
	}


	public void setPosicao(String posicao) {
		this.nivel = posicao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<Chamado> getChamados() {
		return chamados;
	}
	
	public void setChamados(Chamado chamado) {
		chamados.add(chamado);
	}
	
	
}
