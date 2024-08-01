package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Pessoa;

public abstract class PessoaBuilderTest<T extends Pessoa, B extends PessoaBuilderTest<T, B>> {
    protected String nome = "Lennon dos Santos";
    protected LocalDate dataDeNascimento = LocalDate.of(2010, 1, 21);
    protected String cpf = "57808353060";

    @SuppressWarnings("unchecked")
    public B comNome(String nome) {
        this.nome = nome;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B comCpf(String cpf) {
        this.cpf = cpf;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B comDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return (B) this;
    }

    protected abstract T construir();

    public T criar() {
        return construir();
    }
}