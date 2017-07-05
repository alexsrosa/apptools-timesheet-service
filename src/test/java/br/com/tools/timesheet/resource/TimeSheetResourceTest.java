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
    public void timeSheetWithMatriculaValida() throws Exception {
    	this.mockMvc.perform(get("/timesheets/matricula/00445"))
    				.andDo(print())
    				.andExpect(status().isOk());
    }
    
    ///timesheets/periodo/2017-06-01/2017-06-05

}
