package desafioTec.digix.model;

import java.time.LocalDate;

import desafioTec.digix.model.valor.Cpf;
import lombok.Getter;

@Getter
public abstract class Pessoa {
    private String nome;
    private Cpf cpf;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this(nome, null, dataNascimento);
    }

    public Pessoa(String nome, Cpf cpf, LocalDate dataNascimento) {
        this.nome = validaNome(nome);
        this.cpf = cpf;
        this.dataNascimento = validarDataDeNascimento(dataNascimento);
    }

    private LocalDate validarDataDeNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException(MensagensErro.DATA_DE_NASCIMENTO_VAZIA_OU_NULA);
        }

        return dataNascimento;
    }

    private String validaNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(MensagensErro.NOME_NULO_OU_VAZIO);
        }
        return nome;
    }

}
