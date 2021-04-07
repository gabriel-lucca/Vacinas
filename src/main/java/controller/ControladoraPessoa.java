package controller;

import model.bo.PessoaBO;
import model.vo.PessoaVO;

public class ControladoraPessoa {

	public PessoaVO consultarPessoaController(PessoaVO pesquisadorInformadoPeloUsuario) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.consultarPessoaPorNomeAndCpfBO(pesquisadorInformadoPeloUsuario);
	}

	public int cadastrarPessoaController(PessoaVO pessoaVO) {
		PessoaBO pessoaBO = new PessoaBO();
		return pessoaBO.cadastrarPessoaBO(pessoaVO);
	}


	

}