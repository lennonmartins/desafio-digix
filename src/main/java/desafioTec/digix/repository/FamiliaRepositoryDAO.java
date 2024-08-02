package desafioTec.digix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafioTec.digix.model.Familia;

@Repository
public interface FamiliaRepositoryDAO extends JpaRepository<Familia, Long> {
}