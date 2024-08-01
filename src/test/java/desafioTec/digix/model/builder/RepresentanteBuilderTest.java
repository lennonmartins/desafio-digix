package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Representante;
import lombok.Getter;

@Getter
public class RepresentanteBuilderTest {

    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;

    public RepresentanteBuilderTest() {
        this.nome = "Lenoardo dos Santos";
        this.cpf = "01756232288";
        this.dataDeNascimento = LocalDate.of(1995, 1, 21);
    }

    public Representante criar() {
        return new Representante(this.nome, this.cpf, this.dataDeNascimento);
    }

    public RepresentanteBuilderTest comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public RepresentanteBuilderTest comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public RepresentanteBuilderTest comdataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }
}
