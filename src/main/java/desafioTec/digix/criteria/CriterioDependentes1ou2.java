package desafioTec.digix.criteria;

import desafioTec.digix.model.Familia;

public class CriterioDependentes1ou2 implements CriterioPontuacao {

    @Override
    public int calcularPontucao(Familia familia) {
        int dependentes = familia.obterTotaisDedependentesValidos();
        return (dependentes == 1 || dependentes == 2) ? 2 : 0;
    }
}
