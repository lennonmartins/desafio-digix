package desafioTec.digix.criteria;

import desafioTec.digix.model.Familia;

public class CriterioRenda901Ate1500 implements CriterioPontuacao{

    @Override
    public int calcularPontucao(Familia familia) {
        int rendaFamilia = familia.getRendaTotalFamilia();
        return rendaFamilia > 900 & rendaFamilia <= 1500 ? 3 : 0;
    }
}
