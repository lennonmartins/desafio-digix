package desafioTec.digix.model.builder;

import desafioTec.digix.model.Familia;
import lombok.Getter;

@Getter
public class FamiliaBuilder {
    private int rendaTotal;
    private int totaisDedependentes;
    private int pontuacao = 0;
    public FamiliaBuilder() {
    }

    public FamiliaBuilder(int rendaTotalFamilia, int totaisDedependentes) {
        this.rendaTotal = 1500;
        this.totaisDedependentes = 3;
    }

    public Familia criar(){
        Familia familia = new Familia(rendaTotal, totaisDedependentes);
        return familia;
    }

    public FamiliaBuilder comRenda(int renda){
        this.rendaTotal = renda;
        return this;
    }

    public FamiliaBuilder comDependentes(int dependentes){
        this.totaisDedependentes = dependentes;
        return this;
    }
}
