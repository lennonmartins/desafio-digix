package desafioTec.digix.model.builder;

import java.time.LocalDate;

import desafioTec.digix.model.Representante;

public class RepresentanteBuilderTest  extends PessoaBuilderTest<Representante, RepresentanteBuilderTest>{

    private String nome  = "Lenoardo dos Santos";;
    private String cpf = "01756232288" ;
    private LocalDate dataDeNascimento = LocalDate.of(1995, 1, 21);
    @Override
    protected Representante construir() {
       return new Representante(nome, cpf, dataDeNascimento);
    };

}
