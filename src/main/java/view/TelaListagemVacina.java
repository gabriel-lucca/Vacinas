package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import controller.ControladoraVacina;
import model.vo.VacinaVO;

public class TelaListagemVacina extends JFrame {

	private JPanel contentPane;
	private JTable tblVacinas;
	private JButton btnExcluirVacina;
	private JButton btnEditarVacina;
	private ControladoraVacina controlador = new ControladoraVacina();
	private String[] nomesColunas = { "id", "país", "nome", "responsável", "qntdDoses" };
	private JButton btnExcluir;
	private JButton btnEditar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemVacina frame = new TelaListagemVacina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListagemVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar todas");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//atualizarTabelaVacinas();
			}

		
			}
		);
		btnConsultar.setBounds(217, 11, 141, 23);
		contentPane.add(btnConsultar);
		

		btnExcluir = new JButton("Excluir vacina");
		btnExcluir.setBounds(57, 254, 113, 23);
		contentPane.add(btnExcluir);
		
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int indiceSelecionadoNaTabela = tblVacinas.getSelectedRow();
				VacinaVO vacinaSelecionada = vacinas.get(indiceSelecionadoNaTabela - 1);

				String perguntaExclusao = "Deseja excluir o endereço: " + vacinaSelecionada.toString() + "?";
				
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, perguntaExclusao, "Está certo disso?", JOptionPane.YES_NO_OPTION);

				if(opcaoSelecionada == JOptionPane.YES_OPTION) {
					String mensagem = controlador.excluir(vacinaSelecionada.getIdVacina());
					JOptionPane.showMessageDialog(null, mensagem);
					//atualizarTabelaEnderecos();
				}
			}
		});
		
		contentPane.add(btnExcluir);
		
		btnEditar = new JButton("Editar vacina");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VacinaVO vacinaSelecionada = vacinas.get(tblVacinas.getSelectedRow() - 1);
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(251, 254, 119, 23);
		contentPane.add(btnEditar);
	
		
		tblVacinas = new JTable();
		this.limparTabelaVacinas();
		
		tblVacinas = new JTable(tblVacinas.getModel()) {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tblVacinas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int indiceSelecionado = tblVacinas.getSelectedRow();
				
				if (indiceSelecionado > 0) {
					btnEditar.setEnabled(true);
					btnExcluir.setEnabled(true);
				} else {
					btnEditar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		
		tblVacinas.setBounds(10, 45, 415, 175);
		contentPane.add(tblVacinas);

	}
	
	protected void atualizarTabelaVacinas() {
		vacinas = controladoraVacina.consultarTodos();
		this.limparTabelaEnderecos();
		
		DefaultTableModel model = (DefaultTableModel) this.tblVacinas.getModel();
		
		for(VacinaVO end: this.vacinaVO) {
			Object[] novaLinhaTabela = new Object[5];
			String cepFormatado = end.getCep().substring(0, 5) + "-" + end.getCep().substring(5, 8);
			
			novaLinhaTabela[0] = cepFormatado;
			novaLinhaTabela[1] = end.getCidade();
			novaLinhaTabela[2] = end.getUf();
			novaLinhaTabela[3] = end.getNumero();
			novaLinhaTabela[4] = end.getLogradouro();
			
			model.addRow(novaLinhaTabela);
		}
	}

	protected void limparTabelaVacinas() {
		//Cria as colunas
		tblVacinas.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}