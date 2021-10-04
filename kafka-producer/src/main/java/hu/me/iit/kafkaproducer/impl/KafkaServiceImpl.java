package hu.me.iit.kafkaproducer.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.me.iit.kafkaproducer.KafkaService;
import hu.me.iit.kafkaproducer.MessageDto;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<Long, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String topicName = "chat-rooms";

    public KafkaServiceImpl(KafkaTemplate<Long, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        String message = "";
        try {
            message = objectMapper.writeValueAsString(messageDto);
        } catch (Exception e) {}
        Long key = 0L;

        ProducerRecord<Long, String> producerRecord = buildProducerRecord(key, message, topicName);
        ListenableFuture<SendResult<Long, String>> resultListenableFuture = kafkaTemplate.send(producerRecord);

        resultListenableFuture.addCallback(new ListenableFutureCallback<SendResult<Long, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Failure message " + ex.toString());
            }

            @Override
            public void onSuccess(SendResult<Long, String> result) {
                System.out.println("Success message " + result.toString());
            }
        });
    }

    private ProducerRecord<Long, String> buildProducerRecord(Long key, String value, String kafkaTopic) {
        return new ProducerRecord<Long, String>(kafkaTopic, null, key, value, null);
    }

}
