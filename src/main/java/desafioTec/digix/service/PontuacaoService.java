package desafioTec.digix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import desafioTec.digix.dto.PontuacaoResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.repository.FamiliaRepositoryDAO;
import desafioTec.digix.repository.IFamiliaRepository;

@Service
public class PontuacaoService implements IPontuacaoService {

    private final IListagemFamiliaService listagemFamiliaService;
    private final IFamiliaRepository familiaRepository;
    private final FamiliaRepositoryDAO   familiaRepositoryDAO;



    public PontuacaoService(IListagemFamiliaService listagemFamiliaService, IFamiliaRepository familiaRepository, FamiliaRepositoryDAO familiaRepositoryDAO) {
        this.listagemFamiliaService = listagemFamiliaService;
        this.familiaRepository = familiaRepository;
        this.familiaRepositoryDAO = familiaRepositoryDAO;
    }

    @Override
    public List<PontuacaoResponseDto> obterListaOrdenadaPorCriterios() {
       List<Familia> familiasR = familiaRepository.obterFamilias();
        List<Familia> familias = familiaRepositoryDAO.findAll();

        List<Familia> familiasOrdenadas = listagemFamiliaService.ordernarListaDeFamiliaPorPonto(familias);
        return familiasOrdenadas.stream()
                .map(
                        familia -> new PontuacaoResponseDto(familia.getRepresentante().getNome(),
                                familia.getPontuacao()))
                .collect(Collectors.toList());
    }
}
