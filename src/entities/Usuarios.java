package entities;

public class Usuarios {
	private int id;
	private String name;
	private String senha;
	private String email;
	private String posicao;

	private Departamento departamento;

	
	public Usuarios() {
		
	}

	public Usuarios(String name, String senha, String email, String posicao) {
		this.name = name;
		this.senha = senha;
		this.email = email;
		this.posicao = posicao;
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
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
	
}
