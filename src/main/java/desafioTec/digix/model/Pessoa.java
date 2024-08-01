package desafioTec.digix.model;

import java.time.LocalDate;

import desafioTec.digix.model.valor.Cpf;
import lombok.Getter;

@Getter
public abstract class Pessoa {
    private String nome;
    private Cpf cpf;
    private LocalDate dataDeNascimento;

    public Pessoa(String nome, LocalDate dataDeNascimento) {
        this(nome, null, dataDeNascimento);
    }

    public Pessoa(String nome, Cpf cpf, LocalDate dataDeNascimento) {
        this.nome = validarNome(nome);
        this.cpf = cpf;
        this.dataDeNascimento = validarDataDeNascimento(dataDeNascimento);
    }

    private LocalDate validarDataDeNascimento(LocalDate dataDeNascimento) {
        if (dataDeNascimento == null) {
            throw new IllegalArgumentException(MensagensErro.DATA_DE_NASCIMENTO_VAZIA_OU_NULA);
        }

        return dataDeNascimento;
    }

    private String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(MensagensErro.NOME_NULO_OU_VAZIO);
        }
        return nome;
    }

}
