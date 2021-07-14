package br.com.alura.leilao.model;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

public class LeilaoTest extends TestCase {

    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario LEANDRINHO = new Usuario("Leandrinho");
    
    @Test
    public void testDeve_DevolveDescicao_QuandoRecebeDescricao() {
        // Executar ação esperada
        String descricaoDevolvida = CONSOLE.getDescricao();
        // Testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void testDeve_DevolveMaiorLance_ApenasUmLance(){
        CONSOLE.propoe(new Lance(LEANDRINHO, 200.0));
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLanceDevolvido,0.0001);

    }

    @Test
    public void testDeve__DevolveMaiorLance_QuandoRecebeDoisLancesDecrescentes() {
        CONSOLE.propoe(new Lance(LEANDRINHO, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Manu"), 9000.0));
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        assertEquals(10000.0,maiorLanceDevolvido);
    }

    @Test
    public void testDeve_DevolveMaiorLance_QuandoRecebeDoisLancesCrescentes() {
        CONSOLE.propoe(new Lance(LEANDRINHO, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Manu"), 200.0));
        double maiorLanceDevolvido = CONSOLE.getMaiorLance();
        assertEquals(200.0,maiorLanceDevolvido);
    }

    @Test
    public void testDeve_DevolveMenorLance_ApenasUmLance(){
        CONSOLE.propoe(new Lance(LEANDRINHO, 200.0));
        double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido,0.0001);

    }

    @Test
    public void testDeve__DevolveMenorLance_QuandoRecebeDoisLancesDecrescentes() {
        CONSOLE.propoe(new Lance(LEANDRINHO, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Manu"), 9000.0));
        double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(9000.0,menorLanceDevolvido);
    }

    @Test
    public void testDeve_DevolveMenorLance_QuandoRecebeDoisLancesCrescentes() {
        CONSOLE.propoe(new Lance(LEANDRINHO, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Manu"), 200.0));
        double menorLanceDevolvido = CONSOLE.getMenorLance();
        assertEquals(100.0,menorLanceDevolvido);
    }

    @Test
    public void testeDeve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){
        CONSOLE.propoe(new Lance(LEANDRINHO, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Manu"), 300.0));
        CONSOLE.propoe(new Lance(LEANDRINHO, 450.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(450.0, tresMaioresLancesDevolvidos.get(0).getValor());
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor());
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor());
    }

    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoNaoRecebeLances(){
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        assertEquals(0, tresMaioresLancesDevolvidos.size());
    }

    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeApenasUmLance(){
        CONSOLE.propoe(new Lance(LEANDRINHO, 200.0));
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        assertEquals(1, tresMaioresLancesDevolvidos.size());
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(0).getValor());

    }

    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeDoisLances(){
        CONSOLE.propoe(new Lance(LEANDRINHO, 200.0));
        CONSOLE.propoe(new Lance(LEANDRINHO, 350.0));
        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();
        assertEquals(2, tresMaioresLancesDevolvidos.size());
        assertEquals(350.0, tresMaioresLancesDevolvidos.get(0).getValor());
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(1).getValor());

    }

    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeMaisDeTresLances(){
        final Usuario MANU = new Usuario("Manu");

        CONSOLE.propoe(new Lance(LEANDRINHO, 200.0));
        CONSOLE.propoe(new Lance(LEANDRINHO, 350.0));
        CONSOLE.propoe(new Lance(MANU, 250.0));
        CONSOLE.propoe(new Lance(MANU, 150.0));
        List<Lance> tresMaioresLancesDevolvidosParaQuatroLances = CONSOLE.tresMaioresLances();
        assertEquals(3, tresMaioresLancesDevolvidosParaQuatroLances.size());
        assertEquals(350.0, tresMaioresLancesDevolvidosParaQuatroLances.get(0).getValor());
        assertEquals(250.0, tresMaioresLancesDevolvidosParaQuatroLances.get(1).getValor());
        assertEquals(200.0, tresMaioresLancesDevolvidosParaQuatroLances.get(2).getValor());

        CONSOLE.propoe(new Lance(MANU, 400.0));
        List<Lance> tresMaioresLancesDevolvidosParaCincoLances = CONSOLE.tresMaioresLances();
        assertEquals(3, tresMaioresLancesDevolvidosParaCincoLances.size());
        assertEquals(400.0, tresMaioresLancesDevolvidosParaCincoLances.get(0).getValor());
        assertEquals(350.0, tresMaioresLancesDevolvidosParaCincoLances.get(1).getValor());
        assertEquals(250.0, tresMaioresLancesDevolvidosParaCincoLances.get(2).getValor());


    }
}