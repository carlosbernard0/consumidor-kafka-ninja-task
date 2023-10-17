package com.jornada.consumidorninjatask.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TarefaLogReceberDTO {
    private OperacaoTarefa operacaoTarefa;
    private TarefaDTO tarefaDTO;
    private Date horario;
}
