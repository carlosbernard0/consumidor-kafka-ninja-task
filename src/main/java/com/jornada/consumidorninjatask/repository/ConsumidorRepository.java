package com.jornada.consumidorninjatask.repository;

import com.jornada.consumidorninjatask.entity.TarefaLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsumidorRepository extends MongoRepository<TarefaLogEntity, String> {
}
