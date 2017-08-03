package br.com.tools.timesheet.repository.manager;

import br.com.tools.timesheet.domain.manager.TimeSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeSheetRepository extends CrudRepository<TimeSheet,Integer> {

    List<TimeSheet> findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndData(Integer matricula,Integer tarefa,Integer codigofase,Integer codigoatividade,LocalDate data);
    List<TimeSheet> findByData(LocalDate data);
    void deleteById(Long id);
}
