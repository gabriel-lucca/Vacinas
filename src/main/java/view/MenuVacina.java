package view;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVacina {

	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRAR_VACINA = 1;
	private static final int OPCAO_MENU_CONSULTAR_VACINA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_VACINA = 3;
	private static final int OPCAO_MENU_EXCLUIR_VACINA = 4;
	private static final int OPCAO_MENU_VACINA_VOLTAR = 5;



		public void apresentarMenuVacina() {
			int opcao = this.apresentarOpcoesMenu();
			while(opcao != OPCAO_MENU_VACINA_VOLTAR) {
				switch(opcao) {
				case OPCAO_MENU_CADASTRAR_VACINA: {
					this.cadastrarVacina();
					break;
				}
				case OPCAO_MENU_CONSULTAR_VACINA: {
					this.consultarVacina();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_VACINA: {
					this.atualizarVacina();
					break;
				}
				case OPCAO_MENU_EXCLUIR_VACINA: {
					this.excluirVacina();
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
			System.out.println("----Menu Vacina----");
			System.out.println("\nOpcoes:");
			System.out.println(OPCAO_MENU_CADASTRAR_VACINA + " - Cadastrar Vacina");
			System.out.println(OPCAO_MENU_CONSULTAR_VACINA + " - Consultar Vacina");
			System.out.println(OPCAO_MENU_ATUALIZAR_VACINA + " - Atualizar Vacina");
			System.out.println(OPCAO_MENU_EXCLUIR_VACINA + " - Excluir Vacina");
			System.out.println(OPCAO_MENU_VACINA_VOLTAR + " - Voltar");
			System.out.println("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
		}


		private void cadastrarVacina() {
			// TODO Auto-generated method stub
			
		}




		private void consultarVacina() {
			// TODO Auto-generated method stub
			
		}




		private void atualizarVacina() {
			// TODO Auto-generated method stub
			
		}




		private void excluirVacina() {
			// TODO Auto-generated method stub
			
		}




}
