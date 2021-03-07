package model.vo;

import java.sql.Date;

public class PessoaVO {

	private int idPessoa;
	private String nome;
	private Date dtNascimento;
	private char sexo;
	private String cpf;
	private int reacao;
	
	public PessoaVO(int idPessoa, String nome, Date dtNascimento, char sexo, String cpf, int reacao) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.reacao = reacao;
	}

	public PessoaVO() {
		super();
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getReacao() {
		return reacao;
	}

	public void setReacao(int reacao) {
		this.reacao = reacao;
	}

	
}
