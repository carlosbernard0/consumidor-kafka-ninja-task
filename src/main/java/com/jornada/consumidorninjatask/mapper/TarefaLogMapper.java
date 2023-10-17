package com.jornada.consumidorninjatask.mapper;

import com.jornada.consumidorninjatask.dto.TarefaLogDTO;
import com.jornada.consumidorninjatask.entity.TarefaLogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaLogMapper {
    TarefaLogEntity toEntity(TarefaLogDTO dto);

    TarefaLogDTO toDto(TarefaLogEntity entity);
}
