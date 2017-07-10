package br.com.tools.timesheet.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.tools.timesheet.domain.sat.ViewTimeSheet;
import br.com.tools.timesheet.repositories.sat.ViewTimeSheetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViewTimeSheetRepositoryTest {

	@Autowired
	private ViewTimeSheetRepository repository;

	@Test
	public void testFetchAll() {
		Iterable<ViewTimeSheet> timeSheets = repository.findAll();

		int count = 0;
		Boolean b = false;
		for (Iterator<ViewTimeSheet> iterator = timeSheets.iterator(); iterator.hasNext();) {
			@SuppressWarnings("unused")
			ViewTimeSheet timeSheet = (ViewTimeSheet) iterator.next();
			count++;
		}

		System.out.println("#testFetchAll --Total de registros encontrados: " + count);

		if (count > 0) {
			b = true;
		}

		assertEquals(true, b);
	}

	@Test
	public void testFetchMatricula() {
		List<ViewTimeSheet> viewTimeSheet = repository.findByMatricula("00445");

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
	public void testFetchTarefa() {
		List<ViewTimeSheet> viewTimeSheet = repository.findByTarefa("995894");

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
	public void testCountRegisters() {
		long count = repository.count();

		System.out.println("#testCountRegisters -- Total de registros encontrados: " + count);

		if (count > 0) {
			assertEquals(true, true);
		} else {
			assertEquals(true, false);
		}
	}

	@Test
	public void testFetchByData() {

		List<ViewTimeSheet> viewTimeSheet = repository.findByData("2017-06-01", "2017-06-30");

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
	
	@Test
	public void testFetchByDataWithTarefa() {
		
		List<ViewTimeSheet> viewTimeSheet = repository.findByDataWithTarefa("2017-06-01", "2017-06-30", "995894");
		
		int count = 0;
		Boolean b = false;
		for (@SuppressWarnings("unused") ViewTimeSheet timeSheet : viewTimeSheet) {
			count++;
		}
		
		System.out.println("#testFetchByDataWithTarefa -- Total de registros encontrados: " + count);
		
		if (count > 0) {
			b = true;
		}
		
		assertEquals(true, b);
	}

}
