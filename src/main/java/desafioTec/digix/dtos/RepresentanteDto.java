package desafioTec.digix.dtos;

import java.time.LocalDate;

public record RepresentanteDto(String nome, LocalDate dataDeNascimento, String cpf) {
}
