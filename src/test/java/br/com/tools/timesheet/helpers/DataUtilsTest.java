package br.com.tools.timesheet.helpers;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilsTest {

    @Test
    public void convertHorasMinutosSegundosInSegundosTest1(){

        String horasMinutoSegundo = "00:00:59";
        Integer segundos = DataUtils.convertHorasMinutosSegundosInSegundos(horasMinutoSegundo);

        System.out.println(segundos.longValue());
        Assert.assertEquals("Verifica retorno em segundos de 00:00:59", segundos.longValue(), 59);
    }

    @Test
    public void convertHorasMinutosSegundosInSegundosTest2(){

        String horasMinutoSegundo = "00:01:00";
        Integer segundos = DataUtils.convertHorasMinutosSegundosInSegundos(horasMinutoSegundo);

        System.out.println(segundos.longValue());
        Assert.assertEquals("Verifica retorno em segundos de 00:01:00", segundos.longValue(), 60);
    }

    @Test
    public void convertHorasMinutosSegundosInSegundosTest3(){

        String horasMinutoSegundo = "01:00:00";
        Integer segundos = DataUtils.convertHorasMinutosSegundosInSegundos(horasMinutoSegundo);

        System.out.println(segundos.longValue());
        Assert.assertEquals("Verifica retorno em segundos de 01:00:00", segundos.longValue(), 3600);
    }


    @Test
    public void convertHorasMinutosSegundosInSegundosTest4(){

        String horasMinutoSegundo = "05:15:25";
        Integer segundos = DataUtils.convertHorasMinutosSegundosInSegundos(horasMinutoSegundo);

        System.out.println(segundos.longValue());
        Assert.assertEquals("Verifica retorno em segundos de 01:00:00", segundos.longValue(), 18925);
    }

    @Test
    public void convertSegundosInHorasMinutosSegundosTest1(){

        Integer segundos = 60;
        String horasMinutosSegundos = DataUtils.convertSegundosInHorasMinutosSegundos(segundos);

        System.out.println(horasMinutosSegundos);
        Assert.assertEquals("Verifica retorna 00:01:00", horasMinutosSegundos, "00:01:00");
    }

    @Test
    public void convertSegundosInHorasMinutosSegundosTest2(){

        Integer segundos = 3600;
        String horasMinutosSegundos = DataUtils.convertSegundosInHorasMinutosSegundos(segundos);

        System.out.println(horasMinutosSegundos);
        Assert.assertEquals("Verifica retorna 01:00:00", horasMinutosSegundos, "01:00:00");
    }

    @Test
    public void convertSegundosInHorasMinutosSegundosTest3(){

        Integer segundos = 16200;
        String horasMinutosSegundos = DataUtils.convertSegundosInHorasMinutosSegundos(segundos);

        System.out.println(horasMinutosSegundos);
        Assert.assertEquals("Verifica retorna 01:00:00", horasMinutosSegundos, "04:30:00");
    }

    @Test
    public void convertSegundosInHorasMinutosSegundosTest4(){

        Integer segundos = 29430;
        String horasMinutosSegundos = DataUtils.convertSegundosInHorasMinutosSegundos(segundos);

        System.out.println(horasMinutosSegundos);
        Assert.assertEquals("Verifica retorna 01:00:00", horasMinutosSegundos, "08:10:30");
    }
}
