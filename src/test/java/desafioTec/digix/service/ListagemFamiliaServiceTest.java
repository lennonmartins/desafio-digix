package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioTec.digix.model.Familia;
import desafioTec.digix.model.builder.FamiliaBuilder;

public class ListagemFamiliaServiceTest {

    private CalculadoraPontuacao calculadoraPontuacao;
    private CriterioFactory criterioFactory;
    private ListagemFamiliaService familiaService;
    private IObtemFamilia obtemFamilia;

    @BeforeEach
    public void setUp() {
        criterioFactory = new CriterioFactory();
        calculadoraPontuacao = new CalculadoraPontuacao(criterioFactory.criarCriterios());
        obtemFamilia = new ObtemFamilia(calculadoraPontuacao);
        familiaService = new ListagemFamiliaService(obtemFamilia);
    }

    @Test
    public void deve_ordenar_lista_de_familia_pela_maior_pontuacao() {
        Familia familia1 = new FamiliaBuilder().comRenda(800).comDependentes(3).criar();
        Familia familia2 = new FamiliaBuilder().comRenda(1000).comDependentes(1).criar();
        Familia familia3 = new FamiliaBuilder().comRenda(1600).comDependentes(1).criar();

        List<Familia> familias = new ArrayList<>(Arrays.asList(familia2, familia3, familia1));
        var listagemOrdenada = familiaService.ordernarListaDeFamiliaPorPonto(familias);
        assertEquals(familia1, listagemOrdenada.get(0));
    }
}