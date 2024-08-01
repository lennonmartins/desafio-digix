package desafioTec.digix.service;

import java.util.List;

import desafioTec.digix.criteria.CriterioPontuacao;

public interface ICriterioFactory {
    List<CriterioPontuacao> criarCriterios();
}
