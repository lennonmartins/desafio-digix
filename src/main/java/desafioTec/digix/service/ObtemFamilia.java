package desafioTec.digix.service;

import desafioTec.digix.model.Familia;

public class ObtemFamilia implements IObtemFamilia {

    private CalculadoraPontuacao calculadoraPontuacao;

    public ObtemFamilia( CalculadoraPontuacao calculadoraPontuacao) {
        this.calculadoraPontuacao = calculadoraPontuacao;
    }

    @Override
    public Familia ObterComPontuacao(Familia familia) {
        int pontuacaoFamilia = this.calculadoraPontuacao.calcularPontuacaoTotal(familia);
        familia.adicionarPontuacao(pontuacaoFamilia);
        return familia;
    }

}
