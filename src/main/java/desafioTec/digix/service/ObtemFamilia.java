package desafioTec.digix.service;

import org.springframework.stereotype.Service;

import desafioTec.digix.model.Familia;

@Service
public class ObtemFamilia implements IObtemFamilia {

    private CalculadoraPontuacao calculadoraPontuacao;

    public ObtemFamilia( CalculadoraPontuacao calculadoraPontuacao) {
        this.calculadoraPontuacao = calculadoraPontuacao;
    }

    @Override
    public Familia obterComPontuacao(Familia familia) {
        int pontuacaoFamilia = this.calculadoraPontuacao.calcularPontuacaoTotal(familia);
        familia.adicionarPontuacao(pontuacaoFamilia);
        return familia;
    }

}
