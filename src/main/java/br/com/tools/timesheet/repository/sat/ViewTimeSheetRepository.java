package br.com.tools.timesheet.repository.sat;

import br.com.tools.timesheet.domain.sat.ViewTimeSheet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewTimeSheetRepository extends CrudRepository<ViewTimeSheet, Integer> {

	List<ViewTimeSheet> findAll();

	long count();

	boolean existsById(Integer arg0);

	List<ViewTimeSheet> findByMatricula(String matricula);
	List<ViewTimeSheet> findByTarefa(String tarefa);

	@Query(value = "SELECT * FROM SAT_VIEW_POA where matricula =:matricula and dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByMatriculaWithPeriodo(@Param("matricula") String matricula, @Param("data1") String data1,
			@Param("data2") String data2);

	@Query(value = "SELECT * FROM SAT_VIEW_POA where tarefa =:tarefa and dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByTarefaWithPeriodo	(@Param("tarefa") String tarefa, @Param("data1") String data1,
			@Param("data2") String data2);

	@Query(value = "SELECT * FROM SAT_VIEW_POA where dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByData(@Param("data1") String data1,@Param("data2") String data2);

	@Query(value = "SELECT * FROM SAT_VIEW_POA where dt_timesheet between CONVERT(VARCHAR(10), :data1, 103) and CONVERT(VARCHAR(10), :data2, 103) order by dt_timesheet asc", nativeQuery = true)
	List<ViewTimeSheet> findByDataByDataAsc(@Param("data1") String data1,@Param("data2") String data2);





}
