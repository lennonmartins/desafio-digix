package desafioTec.digix.model.builder;

import desafioTec.digix.model.Conjuge;

public class ConjugeBuilderTest extends PessoaBuilderTest<Conjuge, ConjugeBuilderTest>{
    @Override
    protected Conjuge construir() {
        return new Conjuge(nome, cpf, dataDeNascimento);
    }
    
}
