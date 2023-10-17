package com.jornada.consumidorninjatask.entity;

import com.jornada.consumidorninjatask.dto.OperacaoTarefa;
import com.jornada.consumidorninjatask.dto.TarefaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TarefaLogEntity {
    private OperacaoTarefa operacaoTarefa;
    private String tarefaDTO;
    private Date horario;
}
