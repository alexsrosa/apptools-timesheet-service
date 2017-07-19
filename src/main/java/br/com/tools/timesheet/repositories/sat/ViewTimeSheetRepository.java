package br.com.tools.timesheet.repositories.sat;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.tools.timesheet.domain.sat.ViewTimeSheet;

public interface ViewTimeSheetRepository extends Repository<ViewTimeSheet, Integer> {

	Iterable<ViewTimeSheet> findAll();

	long count();

	boolean existsById(Integer arg0);

	List<ViewTimeSheet> findByMatricula(String matricula);
	
	@Query(value = "SELECT * FROM SAT_VIEW_POA where matricula =:matricula and dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByMatriculaWithPeriodo(@Param("matricula") String matricula, @Param("data1") String data1,
			@Param("data2") String data2);

	List<ViewTimeSheet> findByTarefa(String tarefa);
	
	@Query(value = "SELECT * FROM SAT_VIEW_POA where tarefa =:tarefa and dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByTarefaWithPeriodo	(@Param("tarefa") String tarefa, @Param("data1") String data1,
			@Param("data2") String data2);

	@Query(value = "SELECT * FROM SAT_VIEW_POA where dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByData(@Param("data1") String data1,@Param("data2") String data2);





}
