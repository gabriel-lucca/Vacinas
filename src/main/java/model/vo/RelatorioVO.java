package model.vo;

public class RelatorioVO {

	
	private int idRelatorio;
	private String relatorioNotas;
	private String relatorioPaises;
	private int qtdPessoasReceb;
	private String estagioAplicacao;
	
	public RelatorioVO(int idRelatorio, String relatorioNotas, String relatorioPaises, int qtdPessoasReceb,
		String estagioAplicacao) {
		super();
		this.idRelatorio = idRelatorio;
		this.relatorioNotas = relatorioNotas;
		this.relatorioPaises = relatorioPaises;
		this.qtdPessoasReceb = qtdPessoasReceb;
		this.estagioAplicacao = estagioAplicacao;
	}

	public int getIdRelatorio() {
		return idRelatorio;
	}

	public void setIdRelatorio(int idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public String getRelatorioNotas() {
		return relatorioNotas;
	}

	public void setRelatorioNotas(String relatorioNotas) {
		this.relatorioNotas = relatorioNotas;
	}

	public String getRelatorioPaises() {
		return relatorioPaises;
	}

	public void setRelatorioPaises(String relatorioPaises) {
		this.relatorioPaises = relatorioPaises;
	}

	public int getQtdPessoasReceb() {
		return qtdPessoasReceb;
	}

	public void setQtdPessoasReceb(int qtdPessoasReceb) {
		this.qtdPessoasReceb = qtdPessoasReceb;
	}

	public String getEstagioAplicacao() {
		return estagioAplicacao;
	}

	public void setEstagioAplicacao(String estagioAplicacao) {
		this.estagioAplicacao = estagioAplicacao;
	}
	
	


}
