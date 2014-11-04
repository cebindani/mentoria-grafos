package br.maila.grafos.problemaContato;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProblemaContatoTest {

	private final static int[][] primeiroCenario = {
		{0,1,1,0,0,0},
		{1,0,0,1,0,0},
		{0,0,0,0,0,1},
		{0,1,0,0,0,0},
		{0,0,1,1,0,1},
		{1,0,0,0,0,0}
	};

	private ProblemaContato problemaContato;

	@Before
	public void before() {
		problemaContato = new ProblemaContato(primeiroCenario);
	}

	@Test
	public void descobrePesosTest() {
		assertEquals(new Integer(0), problemaContato.getPesoColunas().get(4));
		assertEquals(new Integer(2), problemaContato.getPesoColunas().get(0));
		assertEquals(new Integer(2), problemaContato.getPesoColunas().get(1));
		assertEquals(new Integer(2), problemaContato.getPesoColunas().get(2));
		
		assertEquals(new Integer(1), problemaContato.getPesoLinhas().get(2));
	}

	@Test
	public void encontraColunaVazia() {
		List<Integer> colunasMaisLeves = problemaContato.obterColunasMaisLeves();
		assertEquals(1, colunasMaisLeves.size());
		assertEquals(new Integer(4), colunasMaisLeves.get(0));
	}

	@Test
	public void encontraSegundaColunaMaisLeveComLinhaERemove() {
		problemaContato.removerColuna(4);
		List<Integer> colunasMaisLeves = problemaContato.obterColunasMaisLeves();
		assertEquals(5, colunasMaisLeves.size());
		assertEquals(2, problemaContato.obterLinhaMaisLeve(colunasMaisLeves));
		
		// todo implementar remove linha e coluna, test linha e colunas removidas
		// todo implementar alg que remove linha e coluna na ordem certa
		// todo teste que ve que as linhas e colunas removidas estao na ordem certa
		// todo implementar brow que resolve os paranaue
		// (6,1)(4,2)(2,4)...
	}
	
}
