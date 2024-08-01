package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Conjuge;

public class ConjugeBuilderTest extends PessoaBuilderTest<Conjuge, ConjugeBuilderTest>{

    private String nome = "Maria Silva";
    private String cpf = "57808353060";
    LocalDate dataDeNascimento = LocalDate.of(1995, 4, 21);

    @Override
    protected Conjuge construir() {
        return new Conjuge(nome, cpf, dataDeNascimento);
    }
    
}
