package br.com.tools.timesheet.repository.manager;

import br.com.tools.timesheet.domain.manager.Consultor;
import br.com.tools.timesheet.domain.manager.TimeSheet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeSheetRepository extends CrudRepository<TimeSheet,Integer>, JpaSpecificationExecutor {

    List<TimeSheet> findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndDataAndObservacao(Integer matricula,Integer tarefa,Integer codigofase,Integer codigoatividade,LocalDate data, String observacao);
    List<TimeSheet> findByData(LocalDate data);
    void deleteById(Long id);

    @Query(value = "select t.matricula as id, \n" +
            "t.nome as nome,  \n" +
            "min(data) as dataprimeiroregistro,   \n" +
            "max(data) as dataultimoregistro \n" +
            "from time_sheet t \n" +
            "group by t.matricula, t.nome;", nativeQuery = true)
    List<Object[]> findAllConsultores();
}
