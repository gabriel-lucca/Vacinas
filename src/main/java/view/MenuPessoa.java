package view;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPessoa {

	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRAR_PESSOA = 1;
	private static final int OPCAO_MENU_CONSULTAR_PESSOA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_PESSOA = 3;
	private static final int OPCAO_MENU_EXCLUIR_PESSOA = 4;
	private static final int OPCAO_MENU_PESSOA_VOLTAR = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODAS_PESSOAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_PESSOA = 2;
	private static final int OPCAO_MENU_CONSULTAR_PESSOAS_VOLTAR = 3;

	

		public void apresentarMenuPessoa() {
			int opcao = this.apresentarOpcoesMenu();
			while(opcao != OPCAO_MENU_PESSOA_VOLTAR) {
				switch(opcao) {
				case OPCAO_MENU_CADASTRAR_PESSOA: {
					this.cadastrarPessoa();
					break;
				}
				case OPCAO_MENU_CONSULTAR_PESSOA: {
					this.consultarPessoa();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_PESSOA: {
					this.atualizarPessoa();
					break;
				}
				case OPCAO_MENU_EXCLUIR_PESSOA: {
					this.excluirPessoa();
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
			System.out.println("----Menu Pessoa----");
			System.out.println("\nOpcoes:");
			System.out.println(OPCAO_MENU_CADASTRAR_PESSOA + " - Cadastrar Pessoa");
			System.out.println(OPCAO_MENU_CONSULTAR_PESSOA + " - Consultar Pessoa");
			System.out.println(OPCAO_MENU_ATUALIZAR_PESSOA + " - Atualizar Pessoa");
			System.out.println(OPCAO_MENU_EXCLUIR_PESSOA + " - Excluir Pessoa");
			System.out.println(OPCAO_MENU_PESSOA_VOLTAR + " - Voltar");
			System.out.println("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
		}


		private void cadastrarPessoa() {
			// TODO Auto-generated method stub
			
		}




		private void consultarPessoa() {
			// TODO Auto-generated method stub
			
		}




		private void atualizarPessoa() {
			// TODO Auto-generated method stub
			
		}




		private void excluirPessoa() {
			// TODO Auto-generated method stub
			
		}




}
