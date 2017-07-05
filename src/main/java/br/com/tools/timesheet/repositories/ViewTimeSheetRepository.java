package br.com.tools.timesheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.tools.timesheet.domain.ViewTimeSheet;

public interface ViewTimeSheetRepository extends Repository<ViewTimeSheet, Integer> {
	
	Iterable<ViewTimeSheet> findAll();

	long count();
	
	boolean existsById(Integer arg0);
	
	List<ViewTimeSheet> findByMatricula(String matricula);
	
	List<ViewTimeSheet> findByTarefa(String tarefa);
	
	@Query(value = "SELECT * FROM SAT_VIEW_POA where dt_timesheet between CONVERT(VARCHAR(10), ?1, 103) and CONVERT(VARCHAR(10), ?2, 103)", nativeQuery = true)
	List<ViewTimeSheet> findByData(String date1, String data2);
	
	@Query(value = "SELECT * FROM SAT_VIEW_POA where dt_timesheet between CONVERT(VARCHAR(10), ?1, 103) and CONVERT(VARCHAR(10), ?2, 103) and tarefa =?3", nativeQuery = true)
	List<ViewTimeSheet> findByDataWithTarefa(String date1, String data2, String tarefa);
		
}
