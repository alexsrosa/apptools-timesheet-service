package br.com.tools.timesheet.schedule;

import br.com.tools.timesheet.domain.manager.Consultor;
import br.com.tools.timesheet.domain.manager.enumeration.ConsultorStatus;
import br.com.tools.timesheet.service.manager.ConsultorService;
import br.com.tools.timesheet.service.manager.TimeSheetService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ConsultorSchedule extends ScheduleLog{

    @Autowired
    private TimeSheetService timeSheetService;

    @Autowired
    private ConsultorService consultorService;

    @Scheduled(fixedRate = 500000)
    public void atualizaConsultores(){

        this.startLog(LoggerFactory.getLogger(ConsultorSchedule.class));

        List<Consultor> allConsultores = timeSheetService.findAllConsultores();

        for (Consultor consultor: allConsultores) {

            Optional<Consultor> c = consultorService.findById(consultor.getId());

            if(c.isPresent()){

                if(!c.get().getDataultimoregistro().equals(consultor.getDataultimoregistro())){
                    Consultor cAtualiza = c.get();
                    cAtualiza.setDataultimoregistro(consultor.getDataultimoregistro());
                    cAtualiza.setFlativo(this.validaStatus(consultor.getDataultimoregistro()));
                    consultorService.save(cAtualiza);
                    this.addAlterados();
                }
            }else{
                consultor.setFlativo(this.validaStatus(consultor.getDataultimoregistro()));
                consultorService.save(consultor);
                this.addInseridos();
            }
        }

        this.finishLog();
    }

    /**
     *
     * @param ultimoRegistro
     * @return
     */
    private ConsultorStatus validaStatus(LocalDate ultimoRegistro){

        LocalDate limiteParaAtivo = LocalDate.now().minusDays(Long.parseLong(Long.toString(60)));

        if(ultimoRegistro.isAfter(limiteParaAtivo)){
            return ConsultorStatus.ATIVADO;
        }else{
            return ConsultorStatus.DESATIVADO;
        }
    }
}
