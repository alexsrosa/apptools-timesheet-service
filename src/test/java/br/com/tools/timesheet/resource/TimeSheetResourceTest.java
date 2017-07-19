package br.com.tools.timesheet.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeSheetResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void timeSheetByMatriculaValida() throws Exception {
		this.mockMvc.perform(get("/timesheets/matricula/00445")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void timeSheetByMatriculaError() throws Exception {
		this.mockMvc.perform(get("/timesheets/matricula")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void timeSheetByMatriculaWithPeriodoValido() throws Exception {
		this.mockMvc.perform(get("/timesheets/matricula/00445/periodo/2017-05-01/2017-05-31")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void timeSheetByMatriculaWithPeriodoError1() throws Exception {
		this.mockMvc.perform(get("/timesheets/matricula/00445/periodo/2017-05-01")).andDo(print()).andExpect(status().isNotFound());
	}
	
	@Test
	public void timeSheetByMatriculaWithPeriodoError2() throws Exception {
		this.mockMvc.perform(get("/timesheets/matricula/periodo/2017-05-01")).andDo(print()).andExpect(status().isNotFound());
	}
	
	
	@Test
	public void timeSheetByTarefaValida() throws Exception {
		this.mockMvc.perform(get("/timesheets/tarefa/995894")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void timeSheetByTarefaError() throws Exception {
		this.mockMvc.perform(get("/timesheets/tarefa")).andDo(print()).andExpect(status().isNotFound());
	}
}
