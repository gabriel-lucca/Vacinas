package model.vo;

import java.sql.Date;

public class VacinaVO {

	
	private int idVacina;
	private String paisOrigem;
	private String estagioPesquisa;
	private Date inicioPesquisa;
	private String nomePesquisador;
	private String fase;
	
	public VacinaVO(int idVacina, String paisOrigem, String estagioPesquisa, Date inicioPesquisa,
			String nomePesquisador, String fase) {
		super();
		this.idVacina = idVacina;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.inicioPesquisa = inicioPesquisa;
		this.nomePesquisador = nomePesquisador;
		this.fase = fase;
	}

	public VacinaVO() {
		super();
	}

	public int getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(String estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public Date getInicioPesquisa() {
		return inicioPesquisa;
	}

	public void setInicioPesquisa(Date inicioPesquisa) {
		this.inicioPesquisa = inicioPesquisa;
	}

	public String getNomePesquisador() {
		return nomePesquisador;
	}

	public void setNomePesquisador(String nomePesquisador) {
		this.nomePesquisador = nomePesquisador;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}
	
	
	
	
}
