package desafioTec.digix.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RepresentanteTest {

    private static Stream<Arguments> forneceRepresentanteComDadosAusentes() {
        String cpfValido = "01756232288";
        LocalDate dataDeNascimentoValida = LocalDate.of(1995, 1, 21);
        return Stream.of(
                Arguments.of("", cpfValido, dataDeNascimentoValida,
                        MensagensErro.NOME_NULO_OU_VAZIO),
                Arguments.of("João Silva", "", dataDeNascimentoValida,
                        MensagensErro.CPF_INVALIDO),
                Arguments.of("João Silva", cpfValido, null,
                        MensagensErro.DATA_DE_NASCIMENTO_VAZIA_OU_NULA));
    }

    @Test
    void deve_criar_um_representante_valido() {
        String nomeDoRepresentante = "Lenoardo dos Santos";
        String cpfDoRepresentante = "01756232288";
        LocalDate dataDeNascimento = LocalDate.of(1995, 1, 21);

        Representante representante = new Representante(nomeDoRepresentante, cpfDoRepresentante, dataDeNascimento);

        assertEquals(nomeDoRepresentante, representante.getNome());
        assertEquals(cpfDoRepresentante, representante.getCpf().getValorCpf());
        assertEquals(dataDeNascimento, representante.getDataDeNascimento());
    }

    @ParameterizedTest
    @MethodSource("forneceRepresentanteComDadosAusentes")
    void nao_deve_criar_representante_com_atributo_faltante(String nome, String cpf, LocalDate dataDeNascimento,
            String mensagemDeErroEsperada) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Representante(nome, cpf, dataDeNascimento);
        });

        assertEquals(mensagemDeErroEsperada, exception.getMessage());
    }
}
