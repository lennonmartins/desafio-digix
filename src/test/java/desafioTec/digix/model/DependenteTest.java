package desafioTec.digix.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DependenteTest {

    private static Stream<Arguments> forneceDependenteComDadosAusentes() {
        LocalDate dataDeNascimentoValida = LocalDate.of(2010, 1, 21);
        return Stream.of(
                Arguments.of("", dataDeNascimentoValida,
                        MensagensErro.NOME_NULO_OU_VAZIO),
                Arguments.of("João Silva", null,
                        MensagensErro.DATA_DE_NASCIMENTO_VAZIA_OU_NULA));
    }
    
    @Test
    void voide_criar_um_dependendte_valido(){
        String nomeDependente = "Lennon Martins";
        LocalDate dataDeNascimento = LocalDate.of(2010, 4, 21);
        Dependente dependente = new Dependente(nomeDependente, dataDeNascimento);

        assertEquals(nomeDependente, dependente.getNome());       
    }

    @ParameterizedTest
    @MethodSource("forneceDependenteComDadosAusentes")
    void nao_deve_criar_dependente_com_atributo_faltante(String nome, LocalDate dataDeNascimento,
            String mensagemDeErroEsperada) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Dependente(nome, dataDeNascimento);
        });

        assertEquals(mensagemDeErroEsperada, exception.getMessage());
    }
}
