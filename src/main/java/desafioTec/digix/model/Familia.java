package desafioTec.digix.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;

@Getter
@Entity
public class Familia {

    @OneToOne(cascade = CascadeType.ALL)
    private Representante representante;
    private double rendaTotal;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "familia_id")
    private List<Dependente> dependentes = new ArrayList<>();
    private int pontuacao = 0;
    @OneToOne(cascade = CascadeType.ALL)
    private Conjuge conjuge;
    private static final int IDADE_ADULTA = 18;

    public Familia(Representante representante, double rendaTotal, List<Dependente> dependentes, Conjuge conjuge) {

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

    private double validarRenda(Double rendaTotal) {
        if (rendaTotal < 0) {
            throw new IllegalArgumentException(MensagensErro.RENDA_NEGATIVA);
        }
        return rendaTotal;
    }

    private int filtrarDependentesValidosParaSorteio() {
        int dependentesValidos = 0;
        LocalDate hoje = LocalDate.now();
        for (var dependente : this.dependentes) {
            if (ehDependenteAptoAoSorteio(dependente, hoje))
                dependentesValidos++;
        }
        return dependentesValidos;
    }

    private boolean ehDependenteAptoAoSorteio(Dependente dependente, LocalDate hoje) {
        if (dependente.getDataDeNascimento() == null) {
            throw new IllegalArgumentException(MensagensErro.DATA_DE_NASCIMENTO_VAZIA_OU_NULA);
        }
        return Period.between(dependente.getDataDeNascimento(), hoje).getYears() <= IDADE_ADULTA;
    }

    public void adicionarPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int obterTotaisDeDedependentesAptos() {
        return filtrarDependentesValidosParaSorteio();
    }
}
