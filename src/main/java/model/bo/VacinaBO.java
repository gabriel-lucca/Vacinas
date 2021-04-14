package model.bo;

import java.util.List;

import model.vo.VacinaVO;
import model.dao.VacinaDAO;

public class VacinaBO {


	public String cadastrarVacinaBO(VacinaVO vacinaVO) {
		String retorno = "Erro ao verificar validação de Cadastro";
		VacinaDAO vacinaDAO = new VacinaDAO();
		
		VacinaVO verificar = vacinaDAO.consultarVacinaPorNomeAndPais(vacinaVO);
		
		if (verificar.getPesquisadorResponsavel() > 0) {
			if (verificar.getIdVacina() != null && verificar.getIdVacina() != 0) {
				retorno =  "Nome da Vacina já existente no pais, por favor escolha outro nome.";
			} else {
				if (vacinaDAO.cadastrarVacina(vacinaVO) != null) {
					retorno = "Vacina cadastrada com sucesso.";
				} else {
					retorno = "Não foi possivel cadastrar vacina.";
				}
			}
		} else {
			retorno = "É necessário cadastrar um pesquisador responsável primeiro";
		}
		
		return retorno;
	}

	public String excluirVacinaBO(VacinaVO vacinaVO) {
		String retorno = "Erro ao verificar validação de exclusão";
		VacinaDAO vacinaDAO = new VacinaDAO();
		
		VacinaVO verificar = vacinaDAO.consultarVacinaPorNomeAndPais(vacinaVO);
		
		if (verificar.getIdVacina() != null) {
			if (vacinaDAO.excluirVacina(verificar.getIdVacina())) {
				retorno = "Vacina excluida com sucesso.";
			} else {
				retorno = "Não foi possivel excluir a vacina.";
			}
		} else {
			retorno = "Vacina ainda não foi cadastrada no banco.";
		}

		return retorno;
	}

	public List<VacinaVO> consultarTodasVacinas() {
		VacinaDAO vacinaDAO = new VacinaDAO();
		return vacinaDAO.consultarTodasVacinas();
	}
	
	

	public String atualizarVacinaBO(VacinaVO vacinaVO) {
		String retorno = "Erro ao verificar validação de atualização";
		VacinaDAO vacinaDAO = new VacinaDAO();
		
		VacinaVO atualizar = vacinaDAO.consultarVacinaPorNomeAndPais(vacinaVO);
		
		if (atualizar.getIdVacina() != null) {
			if (vacinaDAO.atualizarVacina(atualizar.getIdVacina())) {
				retorno = "Vacina atualizada com sucesso.";
			} else {
				retorno = "Não foi possivel atualizar a vacina.";
			}
		} else {
			retorno = "Vacina ainda não foi atualizada no banco.";
		}

		return retorno;
	}
}