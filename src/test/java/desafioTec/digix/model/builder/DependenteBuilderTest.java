package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Dependente;
import lombok.Getter;

@Getter
public class DependenteBuilderTest {

    private String nome;
    private LocalDate dataDeNascimento;

    public DependenteBuilderTest() {
        this.nome = "Lenoardo dos Santos";
        this.dataDeNascimento = LocalDate.of(2010, 1, 21);
    }

    public Dependente criar() {
        return new Dependente(this.nome, this.dataDeNascimento);
    }

    public DependenteBuilderTest comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public DependenteBuilderTest comDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }
}
