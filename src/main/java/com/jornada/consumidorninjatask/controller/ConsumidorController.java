package com.jornada.consumidorninjatask.controller;

import com.jornada.consumidorninjatask.dto.TarefaLogDTO;
import com.jornada.consumidorninjatask.service.ConsumidorService;
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

    private final ConsumidorService consumidorService;

    @GetMapping
    public List<TarefaLogDTO> retornarLog() throws SQLException {
        List<TarefaLogDTO> lista = consumidorService.retornarLog();
        return lista;
    }
}
