package com.jornada.consumidorninjatask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidorninjatask.dto.MensagemDTO;
import com.jornada.consumidorninjatask.dto.TarefaLogDTO;
import com.jornada.consumidorninjatask.entity.TarefaLogEntity;
import com.jornada.consumidorninjatask.mapper.TarefaLogMapper;
import com.jornada.consumidorninjatask.repository.ConsumidorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {
    private final TarefaLogMapper tarefaLogMapper;
    private final ConsumidorRepository consumidorRepository;

    @KafkaListener(groupId = "${kafka.group.id}",
    topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions ={"0"})},
    containerFactory = "listenerContainerFactory",
    clientIdPrefix = "log-topic")
    public void consumir(
            @Payload String mensagem,
            @Header(KafkaHeaders.RECEIVED_KEY) String chave,
            @Header(KafkaHeaders.OFFSET) Long offset
    ) throws JsonProcessingException {
        //string em obj...
        TarefaLogDTO dto = new ObjectMapper().readValue(mensagem, TarefaLogDTO.class);
        log.info("Mensagem Recebida com Sucesso: {} \n chave: {} \n offset: {}", dto, chave, offset);

        //Salvar no banco
        enviarMensagemMongo(dto);
    }
    public void enviarMensagemMongo(TarefaLogDTO dto){
        TarefaLogEntity tarefaLogEntity = new TarefaLogEntity();
        tarefaLogEntity = tarefaLogMapper.toEntity(dto);
        consumidorRepository.save(tarefaLogEntity);
        log.info("Mensagem Enviada ao banco com sucesso");
    }

    public List<TarefaLogDTO> retornarLog()throws SQLException {
        List<TarefaLogEntity> log = consumidorRepository.findAll();
        List<TarefaLogDTO> logDTO = log.stream()
                .map(entity -> tarefaLogMapper.toDto((TarefaLogEntity) entity))
                .toList();
        return logDTO;
    }

}
