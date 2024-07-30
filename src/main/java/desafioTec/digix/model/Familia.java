package desafioTec.digix.model;

import lombok.Getter;

@Getter
public class Familia {
    private int rendaTotal;
    private int totaisDedependentes;
    private int pontuacao = 0;

    public Familia(int renda, int dependentes) {
        if (renda < 0) {
            throw new IllegalArgumentException("Renda não pode ser negativa");
        }
        if (dependentes < 0) {
            throw new IllegalArgumentException("Número de dependentes não pode ser negativo");
        }

        this.rendaTotal = renda;
        this.totaisDedependentes = dependentes;
    }

    public void adicionarPontuacao(int pontuacao){
        this.pontuacao += pontuacao;
    }
}
