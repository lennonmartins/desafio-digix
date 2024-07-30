package desafioTec.digix.criteria;

import desafioTec.digix.model.Familia;

public class CriterioRendaAte900 implements CriterioPontuacao  {

    @Override
    public int calcularPontucao(Familia familia) {
        return familia.getRendaTotal() <= 900 ? 5 : 0;
    }
}