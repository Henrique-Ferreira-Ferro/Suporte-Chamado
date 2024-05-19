package entities;

import java.util.Date;

public class Chamado {
	
	private int id;
	private String titulo;
	private String categoria;
	private String descricao;
	private String[] status = {"Aberto, Em andamento, Fechado"};
	private Date horaCriada;
	private String comentarios;
	
	
	//Um chamado é feito por um usuario
	private Usuarios usuario;
	
	public Chamado() {
		
	}

	public Chamado(int id, String titulo, String categoria, String descricao, String[] status, Date horaCriada,
			String comentarios, Usuarios usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descricao = descricao;
		this.status = status;
		this.horaCriada = horaCriada;
		this.comentarios = comentarios;
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	public Date getHoraCriada() {
		return horaCriada;
	}

	public void setHoraCriada(Date horaCriada) {
		this.horaCriada = horaCriada;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	
}	
