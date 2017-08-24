package br.com.tools.timesheet.service.manager;


import br.com.tools.timesheet.domain.manager.Consultor;
import br.com.tools.timesheet.domain.manager.TimeSheet;
import br.com.tools.timesheet.repository.manager.TimeSheetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing TimeSheet.
 */
@Service
@Transactional
public class TimeSheetService {

    private final Logger log = LoggerFactory.getLogger(TimeSheetService.class);

    @Autowired
    private TimeSheetRepository repository;

    public TimeSheet save(TimeSheet timeSheet) {
        log.debug("Request to save TimeSheet : {}", timeSheet);
        TimeSheet result = this.repository.save(timeSheet);

        return result;
    }

    public Optional<TimeSheet> findById(Long id){
        log.debug("Request to findById TimeSheet : {}", id);
        return this.repository.findById(id.intValue());
    }

    public List<TimeSheet> findByData(LocalDate data) {
        log.debug("Request to findByData TimeSheet : {}", data);
        return this.repository.findByData(data);
    }

    public List<TimeSheet> findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndDataAndObservacao(TimeSheet timeSheet){
        log.debug("Request to findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndDataAndObservacao TimeSheet : {}", timeSheet.toString());
        return this.repository.findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndDataAndObservacao(timeSheet.getMatricula()
                ,timeSheet.getTarefa(),timeSheet.getCodigofase(),timeSheet.getCodigoatividade(),timeSheet.getData()
                ,timeSheet.getObservacao());
    }

    public void deleteById(Long id){
        log.debug("Request to deleteById TimeSheet : {}", id);
        this.repository.deleteById(id);
    }

    /**
     *
     * @return
     */
    public List<Consultor> findAllConsultores() {

        List<Object[]> allConsultores = repository.findAllConsultores();
        List<Consultor> consultores = new ArrayList<>();

        for (Object[] object: allConsultores) {

            Consultor consultor = new Consultor();
            for (int i = 0; i < object.length; i++) {

                String s = object[i]+"";
                switch (i) {
                    case 0:
                        consultor.setId(Long.valueOf(s));
                        break;
                    case 1:
                        consultor.setNome(s);
                        break;
                    case 2:
                        consultor.setDataprimeiroregistro(LocalDate.parse(s));
                        break;
                    case 3:
                        consultor.setDataultimoregistro(LocalDate.parse(s));
                        break;
                }
            }

            consultores.add(consultor);
        }

        return consultores;
    }

}
