package br.com.tools.timesheet.service.sat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tools.timesheet.domain.sat.ViewTimeSheet;
import br.com.tools.timesheet.repositories.sat.ViewTimeSheetRepository;

@Service
public class ViewTimeSheetService {

	@Autowired
	private ViewTimeSheetRepository repository;


	public List<ViewTimeSheet> findByMatricula(String matricula) {
		return this.repository.findByMatricula(matricula);
	}

	public List<ViewTimeSheet> findByMatriculaWithPeriodo(String matricula, String data1, String data2) {
		return this.repository.findByMatriculaWithPeriodo(matricula, data1, data2);
	}
	
	public List<ViewTimeSheet> findByTarefa(String tarefa) {
		return this.repository.findByTarefa(tarefa);
	}

	public List<ViewTimeSheet> findByTarefaWithPeriodo(String tarefa, String data1, String data2) {
		return this.repository.findByTarefaWithPeriodo(tarefa, data1, data2);
	}
	
	public List<ViewTimeSheet> findByData(String data1, String data2) {
		return this.repository.findByData(data1, data2);
	}

}
