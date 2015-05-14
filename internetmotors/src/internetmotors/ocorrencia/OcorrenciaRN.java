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
		
		//Checa se a km da ocorr�ncia � maior que a do ve�culo e maior que a �ltima cadastrada.
		if (this.ocorrenciaDAO.listarPorVeiculo(ocorrencia.getVeiculo()).isEmpty()) {
		
			if (ocorrencia.getQuilometragemTotal() >= ocorrencia.getVeiculo().getQuilometragem()) {
			
				this.ocorrenciaDAO.salvar(ocorrencia);
				
			} else {
				System.out.print("Erro KM da ocorr�ncia menor do que a cadastrada no ve�culo");
			}
	
		} else if(ocorrencia.getQuilometragemTotal() >= ocorrencia.getVeiculo().getQuilometragem()) {
		
			if (ocorrencia.getQuilometragemTotal() >= this.ocorrenciaDAO.buscarUltimaPorVeiculo(ocorrencia.getVeiculo().getCodigo()).getQuilometragemTotal()) {
				this.ocorrenciaDAO.salvar(ocorrencia);
			} else {
				System.out.print("Erro KM da ocorr�ncia menor do que a �ltima ocorr�ncia cadastrada");
			}

		} else {
			System.out.print("Erro KM da ocorr�ncia menor do que a cadastrada no ve�culo");
		}

	}
	
	public void excluir(Ocorrencia ocorrencia) {
		//Checagem de data para permitir a exclus�o
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
