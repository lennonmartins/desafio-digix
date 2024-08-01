package desafioTec.digix.controller.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import desafioTec.digix.dtos.ConjugeDto;
import desafioTec.digix.dtos.DependenteDto;
import desafioTec.digix.dtos.FamiliaRequestDto;
import desafioTec.digix.dtos.RepresentanteDto;

public class FamiliaRequestDtoBuilder {
    private RepresentanteDto representante;
    private int renda;
    private List<DependenteDto> dependentes;
    private ConjugeDto conjuge;

    public FamiliaRequestDtoBuilder() {
        this.representante = new RepresentanteDto("Lennon Martins", LocalDate.of(1995, 2, 21), "01756232288");
        this.renda = 800;
        this.dependentes = new ArrayList<>();
        this.conjuge = new ConjugeDto("Maria Silva", LocalDate.of(1995, 2, 21), "57808353060");
    }

    public FamiliaRequestDtoBuilder comRepresentante(RepresentanteDto representante) {
        this.representante = representante;
        return this;
    }

    public FamiliaRequestDtoBuilder comRenda(int renda) {
        this.renda = renda;
        return this;
    }

    public FamiliaRequestDtoBuilder comDependentes(List<DependenteDto> dependentes) {
        this.dependentes = dependentes;
        return this;
    }

    public FamiliaRequestDto criar() {
        return new FamiliaRequestDto(representante, renda, dependentes, conjuge);
    }

    public FamiliaRequestDtoBuilder comConjuge(ConjugeDto conjuge) {
        this.conjuge = conjuge;
        return this;
    }

}
