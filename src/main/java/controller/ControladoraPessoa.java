package controller;

import model.bo.PessoaBO;
import model.vo.PessoaVO;

public class ControladoraPessoa {

	public PessoaVO consultarPessoaController(int idPessoa) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.consultarPessoaPorIdPessoa(idPessoa);
	}

	

}