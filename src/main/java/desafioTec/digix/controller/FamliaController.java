package desafioTec.digix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.service.FamiliaService;
import desafioTec.digix.service.IFamiliaService;

@RestController
@RequestMapping(path = { "/api/v1/familias" }, produces = { "application/json" })
public class FamliaController {
    private final IFamiliaService familiaService;

    public FamliaController() {
        familiaService = new FamiliaService();
    }

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<FamiliaResponseDto> cadastrarFamilia(@RequestBody FamiliaRequestDto familiaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.cadastrarFamilia(familiaRequestDto));
    }
}
