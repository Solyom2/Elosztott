package hu.me.iit.kafkaproducer;


public interface KafkaService {

    void sendMessage(MessageDto messageDto);

}
