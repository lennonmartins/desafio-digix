package desafioTec.digix.service;

import java.util.List;

import desafioTec.digix.dto.PontuacaoResponseDto;

public interface IPontuacaoService {
    public List<PontuacaoResponseDto> obterListaOrdenadaPorCriterios();
}
