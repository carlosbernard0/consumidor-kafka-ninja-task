package com.jornada.consumidorninjatask.mapper;

import com.jornada.consumidorninjatask.dto.TarefaLogDTO;
import com.jornada.consumidorninjatask.entity.TarefaLogEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T15:06:51-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class TarefaLogMapperImpl implements TarefaLogMapper {

    @Override
    public TarefaLogEntity toEntity(TarefaLogDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TarefaLogEntity tarefaLogEntity = new TarefaLogEntity();

        tarefaLogEntity.setOperacaoTarefa( dto.getOperacaoTarefa() );
        tarefaLogEntity.setTarefaDTO( dto.getTarefaDTO() );
        tarefaLogEntity.setHorario( dto.getHorario() );

        return tarefaLogEntity;
    }

    @Override
    public TarefaLogDTO toDto(TarefaLogEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TarefaLogDTO tarefaLogDTO = new TarefaLogDTO();

        tarefaLogDTO.setOperacaoTarefa( entity.getOperacaoTarefa() );
        tarefaLogDTO.setTarefaDTO( entity.getTarefaDTO() );
        tarefaLogDTO.setHorario( entity.getHorario() );

        return tarefaLogDTO;
    }
}
