package desafioTec.digix.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import desafioTec.digix.model.valor.Cpf;


@Entity
public class Conjuge extends Pessoa {

    public Conjuge(String nome, String cpf, LocalDate dataDeNascimento) {
        super(nome, new Cpf(cpf), dataDeNascimento);
    }

}
