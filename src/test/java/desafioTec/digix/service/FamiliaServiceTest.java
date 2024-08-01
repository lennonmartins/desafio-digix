package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import desafioTec.digix.controller.builder.FamiliaRequestDtoBuilder;
import desafioTec.digix.dtos.ConjugeDto;
import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.RepresentanteDto;

@SpringBootTest
public class FamiliaServiceTest {

    private IFamiliaService familiaService;

    @BeforeEach
    void setUp() {
        familiaService = new FamiliaService();
    }

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

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            familiaService.cadastrarFamilia(familiaRequest);
        });

        assertEquals(MensagemErro.REPRESENTANTE_CONJUGE_JA_CADASTRADO, exception.getMessage());
    }

    @Test
    void nao_deve_cadastrar_familia_com_representante_ja_cadastrado_como_conjuge(){
    String nomeMaria = "Maria Silva";
    LocalDate dataDeNascimentoMaria = LocalDate.of(1998, 2, 23);
    String cpfMaria = "57808353060";
    String nomeLennon = "Lennon";
    LocalDate dataDeNascimentoLennon = LocalDate.of(1998, 2, 23);
    String cpfLennon = "01756232288";
    
    RepresentanteDto mariaRepresentante = new RepresentanteDto(nomeMaria, dataDeNascimentoMaria, cpfMaria);
    ConjugeDto lennonConjuge = new ConjugeDto(nomeLennon, dataDeNascimentoLennon, cpfLennon); 

    FamiliaRequestDto familiaLennon = new FamiliaRequestDtoBuilder().criar();
    
    familiaService.cadastrarFamilia(familiaLennon);
    
    FamiliaRequestDto familiaMaria = new FamiliaRequestDtoBuilder()
        .comRepresentante(mariaRepresentante)
        .comConjuge(lennonConjuge)
        .criar();

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        familiaService.cadastrarFamilia(familiaMaria);
    });

    assertEquals(MensagemErro.REPRESENTANTE_CONJUGE_JA_CADASTRADO, exception.getMessage());
    }
}
