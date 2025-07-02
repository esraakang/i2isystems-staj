# Kafka Java Producer & Consumer – Local Docker Kafka ile Nesne Yayını

Bu proje, Apache Kafka ile Java kullanarak basit bir **Producer** ve **Consumer** uygulaması geliştirir. Producer tarafında `Student` nesnesi Kafka'ya yayınlanır, Consumer ise bu veriyi okuyup konsola yazdırır. Kafka altyapısı Docker Compose ile local ortamda kurulmuştur.

---

## ✨ Amaçlar

* Kafka Producer ve Consumer mantığını kavramak
* Docker ile Kafka ortamı kurmak
* Java ile Kafka Client API'si kullanmak
* Kodlama, derleme ve çalıştırma adımlarını deneyimlemek

---

## 🔧 Gereksinimler

* Docker yüklü sistem
* Java 21 (OpenJDK) ve `JAVA_HOME` tanımlı
* VS Code ya da benzeri bir Java IDE

---

## 📂 Proje Yapısı

```
kafka-java-example/
├── consumer/
│   └── ConsumerApp.java
├── producer/
│   └── ProducerApp.java
├── Student.java
├── libs/
│   └── kafka-clients-4.0.0.jar
├── docker-compose.yml
├── screenshots/
│   └── consumer-log.jpg
    └── producer-log.jpg
    └── topics-create.jpg
    └── docker-ps.jpg
```

---

## 🚀 1. Kafka Ortamını Kurma (Docker)

```bash
docker-compose -f kafka-docker-project/docker-compose.yml up -d
```

Kafka ortamı başarıyla ayağa kalktıktan sonra topic oluşturulur:

```bash
docker exec -it broker kafka-topics \
  --create --topic student-topic \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1
```

> ✅ Çıktı: `Created topic student-topic.`

---

## 👨‍💼 2. Java Kodları

### Student.java

```java
import java.io.Serializable;

public class Student implements Serializable {
    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
```

### ProducerApp.java

```java
package producer;

import java.util.Properties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerApp {
    public static void main(String[] args) {
        String topic = "student-topic";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        String key = "1";
        String value = "1,Esra";

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        producer.send(record, (meta, ex) -> {
            if (ex == null) {
                System.out.println("Sent: " + value + " to partition: " + meta.partition());
            } else {
                ex.printStackTrace();
            }
        });
        producer.close();
    }
}
```

### ConsumerApp.java

```java
package consumer;

import java.time.Duration;
import java.util.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerApp {
    public static void main(String[] args) {
        String topic = "student-topic";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "student-consumer-group");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        props.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
        System.out.println("Listening to topic: " + topic);

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Received: " + record.value());
            }
        }
    }
}
```

---

## 📚 3. Derleme & Çalıştırma Adımları

### ⬇️ Derleme

```bash
javac -cp ".;kafka-java-example/libs/*" \
  kafka-java-example/Student.java \
  kafka-java-example/producer/ProducerApp.java \
  kafka-java-example/consumer/ConsumerApp.java
```

### ▶️ Producer Çalıştırma

```bash
java -cp ".;kafka-java-example/libs/*;kafka-java-example" producer.ProducerApp
```

> ✅ Çıktı: `Sent: 1,Esra to partition: 0`

### ▶️ Consumer Çalıştırma

```bash
java -cp ".;kafka-java-example/libs/*;kafka-java-example" consumer.ConsumerApp
```

> ✅ Çıktı: `Received: 1,Esra`

---

## 📈 Görsel Çıktılar (Ekran Görüntüleri)

* `docker ps` çıktısı (Kafka servisleri)
![Ekran görüntüsü 2025-07-02 153244](https://github.com/user-attachments/assets/d37ed0f2-240b-4f75-80f9-d530b265dcdd)

* Topic oluşturma çıktısı
![Ekran görüntüsü 2025-07-02 153324](https://github.com/user-attachments/assets/e023c6bf-8d7b-4e02-8d4c-2e68eaeb2257)

* Producer ve Consumer çalışma logları
![Ekran görüntüsü 2025-07-02 153410](https://github.com/user-attachments/assets/247f4f4c-75f4-40ec-9b37-69c1c2c341ea)
![Ekran görüntüsü 2025-07-02 153422](https://github.com/user-attachments/assets/d6e75686-c3b1-4025-901b-0476118fa316)


---

## 📄 Notlar

* SLF4J log uyarıları göz ardı edilebilir.
* Topic oluşmadan Producer çalıştırılmamalı.
* Kodlar sade, Serializable nesne yerine şimdilik String olarak veri iletilmiştir.

---

## 📁 Kaynaklar

* [Apache Kafka Docs](https://kafka.apache.org/)
* [Kafka Java Client API](https://kafka.apache.org/documentation/#producerapi)
* [SLF4J Uyarısı Çözümü](https://www.slf4j.org/codes.html#noProviders)

---

## 👤 Hazırlayan

**Esra Kanğ** – 2025 Yaz Dönemi I2I Systems Stajı
