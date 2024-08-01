package desafioTec.digix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import desafioTec.digix.model.Familia;

@Repository
public class FamiliaRepository implements IFamiliaRepository {

    private final List<Familia> familias;

    public FamiliaRepository() {
        this.familias = new ArrayList<>();
    }

    @Override
    public void adicionarFamilia(Familia familia) {
        familias.add(familia);
    }

    @Override
    public List<Familia> obterFamilias() {
        return new ArrayList<>(familias);
    }

}
