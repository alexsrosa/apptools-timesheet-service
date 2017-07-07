package br.com.tools.timesheet.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tools.timesheet.domain.ViewTimeSheet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetServiceTest {
	
	@Autowired
	private ViewTimeSheetService service;
	
	@Test
	public void testFetchTarefa() {
		List<ViewTimeSheet> viewTimeSheet = service.findByTarefa("995894");

		int count = 0;
		Boolean b = false;
		for (@SuppressWarnings("unused") ViewTimeSheet timeSheet : viewTimeSheet) {
			count++;
		}

		System.out.println("#testFetchTarefa -- Total de registros encontrados: " + count);

		if (count > 0) {
			b = true;
		}

		assertEquals(true, b);
	}
	
	@Test
	public void testFetchMatricula() {
		List<ViewTimeSheet> viewTimeSheet = service.findByMatricula("00445");

		int count = 0;
		Boolean b = false;
		for (@SuppressWarnings("unused") ViewTimeSheet timeSheet : viewTimeSheet) {
			count++;
		}

		System.out.println("#testFetchMatricula -- Total de registros encontrados: " + count);

		if (count > 0) {
			b = true;
		}

		assertEquals(true, b);
	}
	

	@Test
	public void testFetchByData() {

		List<ViewTimeSheet> viewTimeSheet = service.findByData("2017-06-01", "2017-06-30");

		int count = 0;
		Boolean b = false;
		for (@SuppressWarnings("unused") ViewTimeSheet timeSheet : viewTimeSheet) {
			count++;
		}

		System.out.println("#testFetchPeriodoString -- Total de registros encontrados: " + count);

		if (count > 0) {
			b = true;
		}

		assertEquals(true, b);
	}

}
