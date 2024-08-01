package desafioTec.digix.dto;

import java.util.List;

public record FamiliaRequestDto(RepresentanteDto representante, double rendaTotal, List<DependenteDto> dependentes, ConjugeDto conjuge) {
}
