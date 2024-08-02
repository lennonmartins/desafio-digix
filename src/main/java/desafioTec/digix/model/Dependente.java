package desafioTec.digix.model;

import java.time.LocalDate;

import javax.persistence.Entity;


@Entity
public class Dependente extends Pessoa{

    public Dependente(String nome, LocalDate dataDeNascimento) {
        super(nome, dataDeNascimento);
    }
}
