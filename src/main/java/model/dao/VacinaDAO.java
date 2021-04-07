package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Enum.EstagioPesquisa;
import model.Enum.FaseVacina;
import model.vo.VacinaVO;

public class VacinaDAO {
	
	public VacinaVO cadastrarVacina(VacinaVO novaVacina) {
		String sql = " INSERT INTO VACINA ( NOME, PAIS_ORIGEM, ESTAGIO_PESQUISA, DATA_INICIO_PESQUISA,"
		+ " ID_PESQUISADOR_RESPONSAVEL, FASE, QUANTIDADE_DOSES)"
	    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
		
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, sql);) {
			stmt.setString(1, novaVacina.getNome());
			stmt.setString(2, novaVacina.getPaisDeOrigem());
			stmt.setString(3, novaVacina.getEstagioPesquisa().toString());
			stmt.setDate(4, java.sql.Date.valueOf(novaVacina.getDataInicioPesquisa()));
			stmt.setObject(5, novaVacina.getPesquisadorResponsavel());
			stmt.setString(6, novaVacina.getFase().toString());
			stmt.setInt(7, novaVacina.getQuantidadeDoses());			
			stmt.executeUpdate();
			
			ResultSet chavesgera = stmt.getGeneratedKeys();
			if (chavesgera.next()) {
				novaVacina.setIdVacina(chavesgera.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar vacina: \n " + e.getMessage());
		}
		return novaVacina;
	}
	
	
	public boolean atualizarVacina(VacinaVO atualizarVacina) {
		
		boolean atualizou = false;
		
		String sql = " UPDATE VACINA SET NOME = ?, PAIS_ORIGEM = ?, "
				+ "ESTAGIO_PESQUISA = ?, "
				+ "DATA_INICIO_PESQUISA = ?,"
				+ " ID_PESQUISADOR_RESPONSAVEL = ?, FASE = ?, QUANTIDADE_DOSES = ?, ATIVA = ?"
				+ " WHERE IDVACINA = ?";
		
		try (Connection conn = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);) {
			stmt.setString(1, atualizarVacina.getNome());
			stmt.setString(2, atualizarVacina.getPaisDeOrigem());
			stmt.setString(3, atualizarVacina.getEstagioPesquisa().toString());
			stmt.setDate(4, java.sql.Date.valueOf(atualizarVacina.getDataInicioPesquisa()));
			stmt.setObject(5, atualizarVacina.getPesquisadorResponsavel());
			stmt.setString(6, atualizarVacina.getFase().toString());
			stmt.setInt(7, atualizarVacina.getQuantidadeDoses());
			stmt.setInt(8, atualizarVacina.getIdVacina());			
			int quantidadeLinhas = stmt.executeUpdate();
			
			atualizou = quantidadeLinhas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar vacina: \n " + e.getMessage());
		}
		
		return atualizou;
	}
	
	
	public boolean excluirVacina(Integer idVacina) {
		
		boolean excluir = false;
		
		String sql = " DELETE FROM VACINA WHERE IDVACINA = ?";

		try (Connection conn = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);) {

			stmt.setInt(1, idVacina);
			excluir = stmt.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina: \n " + e.getMessage());
		}

		return excluir;
	}
	
	
	public VacinaVO consultarVacinaPorId(Integer idVacina) {
		
		VacinaVO vacinaConsultada = null;
		
		String sql = " SELECT * FROM VACINA WHERE IDVACINA = ?";
		
		try (Connection conn = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);) {
			stmt.setInt(1, idVacina);
			
			ResultSet resultadodaConsulta = stmt.executeQuery();
			
			if (resultadodaConsulta.next()) {
				vacinaConsultada = this.converterDoResultSet(resultadodaConsulta);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar vacina por IDVACINA: \n " + e.getMessage());
		}

		return vacinaConsultada;
	}

	
	public List<VacinaVO> consultarTodasVacinas() {
		
		List<VacinaVO> todasVacinas = new ArrayList<VacinaVO>();
		String sql = " SELECT * FROM VACINA";
		
		try (Connection conn = Banco.getConnection();
				PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);) {
	
			ResultSet resultadoConsulta = stmt.executeQuery();
			while (resultadoConsulta.next()) {
				
				VacinaVO vacina = this.converterDoResultSet(resultadoConsulta);			
				todasVacinas.add(vacina);
				}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas as vacinas: \n " + e.getMessage());
		}

		return todasVacinas;
	}

	private VacinaVO converterDoResultSet(ResultSet resultadoConsulta) throws SQLException {
		VacinaVO vacinaConsultada = new VacinaVO();
		vacinaConsultada.setIdVacina(resultadoConsulta.getInt("idVacina"));
		vacinaConsultada.setNome(resultadoConsulta.getString("nome"));
		vacinaConsultada.setPaisDeOrigem(resultadoConsulta.getString("PAIS_ORIGEM"));
		vacinaConsultada.setEstagioPesquisa(EstagioPesquisa.getEstagioPesquisa(resultadoConsulta.getString("ESTAGIO_PESQUISA")));
		vacinaConsultada.setDataInicioPesquisa(resultadoConsulta.getDate("DATA_INICIO_PESQUISA").toLocalDate());
		vacinaConsultada.setPesquisadorResponsavel(resultadoConsulta.getInt("ID_PESQUISADOR_RESPONSAVEL"));
		vacinaConsultada.setFase(FaseVacina.getFaseVacina(resultadoConsulta.getString("fase")));
		vacinaConsultada.setQuantidadeDoses(resultadoConsulta.getInt("QUANTIDADE_DOSES"));
		
		return vacinaConsultada;
	}
	
	
	public VacinaVO consultarVacinaPorNomeAndPais(VacinaVO vacinaVO) {
		
		String sql = " SELECT * FROM VACINA WHERE UPPER(NOME) = ? AND UPPER(PAIS_ORIGEM) = ? ";
		
		try (Connection conn = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);) {
			stmt.setString(1, vacinaVO.getNome());
			stmt.setString(2, vacinaVO.getPaisDeOrigem());
			
			ResultSet resultadoconsulta = stmt.executeQuery();

			if (resultadoconsulta.next()) {
				vacinaVO = this.converterDoResultSet(resultadoconsulta);
				}
			
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas as vacinas: \n " + e.getMessage());
		}
		return vacinaVO;
	}
}