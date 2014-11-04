package br.maila.grafos.problemaContato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProblemaContato {

	private int[][] matrizDeRelacaoContato;
	private Set<Integer> colunasRemovidas;
	private Set<Integer> linhasRemovidas;
	private Map<Integer, Integer> pesoLinhas;
	private Map<Integer, Integer> pesoColunas;

	public ProblemaContato() {
		colunasRemovidas = new HashSet<Integer>();
		linhasRemovidas = new HashSet<Integer>();
		pesoLinhas = new HashMap<Integer, Integer>();
		pesoColunas = new HashMap<Integer, Integer>();
	}

	public ProblemaContato(int[][] matrizDeRelacaoContato) {
		this();
		this.matrizDeRelacaoContato = matrizDeRelacaoContato;
		
		calculaPesoColunas(matrizDeRelacaoContato);
		calculaPesoLinhas(matrizDeRelacaoContato);
	}

	private void calculaPesoLinhas(int[][] matrizDeRelacaoContato) {
		for (int i = 0; i < matrizDeRelacaoContato.length; i++) {
			int peso = 0;
			for (int j = 0; j < matrizDeRelacaoContato[i].length; j++)
				peso += getMatrizDeRelacaoCotato()[i][j];
				
			pesoLinhas.put(i, peso);
		}
	}

	private void calculaPesoColunas(int[][] matrizDeRelacaoContato) {
		for (int j = 0; j < matrizDeRelacaoContato[0].length; j++) {
			int peso = 0;
			for (int i = 0; i < matrizDeRelacaoContato.length; i++)
				peso += getMatrizDeRelacaoCotato()[i][j];
				
			pesoColunas.put(j, peso);
		}
	}

	public List<Integer> obterColunasMaisLeves() {
		if (getMatrizDeRelacaoCotato() == null)
			return new ArrayList<Integer>(); 

		List<Integer> colunas = new ArrayList<Integer>();
		int pesoColunaMaisLeve = Integer.MAX_VALUE;
		for (Integer coluna : pesoColunas.keySet()) {
			if (colunasRemovidas.contains(coluna))
				continue;
			int peso = pesoColunas.get(coluna);
			if (peso < pesoColunaMaisLeve) {
				pesoColunaMaisLeve = peso;
				colunas.clear();
			}
			if (peso == pesoColunaMaisLeve)
				colunas.add(coluna);
		}

		return colunas;
	}


	public int obterLinhaMaisLeve(List<Integer> colunasMaisLeves) {

		int somaLinhaMaisLeve = Integer.MAX_VALUE;
		int linha=0;
		for (int i = 0; i < matrizDeRelacaoContato[0].length; i++) {
			
			if (linhasRemovidas.contains(i))
				continue;
			int soma = 0;
			for (int j = 0; j < matrizDeRelacaoContato.length; j++) {
				soma += getMatrizDeRelacaoCotato()[i][j];
			}
			if (soma < somaLinhaMaisLeve) {
				somaLinhaMaisLeve = soma;
				linha = i;
			}
							
		}
		return linha;
	}
	
	public int linhaEColunaRemovida(List<Integer> colunasMaisLeves) {
		int linha = obterLinhaMaisLeve(colunasMaisLeves);
		
		
		
		return null;
	}
	
	public int[][] getMatrizDeRelacaoCotato() {
		return matrizDeRelacaoContato;
	}

	public void setMatrizDeRelacaoCotato(int[][] matrizDeRelacaoCotato) {
		this.matrizDeRelacaoContato = matrizDeRelacaoCotato;
	}

	public Set<Integer> getColunasRemovidas() {
		return colunasRemovidas;
	}

	public void setColunasRemovidas(Set<Integer> colunasRemovidas) {
		this.colunasRemovidas = colunasRemovidas;
	}

	public Set<Integer> getLinhasRemovidas() {
		return linhasRemovidas;
	}

	public void setLinhasRemovidas(Set<Integer> linhasRemovidas) {
		this.linhasRemovidas = linhasRemovidas;
	}

	public void removerColuna(int coluna) {
		colunasRemovidas.add(coluna);
		pesoColunas.remove(coluna);
	}
	
	public void removerLinha(int linha, int coluna){
		linhasRemovidas.add(linha);
		colunasRemovidas.add(coluna);
		pesoColunas.remove(coluna);
	}

	
	public int[][] getMatrizDeRelacaoContato() {
		return matrizDeRelacaoContato;
	}

	public void setMatrizDeRelacaoContato(int[][] matrizDeRelacaoContato) {
		this.matrizDeRelacaoContato = matrizDeRelacaoContato;
	}

	public Map<Integer, Integer> getPesoLinhas() {
		return pesoLinhas;
	}

	public void setPesoLinhas(Map<Integer, Integer> pesoLinhas) {
		this.pesoLinhas = pesoLinhas;
	}

	public Map<Integer, Integer> getPesoColunas() {
		return pesoColunas;
	}

	public void setPesoColunas(Map<Integer, Integer> pesoColunas) {
		this.pesoColunas = pesoColunas;
	}

}
