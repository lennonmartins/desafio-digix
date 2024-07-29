package desafioTec.digix.model;

import lombok.Getter;

@Getter
public class Familia {
    int rendaTotalFamilia;
    int totaisDedependentes;

    public Familia(int renda, int dependentes) {
        if (renda < 0) {
            throw new IllegalArgumentException("Renda não pode ser negativa");
        }
        if (dependentes < 0) {
            throw new IllegalArgumentException("Número de dependentes não pode ser negativo");
        }

        this.rendaTotalFamilia = renda;
        this.totaisDedependentes = dependentes;
    }

}
