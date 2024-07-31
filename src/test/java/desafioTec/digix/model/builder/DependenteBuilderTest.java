package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Dependente;
import lombok.Getter;

@Getter
public class DependenteBuilderTest {

    private String nome;
    private LocalDate dataNascimento;

    public DependenteBuilderTest() {
        this.nome = "Lenoardo dos Santos";
        this.dataNascimento = LocalDate.of(2010, 1, 21);
    }

    public Dependente criar() {
        return new Dependente(this.nome, this.dataNascimento);
    }

    public DependenteBuilderTest comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public DependenteBuilderTest comDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
}
