package model.bo;

import model.vo.PessoaVO;
import model.dao.PessoaDAO;

public class PessoaBO {

	public PessoaVO consultarPessoaPorIdPessoa(int idPessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		return pessoaDAO.consutarPessoaPorId(idPessoa, false);
	}

}