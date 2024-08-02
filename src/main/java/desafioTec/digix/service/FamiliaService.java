package desafioTec.digix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import desafioTec.digix.dto.FamiliaRequestDto;
import desafioTec.digix.dto.FamiliaResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.repository.FamiliaRepositoryDAO;
import desafioTec.digix.repository.IFamiliaRepository;
import desafioTec.digix.service.mappers.IFamiliaMapper;

@Service
public class FamiliaService implements IFamiliaService {

    private final List<Familia> familias = new ArrayList<>();
    private final IFamiliaMapper mapper = IFamiliaMapper.INSTANCE;
    private final IFamiliaRepository familiaRepository;
    private final FamiliaRepositoryDAO familiaRepositoryDAO;

    public FamiliaService( IFamiliaRepository familiaRepository,FamiliaRepositoryDAO familiaRepositoryDAO) {
        this.familiaRepository = familiaRepository;
        this.familiaRepositoryDAO = familiaRepositoryDAO;
    }

    public FamiliaResponseDto cadastrarFamilia(FamiliaRequestDto familiaRequestDTO) {
        String cpfDoRepresentante = familiaRequestDTO.representante().cpf();
        String cpfDoConjuge = familiaRequestDTO.conjuge() != null ? familiaRequestDTO.conjuge().cpf() : null;

        verificarRepresentanteOuConjugeJaCadastrado(cpfDoRepresentante, cpfDoConjuge);

        Familia familia = mapper.toModel(familiaRequestDTO);
        familiaRepository.adicionarFamilia(familia);
        familiaRepositoryDAO.save(familia);

        FamiliaResponseDto familiaResponse = mapper.toDto(familia);
        return familiaResponse;
    }

    private void verificarRepresentanteOuConjugeJaCadastrado(String cpfDoRepresentante, String cpfDoConjuge) {
        familias.addAll(familiaRepository.obterFamilias());
        List<Familia> familias = familiaRepositoryDAO.findAll();
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
