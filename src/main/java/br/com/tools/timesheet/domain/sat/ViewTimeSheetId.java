package br.com.tools.timesheet.domain.sat;

import java.io.Serializable;
import java.time.LocalDate;

public class ViewTimeSheetId implements Serializable {

    String matricula;
    String tarefa;
    String codFase;
    String codAtividade;
    LocalDate data;
    String observacao;
}
