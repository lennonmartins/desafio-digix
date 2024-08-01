package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import desafioTec.digix.controller.builder.FamiliaRequestDtoBuilder;
import desafioTec.digix.dto.ConjugeDto;
import desafioTec.digix.dto.FamiliaRequestDto;
import desafioTec.digix.dto.RepresentanteDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.builder.FamiliaBuilderTest;
import desafioTec.digix.repository.IFamiliaRepository;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FamiliaServiceTest {

    @MockBean
    private IFamiliaRepository familiaRepository;

    @Autowired
    private IFamiliaService familiaService;

    @Test
    void deve_cadastrar_uma_familia() {
        FamiliaRequestDto familiaRequest = new FamiliaRequestDtoBuilder().criar();

        var familiaResponse = familiaService.cadastrarFamilia(familiaRequest);

        assertEquals(familiaRequest.representante().nome(), familiaResponse.representante().nome());
    }

    @Test
    void nao_deve_permitir_o_cadastro_de_familia_uma_familia_duas_vezes() {
        FamiliaRequestDto familiaRequest = new FamiliaRequestDtoBuilder().criar();
        familiaService.cadastrarFamilia(familiaRequest);
        Familia familia = new FamiliaBuilderTest().criar();
        List<Familia> familias = List.of(familia);

        doNothing().when(familiaRepository).adicionarFamilia(any(Familia.class));
        when(familiaRepository.obterFamilias()).thenReturn(familias);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            familiaService.cadastrarFamilia(familiaRequest);
        });

        assertEquals(MensagemErro.REPRESENTANTE_CONJUGE_JA_CADASTRADO, exception.getMessage());
    }

    @Test
    void nao_deve_cadastrar_familia_com_representante_ja_cadastrado_como_conjuge() {
        String nomeMaria = "Maria Silva";
        LocalDate dataDeNascimentoMaria = LocalDate.of(1998, 2, 23);
        String cpfMaria = "57808353060";
        String nomeLennon = "Lennon";
        LocalDate dataDeNascimentoLennon = LocalDate.of(1998, 2, 23);
        String cpfLennon = "01756232288";

        RepresentanteDto mariaRepresentante = new RepresentanteDto(nomeMaria, dataDeNascimentoMaria, cpfMaria);
        ConjugeDto lennonConjuge = new ConjugeDto(nomeLennon, dataDeNascimentoLennon, cpfLennon);

        FamiliaRequestDto familiaLennonDto = new FamiliaRequestDtoBuilder().criar();
        familiaService.cadastrarFamilia(familiaLennonDto);

        FamiliaRequestDto familiaMariaDto = new FamiliaRequestDtoBuilder()
                .comRepresentante(mariaRepresentante)
                .comConjuge(lennonConjuge)
                .criar();
        Familia familiaMaria = new FamiliaBuilderTest().criar();

        List<Familia> familias = List.of(familiaMaria);
        doNothing().when(familiaRepository).adicionarFamilia(any(Familia.class));
        when(familiaRepository.obterFamilias()).thenReturn(familias);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            familiaService.cadastrarFamilia(familiaMariaDto);
        });

        assertEquals(MensagemErro.REPRESENTANTE_CONJUGE_JA_CADASTRADO, exception.getMessage());
    }
}
