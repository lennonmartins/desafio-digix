package desafioTec.digix.model.builder;

import desafioTec.digix.model.Dependente;

public class DependenteBuilderTest extends PessoaBuilderTest<Dependente, DependenteBuilderTest>{

    @Override
    protected Dependente construir() {
        return new Dependente(nome, dataDeNascimento);
    };
}
