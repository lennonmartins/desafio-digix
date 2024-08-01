package desafioTec.digix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafioTec.digix.dto.PontuacaoResponseDto;
import desafioTec.digix.service.IPontuacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/listaPontuacoes" }, produces = { "application/json" })
public class PontuacaoController {
    private final IPontuacaoService pontuacaoService;

    public PontuacaoController(IPontuacaoService pontuacaoService) {
        this.pontuacaoService = pontuacaoService;
    }

    @Operation(summary ="Buscar uma lista de familias ordenada pelo critério de maior pontuação")
    @ApiResponse(responseCode = "200", description = "Retorna uma lista de família solicitada" )
    @GetMapping
    public ResponseEntity<List<PontuacaoResponseDto>> obterListaOrdenadaPorCriterios() {
        return ResponseEntity.status(HttpStatus.OK).body(pontuacaoService.obterListaOrdenadaPorCriterios());
    }
}