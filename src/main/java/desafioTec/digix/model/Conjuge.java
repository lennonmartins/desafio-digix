package desafioTec.digix.model;

import java.time.LocalDate;

import desafioTec.digix.model.valor.Cpf;

public class Conjuge extends Pessoa {

    public Conjuge(String nome, String cpf, LocalDate dataDeNascimento) {
        super(nome, new Cpf(cpf), dataDeNascimento);
    }

}
