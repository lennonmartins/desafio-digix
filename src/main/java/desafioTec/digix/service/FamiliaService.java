package desafioTec.digix.service;

import java.util.ArrayList;
import java.util.List;

import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.FamiliaResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.service.mappers.IFamiliaMapper;

public class FamiliaService implements IFamiliaService {

    private final List<Familia> familias = new ArrayList<>();
    private final IFamiliaMapper mapper = IFamiliaMapper.INSTANCE;

    public FamiliaResponseDto cadastrarFamilia(FamiliaRequestDto familiaRequestDTO) {
        String cpfDoRepresentante = familiaRequestDTO.representante().cpf();
        String cpfDoConjuge = familiaRequestDTO.conjuge() != null ? familiaRequestDTO.conjuge().cpf() : null;

        verificarRepresentanteOuConjugeJaCadastrado(cpfDoRepresentante, cpfDoConjuge);

        Familia familia = mapper.toModel(familiaRequestDTO);
        familias.add(familia);

        FamiliaResponseDto familiaResponse = mapper.toDto(familia);
        return familiaResponse;
    }

    private void verificarRepresentanteOuConjugeJaCadastrado(String cpfDoRepresentante, String cpfDoConjuge) {
        boolean cpfJaCadastrado = familias.stream().anyMatch(
                f -> cpfEstaCadastrado(f, cpfDoRepresentante)
                        || (cpfDoConjuge != null && cpfEstaCadastrado(f, cpfDoConjuge)));

        if (cpfJaCadastrado)
            throw new IllegalArgumentException(MensagemErro.REPRESENTANTE_CONJUGE_JA_CADASTRADO);

    }

    private boolean cpfEstaCadastrado(Familia familia, String cpf) {
        return familia.getRepresentante().getCpf().getValorCpf().equals(cpf) ||
                (familia.getConjuge() != null && familia.getConjuge().getCpf().getValorCpf().equals(cpf));
    }
}
