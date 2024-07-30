package desafioTec.digix.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import desafioTec.digix.model.builder.FamiliaBuilder;

public class FamiliaTest {

    @Test
    public void deve_criar_familia_com_valores_validos(){
        int rendaEsperada = 800;
        int  numeroDependentesEsperado = 3;

        Familia familia = new Familia(800,3);

        assertEquals(rendaEsperada, familia.getRendaTotal());
        assertEquals(numeroDependentesEsperado, familia.getTotaisDedependentes());
    }

    @Test
    public void nao_deve_criar_familia_com_renda_negativa(){
        int rendaTotal = -1;
        assertThrows(IllegalArgumentException.class, () -> new Familia(rendaTotal, 3));
    }

    @Test
    public void nao_deve_criar_familia_com_dependentes_negativos(){
        int dependentesTotais  = -1;
        assertThrows(IllegalArgumentException.class, () -> new Familia(800, dependentesTotais));
    }

    @Test
    public void deve_criar_familia_com_pontos_nulos(){
        int pontosEsperados = 0;
        Familia familia = new FamiliaBuilder().criar();
        assertEquals(pontosEsperados, familia.getPontuacao());
    }
}
