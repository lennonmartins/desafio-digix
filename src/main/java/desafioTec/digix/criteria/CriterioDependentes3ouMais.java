package desafioTec.digix.criteria;

import desafioTec.digix.model.Familia;

public class CriterioDependentes3ouMais implements CriterioPontuacao{

    @Override
    public int calcularPontucao(Familia familia) {
        return familia.obterTotaisDeDedependentesAptos() >= 3 ? 3 : 0;
    }
}
