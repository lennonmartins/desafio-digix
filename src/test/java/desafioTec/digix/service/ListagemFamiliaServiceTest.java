package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import desafioTec.digix.model.Dependente;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.builder.DependenteBuilderTest;
import desafioTec.digix.model.builder.FamiliaBuilderTest;

@SpringBootTest
public class ListagemFamiliaServiceTest {

    private CalculadoraPontuacao calculadoraPontuacao;
    private CriterioFactory criterioFactory;
    private ListagemFamiliaService listagemService;
    private IObtemFamilia obtemFamilia;

    @BeforeEach
    public void setUp() {
        criterioFactory = new CriterioFactory();
        calculadoraPontuacao = new CalculadoraPontuacao(criterioFactory);
        obtemFamilia = new ObtemFamilia(calculadoraPontuacao);
        listagemService = new ListagemFamiliaService(obtemFamilia);
    }

    @Test
    public void deve_ordenar_lista_de_familia_pela_maior_pontuacao() {
        Dependente dependente = new DependenteBuilderTest().criar();
        Familia familia1 = new FamiliaBuilderTest().comRenda(800).comDependente(dependente).comDependente(dependente).criar();
        Familia familia2 = new FamiliaBuilderTest().comRenda(1000).criar();
        Familia familia3 = new FamiliaBuilderTest().comRenda(1600).criar();

        List<Familia> familias = new ArrayList<>(Arrays.asList(familia2, familia3, familia1));
        var listagemOrdenada = listagemService.ordernarListaDeFamiliaPorPonto(familias);
        assertEquals(familia1, listagemOrdenada.get(0));
    }
}