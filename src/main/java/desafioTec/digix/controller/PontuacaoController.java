package desafioTec.digix.controller;

import java.util.List;

import desafioTec.digix.model.Familia;
import desafioTec.digix.service.IListagemFamiliaService;

public class PontuacaoController {
    private final IListagemFamiliaService listaFamiliaService;

    public PontuacaoController(IListagemFamiliaService listaFamiliaService) {
        this.listaFamiliaService = listaFamiliaService;
    }

    public List<Familia> listarFamiliaPontuada(List<Familia> familias) {
        List<Familia> familiasOrdenadas = listaFamiliaService.ordernarListaDeFamiliaPorPonto(familias);
        return familiasOrdenadas;
    }
}