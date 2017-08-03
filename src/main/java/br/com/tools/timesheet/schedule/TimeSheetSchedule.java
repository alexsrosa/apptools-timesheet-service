package br.com.tools.timesheet.schedule;

import br.com.tools.timesheet.domain.manager.Parametro;
import br.com.tools.timesheet.domain.manager.TimeSheet;
import br.com.tools.timesheet.domain.sat.ViewTimeSheet;
import br.com.tools.timesheet.service.manager.ParametroService;
import br.com.tools.timesheet.service.manager.TimeSheetService;
import br.com.tools.timesheet.service.sat.ViewTimeSheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.*;

@Component
public class TimeSheetSchedule {

    private static final Logger log = LoggerFactory.getLogger(TimeSheetSchedule.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ViewTimeSheetService viewTimeSheetService;

    @Autowired
    private TimeSheetService timeSheetService;

    @Autowired
    private ParametroService paramentroService;

    @Scheduled(fixedRate = 500000)
    public void atualizaTimeSheet(){

        log.info(">>>>>>>>>>>>Inicio do processamento",dateFormat.format(new Date()));

        // Busca parametros
        Parametro dias_atualizacao = this.paramentroService.findByNome("DIAS_ATUALIZACAO_VIEW_TIMESHEET");
        Parametro atualiza_tudo = this.paramentroService.findByNome("ATUALIZA_TUDO_TIMESHEET");

        Iterable<ViewTimeSheet> timeSheetsList;

        if(atualiza_tudo.getValor().equals("TRUE")){
            timeSheetsList = viewTimeSheetService.findAll();
        }else{
            LocalDate end = LocalDate.now();
            LocalDate start = end.minusDays(Long.parseLong(dias_atualizacao.getValor()));

            String dataInicio = start.getYear()+"-"+start.getMonthValue()+"-"+start.getDayOfMonth();
            String dataFim = end.getYear()+"-"+end.getMonthValue()+"-"+end.getDayOfMonth();

            timeSheetsList = viewTimeSheetService.findByData(dataInicio, dataFim);
        }

        TimeSheet timeSheet;
 /*       List<TimeSheet> returnTimeSheet;

        for (ViewTimeSheet viewTimeSheet : timeSheetsList) {

            timeSheet = new TimeSheet();
            this.monta(timeSheet, viewTimeSheet);

            //verificar se existe na base
            returnTimeSheet = this.timeSheetService.findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndData(timeSheet);

            if (returnTimeSheet.size() >= 1){
                // se existe, verificar se alterou as horas
                if(returnTimeSheet.get(1).getHoras().equals(timeSheet.getHoras())){
                    // Se alterou as horas marcar para atualizar
                }
                // Se não alterou as horas náo fazer nada
            }else{
                // se não existe deve inserir
            }

           *//* if(returnTimeSheet.size() >= 1){
                returnTimeSheet.forEach(time -> {
                    this.remove(time);
                });
            }*//*
        }*/

        for (ViewTimeSheet viewTimeSheet : timeSheetsList) {

            timeSheet = new TimeSheet();

            this.monta(timeSheet, viewTimeSheet);

            this.add(timeSheet);
        }

        log.info("<<<<<<<<Fim do processamento",dateFormat.format(new Date()));
    }

    private void monta(TimeSheet timeSheet, ViewTimeSheet viewTimeSheet) {
        timeSheet.setMatricula(Integer.parseInt(viewTimeSheet.getMatricula().trim()));
        timeSheet.setNome(viewTimeSheet.getNome().trim());
        timeSheet.setTarefa(Integer.parseInt(viewTimeSheet.getTarefa().trim()));
        timeSheet.setDescricao(viewTimeSheet.getDescricao().trim());
        timeSheet.setCodigofase(Integer.parseInt(viewTimeSheet.getCodFase().trim()));
        timeSheet.setDescricaofase(viewTimeSheet.getDesFase().trim());
        timeSheet.setCodigoatividade(Integer.parseInt(viewTimeSheet.getCodAtividade().trim()));
        timeSheet.setDescricaoatividade(viewTimeSheet.getDesAtividade().trim());
        timeSheet.setData(viewTimeSheet.getData());
        timeSheet.setObservacao(viewTimeSheet.getObservacao().trim());
        timeSheet.setHoras(viewTimeSheet.getHoras().trim());
    }

    private void remove(TimeSheet timeSheet){
        log.info(":::::Removido::::" + timeSheet.toString(),dateFormat.format(new Date()));
        timeSheetService.deleteById(timeSheet.getId());
    }

    private void add(TimeSheet timeSheet){
        log.info(":::::Incluido::::" +timeSheet.toString(), dateFormat.format(new Date()));
        timeSheetService.save(timeSheet);
    }
}
