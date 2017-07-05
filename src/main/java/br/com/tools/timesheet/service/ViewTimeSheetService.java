package br.com.tools.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tools.timesheet.domain.ViewTimeSheet;
import br.com.tools.timesheet.repositories.ViewTimeSheetRepository;

@Service
public class ViewTimeSheetService {

	@Autowired
	private ViewTimeSheetRepository repository;

	public List<ViewTimeSheet> findByTarefa(String tarefa) {
		return this.repository.findByTarefa(tarefa);
	}
	
	public List<ViewTimeSheet> findByMatricula(String matricula) {
		return this.repository.findByMatricula(matricula);
	}

	public List<ViewTimeSheet> findByData(String data1, String data2) {
		return this.repository.findByData(data1, data2);
	}

}
