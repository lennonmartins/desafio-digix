package desafioTec.digix.dtos;

import java.util.List;

public record FamiliaRequestDto(RepresentanteDto representante, int renda, List<DependenteDto> dependentes) {
}
