package desafioTec.digix.model;

import java.time.LocalDate;

import desafioTec.digix.model.valor.Cpf;

public class Representante extends Pessoa {

    public Representante(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, new Cpf(cpf), dataNascimento);
    }

}
