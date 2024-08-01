package desafioTec.digix.service;

import desafioTec.digix.dto.FamiliaRequestDto;
import desafioTec.digix.dto.FamiliaResponseDto;

public interface IFamiliaService {
    public FamiliaResponseDto cadastrarFamilia(FamiliaRequestDto familiaRequestDTO);
}
