package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import desafioTec.digix.model.Conjuge;
import desafioTec.digix.model.Dependente;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.Representante;
import desafioTec.digix.model.builder.ConjugeBuilderTest;
import desafioTec.digix.model.builder.DependenteBuilderTest;
import desafioTec.digix.model.builder.RepresentanteBuilderTest;

@SpringBootTest
public class CalculadoraPontuacaoTest {

        private CalculadoraPontuacao calculadoraPontuacao;

        @BeforeEach
        public void setUp() {
                CriterioFactory criterioFactory = new CriterioFactory();
                calculadoraPontuacao = new CalculadoraPontuacao(criterioFactory);
        }

        public static Stream<Arguments> fornecerDadosParaTesteDePontuacao() {
                Representante representante = new RepresentanteBuilderTest().criar();
                Conjuge conjuge = new ConjugeBuilderTest().criar();
                List<Dependente> listaCom3dependentes = criarListaDeDependentes(3);
                List<Dependente> listaCom2Dependentes = criarListaDeDependentes(2);
                List<Dependente> listaSemDependentes = new ArrayList<>();
                return Stream.of(
                                Arguments.of(8, representante, 900, listaCom3dependentes, conjuge,
                                                "deve pontuar familia com renda até faixa mínima e máximo dependentes"),
                                Arguments.of(6, representante, 1495, listaCom3dependentes, conjuge,
                                                "deve pontuar familia com renda intermediária e máximo de dependentes"),
                                Arguments.of(5, representante, 1495, listaCom2Dependentes, conjuge,
                                                "deve pontuar familia com renda intermediária e mínimo de dependentes"),
                                Arguments.of(0, representante, 2200, listaSemDependentes, conjuge,
                                                "deve pontuar familia com renda além máxima sem dependentes"),
                                Arguments.of(5, representante, 0, listaSemDependentes, conjuge,
                                                "deve pontuar familia sem renda e sem dependentes"),
                                Arguments.of(8, representante, 0, listaCom3dependentes, conjuge,
                                                "deve pontuar familia sem renda com máximo dependentes"));
        }

        @ParameterizedTest
        @MethodSource("fornecerDadosParaTesteDePontuacao")
        @DisplayName("Testes Parametrizados para Pontuação de Famílias")
        public void deve_pontuar_familia_seguindo_criterios(int pontuacaoEsperada, Representante representante,
                        double renda,
                        List<Dependente> dependentes, Conjuge conjuge) {
                Familia familia = new Familia(representante, renda, dependentes, conjuge);

                int pontuacaoTotal = calculadoraPontuacao.calcularPontuacaoTotal(familia);

                assertEquals(pontuacaoEsperada, pontuacaoTotal);
        }

        private static List<Dependente> criarListaDeDependentes(int quantidade) {
                List<Dependente> dependentes = new ArrayList<>();
                DependenteBuilderTest dependenteBuilder = new DependenteBuilderTest();
                for (int i = 0; i < quantidade; i++) {
                        dependentes.add(dependenteBuilder.criar());
                }
                return dependentes;
        }
}
