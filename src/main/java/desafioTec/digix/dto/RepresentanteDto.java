package desafioTec.digix.dto;

import java.time.LocalDate;

public record RepresentanteDto(String nome, LocalDate dataDeNascimento, String cpf) {
}
