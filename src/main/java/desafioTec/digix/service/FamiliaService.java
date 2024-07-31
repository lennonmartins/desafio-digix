package desafioTec.digix.service;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.service.mappers.IFamiliaMapper;

public class FamiliaService implements IFamiliaService {

    private final IFamiliaMapper mapper = IFamiliaMapper.INSTANCE;

    public FamiliaResponseDto cadastrarFamilia(FamiliaRequestDto familiaRequestDTO) {
        Familia familia = mapper.toModel(familiaRequestDTO);
        FamiliaResponseDto familiaResponse = mapper.toDto(familia);
        return familiaResponse;
    }
}
