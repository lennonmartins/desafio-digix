package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Pessoa;

public abstract class PessoaBuilderTest<T extends Pessoa, B extends PessoaBuilderTest<T, B>> {
    protected String nome;
    protected String cpf;
    protected LocalDate dataDeNascimento;

    public B nome(String nome) {
        this.nome = nome;
        return (B) this;
    }

    public B cpf(String cpf) {
        this.cpf = cpf;
        return (B) this;
    }

    public B dataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return (B) this;
    }

    protected abstract T construir();

    public T criar() {
        return construir();
    }
}