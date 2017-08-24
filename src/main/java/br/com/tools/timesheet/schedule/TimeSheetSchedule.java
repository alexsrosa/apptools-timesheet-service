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

    private int alterados = 0;
    private int inseridos = 0;

    //@Scheduled(fixedRate = 500000)
    public void atualizaTimeSheet(){

        log.info(">>>>>>>>>>>>Inicio do processamento",dateFormat.format(new Date()));

        long tempoInicial = System.currentTimeMillis();
        this.alterados = 0;
        this.inseridos = 0;

        // Busca parametros
        Parametro dias_atualizacao = this.paramentroService.findByNome("DIAS_ATUALIZACAO_VIEW_TIMESHEET");
        Parametro atualiza_tudo = this.paramentroService.findByNome("ATUALIZA_TUDO_TIMESHEET");

        List<ViewTimeSheet> viewTimeSheet;

        if(atualiza_tudo == null || atualiza_tudo.getValor().equals("TRUE")){
            viewTimeSheet = viewTimeSheetService.findAll();
        }else{

            String dias = "60";
            if (dias_atualizacao != null && dias_atualizacao.getValor() != null){
                dias = dias_atualizacao.getValor();
            }

            LocalDate end = LocalDate.now();
            LocalDate start = end.minusDays(Long.parseLong(dias));

            String dataInicio = start.getYear()+"-"+start.getMonthValue()+"-"+start.getDayOfMonth();
            String dataFim = end.getYear()+"-"+end.getMonthValue()+"-"+end.getDayOfMonth();

            viewTimeSheet = viewTimeSheetService.findByDataByDataAsc(dataInicio, dataFim);
        }

        TimeSheet timeSheet;
        List<TimeSheet> baseTimeSheet;

        for (ViewTimeSheet view : viewTimeSheet) {

            timeSheet = new TimeSheet();
            this.monta(timeSheet, view);

            //verificar se existe na base
            baseTimeSheet = this.timeSheetService.findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndDataAndObservacao(timeSheet);

            if (baseTimeSheet.size() > 0){
                // se existe, verificar se alterou as horas
                baseTimeSheet.forEach(time ->{
                    if(!time.getHoras().equals(view.getHoras())){
                        // Se alterou as horas, atualiza registro
                        log.info(":::::Alterando::::" +time.toString(), dateFormat.format(new Date()));
                        time.setHoras(view.getHoras());
                        time.setDataultimaatualizacao(LocalDate.now());
                        this.timeSheetService.save(time);
                        this.alterados++;
                    }
                });
                // Se não alterou as horas náo fazer nada
            }else{
                // se não existe deve inserir
                log.info(":::::Incluido::::" +timeSheet.toString(), dateFormat.format(new Date()));
                timeSheet.setDatainclusao(LocalDate.now());
                this.timeSheetService.save(timeSheet);
                inseridos++;
            }
        }

        long tempoFinal = System.currentTimeMillis();

        log.info("Tempo de processamento: [" + (tempoFinal - tempoInicial) / 1000d + "]",dateFormat.format(new Date()));
        log.info("Registros Alterados: [" + this.alterados + "]",dateFormat.format(new Date()));
        log.info("Registros Inseridos: [" + this.inseridos + "]",dateFormat.format(new Date()));
        log.info("<<<<<<<<Fim do processamento" ,dateFormat.format(new Date()));
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
        timeSheet.setDataultimaatualizacao(LocalDate.now());
    }
}
