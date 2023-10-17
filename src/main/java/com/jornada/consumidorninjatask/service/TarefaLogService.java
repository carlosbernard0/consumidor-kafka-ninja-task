package com.jornada.consumidorninjatask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidorninjatask.dto.TarefaLogDTO;
import com.jornada.consumidorninjatask.dto.TarefaLogReceberDTO;
import com.jornada.consumidorninjatask.entity.TarefaLogEntity;
import com.jornada.consumidorninjatask.mapper.TarefaLogMapper;
import com.jornada.consumidorninjatask.repository.ConsumidorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TarefaLogService {
    private final TarefaLogMapper tarefaLogMapper;
    private final ConsumidorRepository consumidorRepository;

    public void enviarMensagemMongo(TarefaLogReceberDTO dto) throws JsonProcessingException {
        TarefaLogDTO tarefaLogDTO = new TarefaLogDTO();
        TarefaLogEntity tarefaLogEntity = new TarefaLogEntity();
        String tarefadto = new ObjectMapper().writeValueAsString(dto.getTarefaDTO());

        tarefaLogDTO.setOperacaoTarefa(dto.getOperacaoTarefa());
        tarefaLogDTO.setHorario(dto.getHorario());
        tarefaLogDTO.setTarefaDTO(tarefadto);

        tarefaLogEntity = tarefaLogMapper.toEntity(tarefaLogDTO);
        consumidorRepository.save(tarefaLogEntity);
        log.info("Mensagem Enviada ao banco com sucesso");
    }

    public List<TarefaLogDTO> retornarLog()throws SQLException {
        List<TarefaLogEntity> log = consumidorRepository.findAll();
        List<TarefaLogDTO> logDTO = log.stream().map(entity -> tarefaLogMapper.toDto(entity)).toList();
        return logDTO;
    }
}
