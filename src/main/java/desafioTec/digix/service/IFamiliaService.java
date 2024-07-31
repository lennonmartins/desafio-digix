package desafioTec.digix.service;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;

public interface IFamiliaService {
    public FamiliaResponseDto cadastrarFamilia(FamiliaRequestDto familiaRequestDTO);
}
