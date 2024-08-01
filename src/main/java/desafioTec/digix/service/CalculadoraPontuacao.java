package desafioTec.digix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import desafioTec.digix.criteria.CriterioPontuacao;
import desafioTec.digix.model.Familia;

@Service
public class CalculadoraPontuacao {

    private List<CriterioPontuacao> criterios;
    private final ICriterioFactory criterioFactory;

    public CalculadoraPontuacao(ICriterioFactory _criterioFactory) {
        this.criterioFactory = _criterioFactory;
        this.criterios = criterioFactory.criarCriterios();
    }

    public int calcularPontuacaoTotal(Familia familia) {
        int pontuacaoTotal = 0;
        for (CriterioPontuacao criterio : criterios) {
            pontuacaoTotal += criterio.calcularPontucao(familia);
        }
        return pontuacaoTotal;
    }
}
