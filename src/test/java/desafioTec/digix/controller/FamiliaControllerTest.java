package desafioTec.digix.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import desafioTec.digix.controller.builder.FamiliaRequestDtoBuilder;
import desafioTec.digix.dto.ConjugeDto;
import desafioTec.digix.dto.DependenteDto;
import desafioTec.digix.dto.FamiliaRequestDto;
import desafioTec.digix.dto.FamiliaResponseDto;
import desafioTec.digix.dto.RepresentanteDto;
import desafioTec.digix.service.FamiliaService;

@SpringBootTest
@AutoConfigureMockMvc
public class FamiliaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FamiliaService familiaService;

    @Test
    public void deve_cadastrar_uma_famila() throws Exception {

        RepresentanteDto representanteDto = new RepresentanteDto("João Silva", LocalDate.of(1980, 1, 1), "01756232288");

        var familiaRequestDto = new FamiliaRequestDtoBuilder()
                .comRepresentante(representanteDto)
                .comRenda(800)
                .comDependentes(Arrays.asList(
                        new DependenteDto("Maria", LocalDate.of(2010, 1, 1)),
                        new DependenteDto("José", LocalDate.of(2012, 1, 1))))
                .criar();
        
                var conjugeDto = new ConjugeDto("Vitoria", LocalDate.of(1980, 1, 1), "57808353060");

        var familiaResponseDto = new FamiliaResponseDto(representanteDto, 800, Arrays.asList(
                new DependenteDto("Maria", LocalDate.of(2010, 1, 1)),
                new DependenteDto("José", LocalDate.of(2012, 1, 1))), conjugeDto);

        when(familiaService.cadastrarFamilia(any(FamiliaRequestDto.class))).thenReturn(familiaResponseDto);

        mockMvc.perform(post("/api/v1/familias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(familiaRequestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.representante.nome").value(representanteDto.nome()))
                .andExpect(jsonPath("$.representante.dataDeNascimento")
                        .value(representanteDto.dataDeNascimento().toString()))
                .andExpect(jsonPath("$.representante.cpf").value(representanteDto.cpf()))
                .andExpect(jsonPath("$.rendaTotal").value(800))
                .andExpect(jsonPath("$.dependentes", hasSize(2)))
                .andExpect(jsonPath("$.dependentes[0].nome").value("Maria"))
                .andExpect(jsonPath("$.dependentes[1].nome").value("José"));

    }

    private String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Falhou em converter o objeto em Json", e);
        }
    }
}