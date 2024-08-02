package desafioTec.digix.model.valor;

import java.util.Objects;

import desafioTec.digix.model.MensagensErro;
import lombok.Getter;

@Getter
public class Cpf {
    private final String valorCpf;

    public Cpf(String valorCpf) {
        validarCpf(valorCpf);
        this.valorCpf = valorCpf;
    }

    private void validarCpf(String valorCpf) {
        if (valorCpf == null || valorCpf.isEmpty() || !valorCpf.matches("\\d{11}")) {
            throw new IllegalArgumentException(MensagensErro.CPF_INVALIDO);
        }
//       if (!ehCpfValido(valorCpf)) {
//           throw new IllegalArgumentException(MensagensErro.CPF_INVALIDO);
//       }
    }

    private boolean ehCpfValido(String cpf) {

        if (cpf.length() != 11) {
            return false;
        }
    
        int soma = 0;
        int resto;
        String cpfSemDigito = cpf.substring(0, 9);
        String digitos = cpf.substring(9);

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpfSemDigito.charAt(i)) * (10 - i);
        }
        resto = soma % 11;
        if (resto < 2) {
            resto = 0;
        } else {
            resto = 11 - resto;
        }
        if (resto != Character.getNumericValue(digitos.charAt(0))) {
            return false;
        }

        soma = 0;
        cpfSemDigito += digitos.charAt(0);
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpfSemDigito.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        if (resto < 2) {
            resto = 0;
        } else {
            resto = 11 - resto;
        }
        return resto == Character.getNumericValue(digitos.charAt(1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cpf cpf = (Cpf) o;
        return valorCpf.equals(cpf.valorCpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valorCpf);
    }

    @Override
    public String toString() {
        return valorCpf;
    }
}