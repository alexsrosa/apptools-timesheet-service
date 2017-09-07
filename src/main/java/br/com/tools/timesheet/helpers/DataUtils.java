package br.com.tools.timesheet.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final Logger log = LoggerFactory.getLogger(DataUtils.class);

    /**
     * Metodo que converte do formato 00:00:00 para segundos
     * @param HorasMinutosSegundos
     * @return
     */
    public static Integer convertHorasMinutosSegundosInSegundos(String HorasMinutosSegundos) {

        String[] tempo = HorasMinutosSegundos.split(":");

        float segundos = 0;

        try{
            segundos = (Float.parseFloat(tempo[0]) * 3600) +
                        (Float.parseFloat(tempo[1]) * 60) + Float.parseFloat(tempo[2]);

        }catch (Exception e){
            log.error(e.getMessage(), dateFormat.format(new Date()));
        }

        return Math.round(segundos);
    }

    /**
     * Metodo que efetua a conversao de segundos para o formato de 00:00:00
     * @param segundos
     * @return
     */
    public static String convertSegundosInHorasMinutosSegundos(Integer segundos) {

        String horasMinutosSegundos = "00:00:00";

        try{
            int segundo = segundos % 60;
            int minutos = segundos / 60;
            int minuto = minutos % 60;
            int hora = minutos / 60;
            horasMinutosSegundos = String.format ("%02d:%02d:%02d", hora, minuto, segundo);

        } catch (Exception e){
            log.error(e.getMessage(), dateFormat.format(new Date()));
        }

        return horasMinutosSegundos;
    }
}
