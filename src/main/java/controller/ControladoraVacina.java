package controller;

import java.util.List;

import model.bo.VacinaBO;
import model.dao.VacinaDAO;
import model.vo.SeletorVacinaVO;
import model.vo.VacinaVO;

public class ControladoraVacina {

	public String cadastrarVacinaController(VacinaVO vacinaVO) {
		VacinaBO vacinaBO = new VacinaBO();
		return vacinaBO.cadastrarVacinaBO(vacinaVO);
	}
	
	public String atualizarVacina(VacinaVO AtualizarVacina) {
		VacinaBO vacinaBO = new VacinaBO();
		return vacinaBO.atualizarVacinaBO(AtualizarVacina);
	}

	public String excluirVacinaController(VacinaVO vacinaVO) {
		VacinaBO vacinaBO = new VacinaBO();
		return vacinaBO.excluirVacinaBO(vacinaVO);
	}

	public List<VacinaVO> consultarVacinaController() {
		VacinaBO vacinaBO = new VacinaBO();
		return vacinaBO.consultarTodasVacinas();
	}

	public List<VacinaVO> consultarVacinaController(SeletorVacinaVO seletor) {
		VacinaDAO vacinaDAO = new VacinaDAO();
		return vacinaDAO.consultarTodasVacinasComSeletor(seletor);
	}
}
