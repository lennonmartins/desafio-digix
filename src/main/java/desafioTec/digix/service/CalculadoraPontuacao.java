package desafioTec.digix.service;

import java.util.List;

import desafioTec.digix.criteria.CriterioPontuacao;
import desafioTec.digix.model.Familia;

public class CalculadoraPontuacao {

    private List<CriterioPontuacao> criterios;

    public CalculadoraPontuacao(List<CriterioPontuacao> criterios) {
        this.criterios = criterios;
    }

    public int calcularPontuacaoTotal(Familia familia) {
        familia.obterDependentesValidos();
        int pontuacaoTotal = 0;
        for (CriterioPontuacao criterio : criterios) {
            pontuacaoTotal += criterio.calcularPontucao(familia);
        }
        return pontuacaoTotal;
    }
}
