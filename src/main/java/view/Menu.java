package view;

import java.util.Scanner;

public class Menu {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_PESSOA = 1;
	private static final int OPCAO_MENU_VACINA = 2;
	private static final int OPCAO_MENU_RELATORIO = 3;
	private static final int OPCAO_MENU_SAIR = 4;


	public void apresentarMenu() {
		int opcao = this.apresentarOpcoesMenu();
		while(opcao != OPCAO_MENU_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_PESSOA: {
				MenuPessoa menuPessoa = new MenuPessoa();
				menuPessoa.apresentarMenuPessoa();
				break;
			}
			case OPCAO_MENU_VACINA: {
				MenuVacina menuVacina = new MenuVacina();
				menuVacina.apresentarMenuVacina();
				break;
			}
			case OPCAO_MENU_RELATORIO: {
				MenuRelatorio menuRelatorio = new MenuRelatorio();
				menuRelatorio.apresentarMenuRelatorio();
				break;
			}
			default: {
				System.out.println("\nOpcao inválida! ");
			}
			}
			
			opcao = this.apresentarOpcoesMenu();
		}
	}

	private int apresentarOpcoesMenu() {
		System.out.println("Controle de Vacinas da Covid-19");
		System.out.println("\nOpcoes:");
		System.out.println(OPCAO_MENU_PESSOA + " - Menu Pessoa");
		System.out.println(OPCAO_MENU_VACINA + " - Menu Vacina");
		System.out.println(OPCAO_MENU_RELATORIO + " - Menu Relatório");
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}