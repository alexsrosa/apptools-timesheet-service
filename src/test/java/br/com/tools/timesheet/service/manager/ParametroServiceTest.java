package br.com.tools.timesheet.service.manager;

import br.com.tools.timesheet.domain.manager.Parametro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParametroServiceTest {

    @Autowired
    private ParametroService service;

    @Test
    public void findByName(){

        Parametro parametro = this.service.findByNome("DIAS_ATUALIZACAO_VIEW_TIMESHEET");

        parametro.getValor().isEmpty();

        System.out.println(parametro.toString());

        assertEquals(true, (!parametro.getValor().isEmpty()));

    }
    @Test
    public void findAll(){
        Iterable<Parametro> parametros = this.service.findAll();

        parametros.forEach(parametro -> System.out.println(parametro.toString()));

        assertEquals(true, true);
    }

}
