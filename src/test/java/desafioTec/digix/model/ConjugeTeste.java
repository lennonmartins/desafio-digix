package desafioTec.digix.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConjugeTeste {
    @Test
    void voide_criar_um_conjuge_valido() {
        String nomeDependente = "Lennon Martins";
        LocalDate dataDeNascimento = LocalDate.of(1995, 4, 21);
        String cpf = "57808353060";
        Conjuge dependente = new Conjuge(nomeDependente, cpf,dataDeNascimento);

        assertEquals(nomeDependente, dependente.getNome());
    }
}
