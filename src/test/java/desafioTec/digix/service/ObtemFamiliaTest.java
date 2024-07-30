package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioTec.digix.model.Familia;

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
        int pontuacaoEsperada = 7;
        Familia familia = new Familia(800, 2);

        var familiaPontuada = obtemFamilia.ObterComPontuacao(familia);

        assertEquals(pontuacaoEsperada, familiaPontuada.getPontuacao());
    }
}