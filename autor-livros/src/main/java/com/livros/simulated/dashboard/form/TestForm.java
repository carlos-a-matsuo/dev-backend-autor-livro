package com.livros.simulated.dashboard.form;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TestForm implements Serializable {

	private String autorCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inicial;

	private String dataLancamentoInicial = "01/08/2024";

	public String getDataLancamentoInicial() {
		return dataLancamentoInicial;
	}

	public void setDataLancamentoInicial(String dataLancamentoInicial) {
		this.dataLancamentoInicial = dataLancamentoInicial;
	}

	public Date getInicial() {
		return inicial;
	}

	public void setInicial(Date inicial) {
		this.inicial = inicial;
	}

	public String getAutorCode() {
		return autorCode;
	}

	public void setAutorCode(String autorCode) {
		this.autorCode = autorCode;
	}

}
