package kz.dar.tech.commentservice.service;

import kz.dar.tech.commentservice.document.Comment;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(
            String comment,
            String key
    ) {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("comment-topic",
                                                                                    key,
                                                                                    comment);
        kafkaTemplate.send(producerRecord);
        System.out.println("Sent comment: " + comment + " with key: " + key);
    }
}
