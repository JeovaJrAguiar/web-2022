package web.ufc.br.classsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import web.ufc.br.classsystem.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Integer> {
    List<Turma> findByNameOrCodigo(String name, String codigo);

    @Query("select t from Turma t where t.codigo like %?1")
    List<Turma> findTurmas(String codigo);
}

