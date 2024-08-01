package desafioTec.digix.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.Getter;

@Getter
public class Familia {
    private Representante representante;
    private int rendaTotal;
    private List<Dependente> dependentes = new ArrayList<>();
    private int totaisDedependentesValidos;
    private int pontuacao = 0;
    private Conjuge conjuge;

    public Familia(Representante representante, int rendaTotal, List<Dependente> dependentes, Conjuge conjuge) {

        this.representante = validarRepresentante(representante);
        this.rendaTotal = validarRenda(rendaTotal);
        this.dependentes = Collections
                .unmodifiableList(Objects.requireNonNull(dependentes, MensagensErro.NUMERO_DEPENDENTES_NULOS));
        this.conjuge = conjuge;
    }

    private Representante validarRepresentante(Representante representante) {
        if (representante == null) {
            throw new IllegalArgumentException(MensagensErro.REPRESENTANTE_NULO);
        }
        return representante;
    }

    private int validarRenda(int rendaTotal) {
        if (rendaTotal < 0) {
            throw new IllegalArgumentException(MensagensErro.RENDA_NEGATIVA);
        }
        return rendaTotal;
    }

    public void filtrarDependentesValidosParaSorteio() {
        int dependentesValidos = 0;
        LocalDate hoje = LocalDate.now();
        for (var dependente : this.dependentes) {
            if (ehDependenteValido(dependente, hoje)) {
                dependentesValidos++;
            }
        }
        this.totaisDedependentesValidos = dependentesValidos;
    }

    private boolean ehDependenteValido(Dependente dependente, LocalDate hoje) {
        return dependente.getDataDeNascimento() != null &&
                Period.between(dependente.getDataDeNascimento(), hoje).getYears() <= 18;
    }

    public void adicionarPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int obterTotaisDedependentesValidos(){
        filtrarDependentesValidosParaSorteio();
        return this.totaisDedependentesValidos;
    }
}
