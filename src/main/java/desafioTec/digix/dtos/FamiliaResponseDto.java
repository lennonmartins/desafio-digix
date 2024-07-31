package desafioTec.digix.dtos;

import java.util.List;

public record FamiliaResponseDto(Long id, RepresentanteDto representante, int renda, List<DependenteDto> dependentes) {
}
