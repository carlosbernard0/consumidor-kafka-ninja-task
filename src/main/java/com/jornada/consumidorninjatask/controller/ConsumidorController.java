package com.jornada.consumidorninjatask.controller;

import com.jornada.consumidorninjatask.dto.TarefaLogDTO;
import com.jornada.consumidorninjatask.service.TarefaLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/consumidor")
@RequiredArgsConstructor
public class ConsumidorController {

    private final TarefaLogService tarefaLogService;

    @GetMapping
    public List<TarefaLogDTO> retornarLog() throws SQLException {
        List<TarefaLogDTO> lista = tarefaLogService.retornarLog();
        return lista;
    }
}
