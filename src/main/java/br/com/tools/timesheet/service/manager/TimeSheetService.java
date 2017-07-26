package br.com.tools.timesheet.service.manager;


import br.com.tools.timesheet.domain.manager.TimeSheet;
import br.com.tools.timesheet.repository.manager.TimeSheetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing TimeSheet.
 */
@Service
public class TimeSheetService {

    private final Logger log = LoggerFactory.getLogger(TimeSheetService.class);

    @Autowired
    private TimeSheetRepository repository;

    /**
     * Save a timeSheet.
     *
     * @param timeSheet the entity to save
     * @return the persisted entity
     */
    public TimeSheet save(TimeSheet timeSheet) {
        log.debug("Request to save TimeSheet : {}", timeSheet);
        TimeSheet result = this.repository.save(timeSheet);

        return result;
    }
}
