package desafioTec.digix.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import desafioTec.digix.model.valor.Cpf;

@Entity
public class Representante extends Pessoa {

    public Representante(String nome, String cpf, LocalDate dataDeNascimento) {
        super(nome, new Cpf(cpf), dataDeNascimento);
    }

}
