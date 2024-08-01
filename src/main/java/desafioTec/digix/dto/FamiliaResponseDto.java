package desafioTec.digix.dto;

import java.util.List;

public record FamiliaResponseDto(RepresentanteDto representante, double rendaTotal, List<DependenteDto> dependentes, ConjugeDto conjuge) {
}
