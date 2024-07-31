package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioTec.digix.model.Dependente;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.builder.DependenteBuilderTest;
import desafioTec.digix.model.builder.FamiliaBuilderTest;

public class ObtemFamiliaTest {
    
    private CriterioFactory criterioFactory;
    private CalculadoraPontuacao calculadoraPontuacao;
    private IObtemFamilia obtemFamilia;

    @BeforeEach
    void setUp(){
        criterioFactory = new CriterioFactory();
        calculadoraPontuacao = new CalculadoraPontuacao(criterioFactory.criarCriterios());
        obtemFamilia = new ObtemFamilia(calculadoraPontuacao);
    }

    @Test
    void deve_obter_familia_com_pontucao(){
        int pontuacaoEsperada = 8;
        Dependente dependente1 = new DependenteBuilderTest().criar();
        Dependente dependente2 = new DependenteBuilderTest().criar();

        Familia familiaCom3Dependentes = new FamiliaBuilderTest().comRenda(800).comDependente(dependente1).comDependente(dependente2).criar();

        var familiaPontuada = obtemFamilia.obterComPontuacao(familiaCom3Dependentes);

        assertEquals(pontuacaoEsperada, familiaPontuada.getPontuacao());
    }
}