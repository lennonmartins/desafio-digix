package desafioTec.digix.service;

import java.util.List;

import desafioTec.digix.model.Familia;

public interface IListagemFamiliaService {
    List<Familia> ordernarListaDeFamiliaPorPonto(List<Familia> familias);
}