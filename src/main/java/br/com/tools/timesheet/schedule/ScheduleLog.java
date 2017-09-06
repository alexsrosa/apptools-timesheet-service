package br.com.tools.timesheet.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ScheduleLog {

    private int alterados = 0;
    private int inseridos = 0;
    private long tempoInicial;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Logger log;

    public void startLog(Logger log){
        this.log = log;
        this.tempoInicial = System.currentTimeMillis();
    }

    public void finishLog(){
        log.info("Schedule processado em ["
                + (System.currentTimeMillis() - tempoInicial) / 1000d + "]"
                + " Registros Alterados [" + this.alterados + "]"
                + " Registros Inseridos ["+ this.inseridos + "]", dateFormat.format(new Date()));

        alterados = 0;
        inseridos = 0;
    }

    public void addAlterados(){
        this.alterados++;
    }

    public void addInseridos(){
        this.inseridos++;
    }
}
