package br.com.tools.timesheet.schedule;

import br.com.tools.timesheet.domain.manager.Consultor;
import br.com.tools.timesheet.service.manager.ConsultorService;
import br.com.tools.timesheet.service.manager.TimeSheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class ConsultorSchedule {

    private static final Logger log = LoggerFactory.getLogger(TimeSheetSchedule.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private TimeSheetService timeSheetService;

    @Autowired
    private ConsultorService consultorService;

    private int alterados = 0;
    private int inseridos = 0;

    @Scheduled(fixedRate = 50000)
    public void atualizaConsultores(){

        log.info(">>>>>>>>>>>>Início do processamento - Consultores ",dateFormat.format(new Date()));

        long tempoInicial = System.currentTimeMillis();
        this.alterados = 0;
        this.inseridos = 0;

        List<Consultor> allConsultores = timeSheetService.findAllConsultores();

        for (Consultor consultor: allConsultores) {

            Optional<Consultor> c = consultorService.findById(consultor.getId());

            if(c.isPresent()){

                if(!c.get().getDataultimoregistro().equals(consultor.getDataultimoregistro())){
                    Consultor cAtualiza = c.get();
                    cAtualiza.setDataultimoregistro(consultor.getDataultimoregistro());
                    consultorService.save(cAtualiza);
                    alterados++;
                }
            }else{
                consultorService.save(consultor);
                inseridos++;
            }
        }

        long tempoFinal = System.currentTimeMillis();

        log.info("Consultores - Tempo de processamento: [" + (tempoFinal - tempoInicial) / 1000d + "]",dateFormat.format(new Date()));
        log.info("Consultores - Registros Alterados: [" + this.alterados + "]",dateFormat.format(new Date()));
        log.info("Consultores - Registros Inseridos: [" + this.inseridos + "]",dateFormat.format(new Date()));
        log.info("<<<<<<<<Fim do processamento - Consultores" ,dateFormat.format(new Date()));
    }
}
