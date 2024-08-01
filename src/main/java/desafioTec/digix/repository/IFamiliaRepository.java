package desafioTec.digix.repository;

import java.util.List;

import desafioTec.digix.model.Familia;

public interface IFamiliaRepository {
    void adicionarFamilia (Familia familia);
    List<Familia> obterFamilias ();
}
