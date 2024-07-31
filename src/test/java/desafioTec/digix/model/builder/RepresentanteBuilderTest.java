package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Representante;
import lombok.Getter;

@Getter
public class RepresentanteBuilderTest {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public RepresentanteBuilderTest() {
        this.nome = "Lenoardo dos Santos";
        this.cpf = "01756232288";
        this.dataNascimento = LocalDate.of(1995, 1, 21);
    }

    public Representante criar() {
        return new Representante(this.nome, this.cpf, this.dataNascimento);
    }

    public RepresentanteBuilderTest comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public RepresentanteBuilderTest comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public RepresentanteBuilderTest comDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
}
