package br.com.tools.timesheet.repository.manager;

import br.com.tools.timesheet.domain.manager.TimeSheet;
import org.springframework.data.repository.CrudRepository;

public interface TimeSheetRepository extends CrudRepository<TimeSheet,Integer> {


}
