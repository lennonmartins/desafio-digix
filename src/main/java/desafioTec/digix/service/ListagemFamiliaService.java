package desafioTec.digix.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import desafioTec.digix.model.Familia;
@Service
public class ListagemFamiliaService implements IListagemFamiliaService {

    private final IObtemFamilia obtemFamilia;

    public ListagemFamiliaService(IObtemFamilia obtemFamilia) {
        this.obtemFamilia = obtemFamilia;
    }

    public List<Familia> ordernarListaDeFamiliaPorPonto(List<Familia> familias) {
        List<Familia> familiasPontuadas = familias.stream().map(obtemFamilia::obterComPontuacao)
                .collect(Collectors.toList());

        var familiasOrdenadas = familiasPontuadas.stream().sorted(
                Comparator.comparingInt(Familia::getPontuacao).reversed().thenComparingInt(Familia::getRendaTotal))
                .collect(Collectors.toList());

        return familiasOrdenadas;
    }
}