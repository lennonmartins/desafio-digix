package desafioTec.digix.service;

import java.util.ArrayList;
import java.util.List;

import desafioTec.digix.criteria.CriterioDependentes1ou2;
import desafioTec.digix.criteria.CriterioDependentes3ouMais;
import desafioTec.digix.criteria.CriterioPontuacao;
import desafioTec.digix.criteria.CriterioRenda901Ate1500;
import desafioTec.digix.criteria.CriterioRendaAte900;

public class CriterioFactory {
    public List<CriterioPontuacao> criarCriterios() {
        List<CriterioPontuacao> criterios = new ArrayList<>();
        criterios.add(new CriterioRenda901Ate1500());
        criterios.add(new CriterioRendaAte900());
        criterios.add(new CriterioDependentes1ou2());
        criterios.add(new CriterioDependentes3ouMais());
        return criterios;
    }
}