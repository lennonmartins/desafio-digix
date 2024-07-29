package desafioTec.digix.service;

import java.util.Comparator;
import java.util.List;

import desafioTec.digix.model.Familia;

public class FamiliaService {

    private CalculadoraPontuacao calculadoraPontuacao;

    public FamiliaService(CalculadoraPontuacao calculadoraPontuacao) {
        this.calculadoraPontuacao = calculadoraPontuacao;
    }

    public List<Familia> ordernarPelaPontucao(List<Familia> familias) {
        familias.sort(Comparator.comparingInt(calculadoraPontuacao::calcularPontuacaoTotal).reversed());
        return familias;
    }
}
