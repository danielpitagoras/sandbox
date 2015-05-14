package internetmotors.ocorrencia;

import java.util.*;

import internetmotors.util.DAOFactory;
import internetmotors.veiculo.Veiculo;

public class OcorrenciaRN {

	private OcorrenciaDAO ocorrenciaDAO;
	
	
	public OcorrenciaRN() {
		this.ocorrenciaDAO = DAOFactory.criarOcorrenciaDAO();
	}
	
	public void salvar(Ocorrencia ocorrencia) {
		
		//Checa se a km da ocorrência é maior que a do veículo e maior que a última cadastrada.
		if (this.ocorrenciaDAO.listarPorVeiculo(ocorrencia.getVeiculo()).isEmpty()) {
		
			if (ocorrencia.getQuilometragemTotal() >= ocorrencia.getVeiculo().getQuilometragem()) {
			
				this.ocorrenciaDAO.salvar(ocorrencia);
				
			} else {
				System.out.print("Erro KM da ocorrência menor do que a cadastrada no veículo");
			}
	
		} else if(ocorrencia.getQuilometragemTotal() >= ocorrencia.getVeiculo().getQuilometragem()) {
		
			if (ocorrencia.getQuilometragemTotal() >= this.ocorrenciaDAO.buscarUltimaPorVeiculo(ocorrencia.getVeiculo().getCodigo()).getQuilometragemTotal()) {
				this.ocorrenciaDAO.salvar(ocorrencia);
			} else {
				System.out.print("Erro KM da ocorrência menor do que a última ocorrência cadastrada");
			}

		} else {
			System.out.print("Erro KM da ocorrência menor do que a cadastrada no veículo");
		}

	}
	
	public void excluir(Ocorrencia ocorrencia) {
		//Checagem de data para permitir a exclusão
		this.ocorrenciaDAO.excluir(ocorrencia);
	}
	
	public Ocorrencia carregar(Integer codigo) {
		return this.ocorrenciaDAO.carregar(codigo);
	}
	
	public Ocorrencia buscarUltimaPorVeiculo(int codVeiculo) {
		return this.ocorrenciaDAO.buscarUltimaPorVeiculo(codVeiculo);
	}
	 
	public List<Ocorrencia> listarPorVeiculo(Veiculo veiculo) {
		return this.ocorrenciaDAO.listarPorVeiculo(veiculo);
	}
}
