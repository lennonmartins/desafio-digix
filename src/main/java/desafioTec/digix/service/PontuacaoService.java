package desafioTec.digix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import desafioTec.digix.dto.PontuacaoResponseDto;
import desafioTec.digix.model.Familia;
import desafioTec.digix.repository.IFamiliaRepository;

@Service
public class PontuacaoService implements IPontuacaoService {

    private final IListagemFamiliaService listagemFamiliaService;
    private final IFamiliaRepository familiaRepository;

    public PontuacaoService(IListagemFamiliaService listagemFamiliaService, IFamiliaRepository familiaRepository) {
        this.listagemFamiliaService = listagemFamiliaService;
        this.familiaRepository = familiaRepository;
    }

    @Override
    public List<PontuacaoResponseDto> obterListaOrdenadaPorCriterios() {
        List<Familia> familias = obterFamilias();
        List<Familia> familiasOrdenadas = listagemFamiliaService.ordernarListaDeFamiliaPorPonto(familias);
        return familiasOrdenadas.stream()
                .map(
                        familia -> new PontuacaoResponseDto(familia.getRepresentante().getNome(),
                                familia.getPontuacao()))
                .collect(Collectors.toList());
    }

    private List<Familia> obterFamilias() {
        return familiaRepository.obterFamilias();
    }

}
