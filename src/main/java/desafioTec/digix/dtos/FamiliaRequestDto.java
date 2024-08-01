package desafioTec.digix.dtos;

import java.util.List;

public record FamiliaRequestDto(RepresentanteDto representante, int rendaTotal, List<DependenteDto> dependentes, ConjugeDto conjuge) {
}
