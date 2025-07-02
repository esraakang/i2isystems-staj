package producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerApp {
    public static void main(String[] args) {
        String topic = "student-topic";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // Kafka broker adresi
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        String key = "1";
        String value = "1,Esra"; // Şimdilik düz string gönderiyoruz

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Sent: " + value + " to partition: " + metadata.partition());
            } else {
                exception.printStackTrace();
            }
        });

        producer.close();
    }
}
