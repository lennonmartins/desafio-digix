package desafioTec.digix.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import desafioTec.digix.model.Familia;

public class ListagemFamiliaService implements IListagemFamiliaService {

    private final IObtemFamilia obtemFamilia;

    public ListagemFamiliaService(IObtemFamilia obtemFamilia) {
        this.obtemFamilia = obtemFamilia;
    }

    public List<Familia> ordernarListaDeFamiliaPorPonto(List<Familia> familias) {
        // Obtem listagem de familias pontuadas
        List<Familia> familiasPontuadas = familias.stream().map(obtemFamilia::ObterComPontuacao)
                .collect(Collectors.toList());

        // Obtem listagem de familias pontuadas ordenadas
        var familiasOrdenadas = familiasPontuadas.stream().sorted(
                Comparator.comparingInt(Familia::getPontuacao).reversed().thenComparingInt(Familia::getRendaTotal))
                .collect(Collectors.toList());

        return familiasOrdenadas;
    }
}