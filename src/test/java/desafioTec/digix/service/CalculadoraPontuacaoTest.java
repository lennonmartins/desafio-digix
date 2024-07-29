package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioTec.digix.model.Familia;

public class CalculadoraPontuacaoTest {

    private CalculadoraPontuacao calculadoraPontuacao;

    @BeforeEach
    public void setUp(){
        CriterioFactory criterioFactory = new CriterioFactory();  
        calculadoraPontuacao = new CalculadoraPontuacao(criterioFactory.criarCriterios());
    }

    @Test
    public void deve_pontuar_familia_com_renda_ate_faixa_minima_e_maximo_dependentes(){
        int potuacaoEsperada = 8;
        int rendaMinina = 900;
        Familia familia = new Familia(rendaMinina, 3);
        int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);
        assertEquals(potuacaoEsperada, pontuacaoTotal);
    }

    @Test
    public void deve_pontuar_familia_com_renda_intermediaria_e_maximo_de_dependentes(){
        int potuacaoEsperada = 6;
        int rendaIntermediaria = 1495;
        Familia familia = new Familia(rendaIntermediaria, 3);
        int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);
        assertEquals(potuacaoEsperada, pontuacaoTotal);
    }

    @Test
    public void deve_pontuar_familia_com_renda_intermediaria_e_minimo_de_dependentes(){
        int potuacaoEsperada = 5;
        int rendaIntermediaria = 1495;
        int dependentes = 2;
        Familia familia = new Familia(rendaIntermediaria, dependentes);
        int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);
        assertEquals(potuacaoEsperada, pontuacaoTotal);
    }

    @Test
    public void deve_pontuar_familia_com_renda_alem_maxima_sem_dependentes(){
        int potuacaoEsperada = 0;
        int rendaIntermediaria = 2200;
        int dependentes = 0;
        Familia familia = new Familia(rendaIntermediaria, dependentes);
        int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);
        assertEquals(potuacaoEsperada, pontuacaoTotal);
    }

    @Test
    public void deve_pontuar_familia_sem_renda_e_sem_dependentes(){
        int potuacaoEsperada = 5;
        int rendaIntermediaria = 0;
        int dependentes = 0;
        Familia familia = new Familia(rendaIntermediaria, dependentes);
        int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);
        assertEquals(potuacaoEsperada, pontuacaoTotal);
    }

    @Test
    public void deve_pontuar_familia_sem_renda_com_maximo_dependentes(){
        int potuacaoEsperada = 8;
        int rendaIntermediaria = 0;
        int dependentes = 5;
        Familia familia = new Familia(rendaIntermediaria, dependentes);
        int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);
        assertEquals(potuacaoEsperada, pontuacaoTotal);
    }

}

