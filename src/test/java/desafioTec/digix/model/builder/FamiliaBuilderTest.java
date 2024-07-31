package desafioTec.digix.model.builder;

import java.util.ArrayList;
import java.util.List;

import desafioTec.digix.model.Dependente;
import desafioTec.digix.model.Familia;
import desafioTec.digix.model.Representante;
import lombok.Getter;

@Getter
public class FamiliaBuilderTest {
    private int rendaTotal;
    private int totaisDedependentes;
    private int pontuacao = 0;
    private Representante representante;
    private List<Dependente> dependentes = new ArrayList<Dependente>();

    public FamiliaBuilderTest() {
        this.dependentes.add(new DependenteBuilderTest().criar());
        this.representante = new RepresentanteBuilderTest().criar();
        this.rendaTotal = 1500;
        this.totaisDedependentes = dependentes.size();
    }

    public Familia criar() {
        return new Familia(representante, rendaTotal, dependentes);
    }

    public FamiliaBuilderTest comRenda(int renda) {
        this.rendaTotal = renda;
        return this;
    }

    public FamiliaBuilderTest comDependente(Dependente dependente) {
        this.dependentes.add(dependente);
        return this;
    }
}
