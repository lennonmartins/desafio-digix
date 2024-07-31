package desafioTec.digix.model.valor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import desafioTec.digix.model.MensagensErro;

public class CpfTest {

    @Test
    void deve_criar_um_cpf_valido() {
        String valorCpf = "01756232288";
        Cpf cpf = new Cpf(valorCpf);
        assertEquals(valorCpf, cpf.getValorCpf());
    }

    @Test
    void deve_lancar_excecao_para_cpf_invalido() {
        String valorCpf = "12345678911";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cpf(valorCpf);
        });

        assertEquals(MensagensErro.CPF_INVALIDO, exception.getMessage());
    }

    @Test
    void deve_retornar_codigo_hash_correto(){
        String valorCpf = "01756232288";
        Cpf cpf = new Cpf(valorCpf);
        assertEquals(Objects.hashCode(valorCpf), cpf.hashCode());
    }

    @Test
    void deve_retornar_a_string_correta() {
        String valorCpf = "01756232288";
        Cpf cpf = new Cpf(valorCpf);
        assertEquals(valorCpf, cpf.toString());
    }

}
