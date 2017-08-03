package br.com.tools.timesheet.repository.manager;

import br.com.tools.timesheet.domain.manager.Parametro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Integer> {

    Parametro findByNome(String nome);

}
