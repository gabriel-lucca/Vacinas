package view;

import javax.swing.JOptionPane;

import util.StringUtil;

public class MenuRelatorio {

	private static final int OPCAO_RELATORIO_VACINA = 1;
	private static final int OPCAO_RELATORIO_VOLTAR = 2;

	public void apresentarMenuRelatorio() {
		int opcao = this.apresentarOpcoesMenu();
		while(opcao != OPCAO_RELATORIO_VOLTAR) {
			switch (opcao) {
				case OPCAO_RELATORIO_VACINA: {
					TelaListagemVacina telaListagemVacina = new TelaListagemVacina();
					telaListagemVacina.setVisible(true);
					opcao = OPCAO_RELATORIO_VOLTAR;
				break;
				}
				default: {
					JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
				}	
			}
		}
	}

	private int apresentarOpcoesMenu() {
		String mensagem = "";
		mensagem += "Opções:\n";
		mensagem += OPCAO_RELATORIO_VACINA + " - Relatório de todas vacinas ativas. \n";
		mensagem += OPCAO_RELATORIO_VOLTAR + " - Voltar\n";
		mensagem += "Digite a opção: \n";		
		
		String valorInformadoPeloUsuario = JOptionPane.showInputDialog(null, mensagem, "Menu Relatorio",
				JOptionPane.INFORMATION_MESSAGE);

		int opcaoSelecionada = StringUtil.formatarStringParaInteiro(valorInformadoPeloUsuario);
		
		if(opcaoSelecionada == StringUtil.VALOR_INVALIDO) {
			this.apresentarOpcoesMenu();
		}

		return opcaoSelecionada;
	}

}