package desafioTec.digix.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafioTec.digix.dto.FamiliaRequestDto;
import desafioTec.digix.dto.FamiliaResponseDto;
import desafioTec.digix.repository.IFamiliaRepository;
import desafioTec.digix.service.IFamiliaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/familias" }, produces = { "application/json" })
public class FamliaController {
    private final IFamiliaService familiaService;

    public FamliaController(IFamiliaRepository familiaRepository, IFamiliaService familiaService) {
        this.familiaService = familiaService;
    }

    @Operation(summary = "Cadastra uma nova familia")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<FamiliaResponseDto> cadastrarFamilia(@RequestBody FamiliaRequestDto familiaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.cadastrarFamilia(familiaRequestDto));
    }

    @Operation(summary = "Cadastra uma remessa de familias")
    @ApiResponse(responseCode = "201")
    @PostMapping(path = "/remessa", consumes = { "application/json" })
    public ResponseEntity<List<FamiliaResponseDto>> cadastrarRemessaFamilias(@RequestBody List<FamiliaRequestDto> familiasRequestDto) {
        List<FamiliaResponseDto> responseDtos = familiasRequestDto.stream()
                .map(familiaService::cadastrarFamilia)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDtos);
    }
}
