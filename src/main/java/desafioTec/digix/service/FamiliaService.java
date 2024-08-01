package desafioTec.digix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.service.mappers.IFamiliaMapper;

public class FamiliaService implements IFamiliaService {

    private final List<Familia> familias = new ArrayList<>();
    private final IFamiliaMapper mapper = IFamiliaMapper.INSTANCE;

    public FamiliaResponseDto cadastrarFamilia(FamiliaRequestDto familiaRequestDTO) {

        verificarRepresentanteJaCadastrado(familiaRequestDTO.representante().cpf());

        Familia familia = mapper.toModel(familiaRequestDTO);

        familias.add(familia);

        FamiliaResponseDto familiaResponse = mapper.toDto(familia);
        return familiaResponse;
    }

    private void verificarRepresentanteJaCadastrado(String cpfDoRepresentante) {
       Optional<Familia> familiaCadastrada = familias.stream().filter(
        f -> f.getRepresentante().getCpf().getValorCpf().equals(cpfDoRepresentante)).findFirst();

        if (familiaCadastrada.isPresent()) throw new IllegalArgumentException(MensagemErro.REPRESENTANTE_JA_CADASTRADO);
    }
}
