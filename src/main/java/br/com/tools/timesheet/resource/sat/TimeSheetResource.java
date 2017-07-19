package br.com.tools.timesheet.resource.sat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tools.timesheet.domain.sat.ViewTimeSheet;
import br.com.tools.timesheet.service.sat.ViewTimeSheetService;

@RestController
@RequestMapping(value = "/timesheets")
public class TimeSheetResource {

	@Autowired
	private ViewTimeSheetService service;

	@RequestMapping(value = "/matricula/{matricula}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<ViewTimeSheet> findByMatricula(@PathVariable String matricula) {
		return this.service.findByMatricula(matricula);
	}

	@RequestMapping(value = "/matricula/{matricula}/periodo/{data1}/{data2}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<ViewTimeSheet> findByMatriculaWithPeriodo(@PathVariable String matricula, @PathVariable String data1,
			@PathVariable String data2) {
		return this.service.findByMatriculaWithPeriodo(matricula, data1, data2);
	}

	@RequestMapping(value = "/tarefa/{tarefa}", method = RequestMethod.GET)
	public List<ViewTimeSheet> findByTarefa(@PathVariable String tarefa) {
		return this.service.findByTarefa(tarefa);
	}
	
	@RequestMapping(value = "/tarefa/{matricula}/periodo/{data1}/{data2}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<ViewTimeSheet> findByTarefaWithPeriodo(@PathVariable String tarefa, @PathVariable String data1,
			@PathVariable String data2) {
		return this.service.findByTarefaWithPeriodo(tarefa, data1, data2);
	}

	@RequestMapping(value = "/periodo/{data1}/{data2}", method = RequestMethod.GET)
	public List<ViewTimeSheet> findByData(@PathVariable String data1, @PathVariable String data2) {
		return this.service.findByData(data1, data2);
	}

	/*
	 * @RequestMapping(value = "/busca", method = RequestMethod.GET) public
	 * List<ViewTimeSheet> busca(@ModelAttribute("viewTimeSheet") ViewTimeSheet
	 * timeSheet,
	 * 
	 * @RequestParam(value = "data2", required = false) String data2) { return
	 * this.service.busca(timeSheet, data2); }
	 */

}
