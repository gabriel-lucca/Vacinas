package view;

import java.util.Scanner;

public class MenuRelatorio {

	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRAR_RELATORIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_RELATORIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RELATORIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_RELATORIO = 4;
	private static final int OPCAO_MENU_RELATORIO_VOLTAR = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODOS_RELATORIOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_RELATORIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_RELATORIOS_VOLTAR = 3;

		public void apresentarMenuRelatorio() {
			int opcao = this.apresentarOpcoesMenu();
			while(opcao != OPCAO_MENU_RELATORIO_VOLTAR) {
				switch(opcao) {
				case OPCAO_MENU_CADASTRAR_RELATORIO: {
					this.cadastrarRelatorio();
					break;
				}
				case OPCAO_MENU_CONSULTAR_RELATORIO: {
					this.consultarRelatorio();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_RELATORIO: {
					this.atualizarRelatorio();
					break;
				}
				case OPCAO_MENU_EXCLUIR_RELATORIO: {
					this.excluirRelatorio();
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
			System.out.println("----Menu Relatório----");
			System.out.println("\nOpcoes:");
			System.out.println(OPCAO_MENU_CADASTRAR_RELATORIO + " - Cadastrar Relatório");
			System.out.println(OPCAO_MENU_CONSULTAR_RELATORIO + " - Consultar Relatório");
			System.out.println(OPCAO_MENU_ATUALIZAR_RELATORIO + " - Atualizar Relatório");
			System.out.println(OPCAO_MENU_EXCLUIR_RELATORIO + " - Excluir Relatório");
			System.out.println(OPCAO_MENU_RELATORIO_VOLTAR + " - Voltar");
			System.out.println("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
		}


		private void cadastrarRelatorio() {
			// TODO Auto-generated method stub
			
		}




		private void consultarRelatorio() {
			// TODO Auto-generated method stub
			
		}




		private void atualizarRelatorio() {
			// TODO Auto-generated method stub
			
		}




		private void excluirRelatorio() {
			// TODO Auto-generated method stub
			
		}




}
