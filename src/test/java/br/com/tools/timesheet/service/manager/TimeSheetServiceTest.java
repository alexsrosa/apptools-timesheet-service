package br.com.tools.timesheet.service.manager;


import br.com.tools.timesheet.domain.manager.TimeSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetServiceTest {

    @Autowired
    private TimeSheetService service;

    @Test
    public void findByData(){

        LocalDate data = LocalDate.of(2017,5,1);


        List<TimeSheet> timeSheets =  service.findByData(data);

        int count = 0;

        for (TimeSheet timeSheet: timeSheets) {
            count++;
        }

        System.out.println(count);

        assertEquals(true, (count >= 0));
    }


    @Test
    public void findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndData(){
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setMatricula(445);
        timeSheet.setTarefa(995894);
        timeSheet.setCodigofase(2);
        timeSheet.setCodigoatividade(8);
        timeSheet.setData(LocalDate.of(2017,06,01));


        List<TimeSheet> timeSheets = service.findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndData(timeSheet);

        int count = 0;
        String name = "";
        for (TimeSheet ts: timeSheets) {

            name = ts.getNome();
            System.out.println(ts.toString());
            count++;
        }
        System.out.println(count);

        assertEquals(true, (count >= 0 && name == "Alex Silveira da Rosa"));


        /*TimeSheet timeSheets = service.findByMatriculaAndTarefaAndCodigofaseAndCodigoatividadeAndData(timeSheet);

        if(timeSheets == null){
            assertEquals(true, false);
        }else{
            System.out.println(timeSheets.getNome());
            assertEquals(true, true);
        }*/

    }

    @Test
    public void deleteById(){

        service.deleteById(Long.parseLong("4"));

        Optional<TimeSheet> t = service.findById(Long.parseLong("4"));

        assertEquals(false, t.isPresent());
    }

    @Test
    public void findById(){

        Optional<TimeSheet> t = service.findById(Long.parseLong("4"));

        assertEquals(true, t.isPresent());
    }
}
