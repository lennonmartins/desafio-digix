package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import desafioTec.digix.controller.builder.FamiliaRequestDtoBuilder;
import desafioTec.digix.dtos.FamiliaRequestDto;

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

        assertEquals(MensagemErro.REPRESENTANTE_JA_CADASTRADO, exception.getMessage());
    }
}
