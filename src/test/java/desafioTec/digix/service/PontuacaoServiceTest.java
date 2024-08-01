package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import desafioTec.digix.dto.PontuacaoResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.builder.DependenteBuilderTest;
import desafioTec.digix.model.builder.FamiliaBuilderTest;
import desafioTec.digix.model.builder.RepresentanteBuilderTest;
import desafioTec.digix.repository.IFamiliaRepository;

@SpringBootTest
public class PontuacaoServiceTest {

        @MockBean
        private IListagemFamiliaService listagemFamiliaService;

        @MockBean
        private IFamiliaRepository familiaRepository;

        @Autowired
        private PontuacaoService pontuacaoService;

        @Test
        void deve_obter_lista_de_familia_ordenadas_pela_pontuacao() {
                Familia familia1 = new FamiliaBuilderTest().criar();
                Familia familia2 = new FamiliaBuilderTest()
                                .comRepresentante(new RepresentanteBuilderTest()
                                                .comNome("Marina")
                                                .comCpf("95483764072").criar())
                                .comConjuge(null)
                                .comDependente(new DependenteBuilderTest().criar())
                                .comDependente(new DependenteBuilderTest().criar()).comRenda(800).criar();

                List<Familia> ListaDeFamiliasNaoOrdenada = Arrays.asList(familia1, familia2);
                List<Familia> familiasOrdenadas = Arrays.asList(familia2, familia1);

                when(familiaRepository.obterFamilias()).thenReturn(ListaDeFamiliasNaoOrdenada);
                when(listagemFamiliaService.ordernarListaDeFamiliaPorPonto(ListaDeFamiliasNaoOrdenada))
                                .thenReturn(familiasOrdenadas);

                List<PontuacaoResponseDto> listaOrdenadaEsperada = familiasOrdenadas.stream()
                                .map(familia -> new PontuacaoResponseDto(
                                                familia.getRepresentante().getNome(),
                                                familia.getPontuacao()))
                                .collect(Collectors.toList());

                var listaOrdenadaObtida = pontuacaoService.obterListaOrdenadaPorCriterios();

                assertEquals(listaOrdenadaEsperada, listaOrdenadaObtida);
        }
}
