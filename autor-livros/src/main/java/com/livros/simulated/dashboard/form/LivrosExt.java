package com.livros.simulated.dashboard.form;



public class LivrosExt {

	private String codigo;

	private String emissor;

	private String receptor;

	private boolean published;
	
	public LivrosExt() {
		
	}

	public LivrosExt(String codigo, String emissor, String recptor) {

		this.codigo = codigo;
		this.emissor = emissor;
		this.receptor = receptor;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

}