package desafioTec.digix.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import desafioTec.digix.dto.PontuacaoResponseDto;
import desafioTec.digix.service.PontuacaoService;

@SpringBootTest
@AutoConfigureMockMvc
public class PontuacaoControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PontuacaoService pontuacaoService;

    @Test
    void deve_retornar_uma_lista_de_familias_pontuadas() throws Exception{
        PontuacaoResponseDto representanteDto1 = new PontuacaoResponseDto("João", 10);
        PontuacaoResponseDto representanteDto2 = new PontuacaoResponseDto("Maria", 8);
        List<PontuacaoResponseDto> listaFamiliasOrdenadas = Arrays.asList(representanteDto1, representanteDto2);

        when(pontuacaoService.obterListaOrdenadaPorCriterios()).thenReturn(listaFamiliasOrdenadas);
        
        mockMvc.perform(get("/api/v1/listaPontuacoes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].nomeDoRepresentante").value("João"))
                .andExpect(jsonPath("$[0].pontuacao").value(10))
                .andExpect(jsonPath("$[1].nomeDoRepresentante").value("Maria"))
                .andExpect(jsonPath("$[1].pontuacao").value(8));
    }
}
