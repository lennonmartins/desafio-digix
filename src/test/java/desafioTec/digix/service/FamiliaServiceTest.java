package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desafioTec.digix.model.Familia;

public class FamiliaServiceTest {

    private CalculadoraPontuacao calculadoraPontuacao;
    private FamiliaService familiaService = new FamiliaService(calculadoraPontuacao);

    @BeforeEach
    public void setUp() {
        CriterioFactory criterioFactory = new CriterioFactory();
        calculadoraPontuacao = new CalculadoraPontuacao(criterioFactory.criarCriterios());
    }

    @Test
    public void deve_ordenar_lista_de_familia_pela_maior_pontuacao(){
        var familias = this.montar10Familias();
        familiaService.ordernarPelaPontucao(familias);
        assertEquals(10, familias.size());
       
    }

    private List<Familia> montar10Familias() {
        var familias = new ArrayList<Familia>();
        for (int i = 0; i < 10; i++) {
            Familia familia = new Familia(i, 300 * i);
            familias.add(familia);
        }
        return familias;
    }
}
