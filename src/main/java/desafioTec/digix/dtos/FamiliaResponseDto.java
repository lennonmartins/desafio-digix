package desafioTec.digix.dtos;

import java.util.List;

public record FamiliaResponseDto(RepresentanteDto representante, int rendaTotal, List<DependenteDto> dependentes, ConjugeDto conjuge) {
}
