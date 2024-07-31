package desafioTec.digix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void deve_cadastrar_uma_familia(){
        FamiliaRequestDto familiaRequest = new FamiliaRequestDtoBuilder().criar();
        
        var familiaResponse = familiaService.cadastrarFamilia(familiaRequest);

        assertEquals(familiaRequest.representante().nome(), familiaResponse.representante().nome());

    }
}
