package com.jornada.consumidorninjatask.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TarefaLogDTO {
    private OperacaoTarefa operacaoTarefa;
    private String tarefaDTO;
    private Date horario;
}
