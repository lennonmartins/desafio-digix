package desafioTec.digix.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import desafioTec.digix.model.builder.DependenteBuilderTest;
import desafioTec.digix.model.builder.FamiliaBuilderTest;
import desafioTec.digix.model.builder.RepresentanteBuilderTest;

public class FamiliaTest {

    private static Stream<Arguments> forneceFamiliaComDadosNegativos() {
        Representante representanteValido = new RepresentanteBuilderTest().criar();
        Dependente dependenteValido = new DependenteBuilderTest().criar();
        Representante representanteNulo = null;
        int rendaNegativa = -100;
        return Stream.of(
                Arguments.of(representanteNulo, 100, dependenteValido,
                        MensagensErro.REPRESENTANTE_NULO),
                Arguments.of(representanteValido, rendaNegativa, dependenteValido,
                        MensagensErro.RENDA_NEGATIVA));
    }

    @Test
    public void deve_criar_familia_com_valores_validos() {
        int rendaEsperada = 800;
        int numeroDependentesEsperado = 1;
        Representante representante = new RepresentanteBuilderTest().criar();
        List<Dependente> dependentes = new ArrayList<Dependente>();
        dependentes.add(new DependenteBuilderTest().criar());

        Familia familia = new Familia(representante, 800, dependentes);

        assertEquals(rendaEsperada, familia.getRendaTotal());
        assertEquals(numeroDependentesEsperado, familia.getDependentes().size());
        assertEquals(representante.getCpf(), familia.getRepresentante().getCpf());
    }

    @Test
    public void deve_criar_familia_com_dependentes_maiores_de_18_anos() {
        Dependente dependenteAdulto = new DependenteBuilderTest().comDataNascimento(LocalDate.of(1995, 01, 21)).criar();
        int dependentesValidosDoSorteio = 1;
        int dependentesTotais = 2;
        Familia familia = new FamiliaBuilderTest().comDependente(dependenteAdulto).criar();
        familia.obterDependentesValidos();
        
        assertEquals(dependentesValidosDoSorteio, familia.getTotaisDedependentesValidos());
        assertEquals(dependentesTotais, familia.getDependentes().size());
    }

    @Test
    public void deve_criar_familia_com_pontos_nulos() {
        int pontosEsperados = 0;
        Familia familia = new FamiliaBuilderTest().criar();
        assertEquals(pontosEsperados, familia.getPontuacao());
    }

    @ParameterizedTest
    @MethodSource("forneceFamiliaComDadosNegativos")
    public void nao_deve_criar_familia_com_dependentes_ou_renda_negativa_ou_reprsentante_nulo(
            Representante representante,
            int rendaDaFamilia, Dependente dependentesDaFamilia,
            String mensagemDeErroEsperada) {

        List<Dependente> dependentes = new ArrayList<>();
        dependentes.add(dependentesDaFamilia);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Familia(representante, rendaDaFamilia, dependentes);
        });

        assertEquals(mensagemDeErroEsperada, exception.getMessage());
    }
}
