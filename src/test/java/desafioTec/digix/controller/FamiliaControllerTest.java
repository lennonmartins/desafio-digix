package desafioTec.digix.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import desafioTec.digix.controller.builder.FamiliaRequestDtoBuilder;
import desafioTec.digix.dtos.DependenteDto;
import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.dtos.RepresentanteDto;
import desafioTec.digix.service.FamiliaService;

@SpringBootTest
public class FamiliaControllerTest {

    @MockBean
    private FamiliaService familiaService ;

    @Test
    public void deve_cadastrar_uma_famila() {

        RepresentanteDto representanteDto = new RepresentanteDto("João Silva", LocalDate.of(1980, 1, 1), "01756232288");

        var familiaRequestDto = new FamiliaRequestDtoBuilder()
            .comRepresentante(representanteDto)
            .comRenda(new BigDecimal("800.00"))
            .comDependentes(Arrays.asList(
                new DependenteDto("Maria", LocalDate.of(2010, 1, 1)),
                new DependenteDto("José", LocalDate.of(2012, 1, 1))
            ))
            .criar();

        var familiaResponseDto = new FamiliaResponseDto(1L,representanteDto, 800, Arrays.asList(
            new DependenteDto("Maria", LocalDate.of(2010, 1, 1)),
            new DependenteDto("José", LocalDate.of(2012, 1, 1))
        ));


        when(familiaService.cadastrarFamilia(any(FamiliaRequestDto.class))).thenReturn(familiaResponseDto);

    }

}
