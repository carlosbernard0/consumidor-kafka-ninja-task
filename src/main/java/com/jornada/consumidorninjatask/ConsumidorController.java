package com.jornada.consumidorninjatask;

import com.jornada.consumidorninjatask.service.ConsumidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumidor")
@RequiredArgsConstructor
public class ConsumidorController {

    private final ConsumidorService consumidorService;

//    @GetMapping
//    public <List>
}
