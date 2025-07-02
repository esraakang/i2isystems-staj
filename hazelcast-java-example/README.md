# HAZELCAST-EX-03: Person Nesnesi ile Hazelcast Map Kullanımı

Bu proje, Hazelcast istemcisi kullanarak 10.000 adet `Person` nesnesinin Hazelcast sunucusuna yazılması ve bu verilerin okunmasını içeren bir çalışmadır.
Bu sayede Hazelcast dağıtık cache yapısının Java ile nasıl kullanılabileceği gösterilmiştir.

---

## 🔧 Kullanılan Teknolojiler

* Java (VS Code veya terminal ile)
* Hazelcast 5.3.6
* Hazelcast Client API
* Kryo veya Java Serializable (bu projede Java Serializable kullanıldı)

---

## 📁 Proje Yapısı

```
.
i2isystems-staj/
├── hazelcast-java-example/
│   ├── HazelcastClientApp.java
│   └── Person.java
└── libs/
    └── hazelcast-5.3.6.jar
```

---

## 👤 Person.java

```java
import java.io.Serializable;

public class Person implements Serializable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person{name='" + name + "'}";
    }
}
```

---

## 🧑‍💻 HazelcastClientApp.java

```java
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastClientApp {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Integer, Person> peopleMap = client.getMap("people");

        // 10.000 adet Person nesnesi ekle
        for (int i = 1; i <= 10000; i++) {
            peopleMap.put(i, new Person("Person-" + i));
        }

        // Sadece ilk 5 ve son 5 nesneyi yazdır
        for (int i = 1; i <= 5; i++) {
            System.out.println(peopleMap.get(i));
        }
        for (int i = 9996; i <= 10000; i++) {
            System.out.println(peopleMap.get(i));
        }

        client.shutdown();
    }
}
```

---

## ▶️ Çalıştırma Aşamaları

### 1. Hazelcast Sunucusunu Başlat

```bash
java -cp "hazelcast-java-example/libs/hazelcast-5.3.6.jar" com.hazelcast.core.server.HazelcastMemberStarter
```

> 📸 *Ekran görüntüsü: Hazelcast sunucusu başarıyla başlatıldı.*

### 2. Kodları Derle

```bash
javac -cp ".;hazelcast-java-example/libs/*" hazelcast-java-example/*.java
```

### 3. Client Uygulamasını Çalıştır

```bash
java -cp ".;hazelcast-java-example/libs/*;hazelcast-java-example" HazelcastClientApp
```

> 📸 *Ekran görüntüsü: Person nesneleri console'a yazıldı (ilk ve son 5).*

---

## 📊 Test ve Gözlem

* Sunucu başarıyla çalıştırıldı ✅
* Hazelcast istemcisi sunucuya bağlandı ✅
* 10.000 `Person` nesnesi `IMap` nesnesine yazıldı ✅
* Konsola yalnızca ilk 5 ve son 5 `Person` yazdırıldı ✅
* Sunucu ve istemci düzenli şekilde kapatıldı ✅

---

## 📸 Ekran Görüntüleri

| Açıklama                        | Görsel Adı              |
| ------------------------------- | ----------------------- |
| Hazelcast sunucusu başlatıldı   | `hazelcast_server.png`  |
| Derleme ve çalıştırma terminali | `terminal_output.png`   |
| Person çıktıları (ilk ve son 5) | `map_read_result.png`   |
| Proje klasör yapısı             | `project_structure.png` |

---

## 🔹 Ek Bilgi

* `Person` sınıfı `Serializable` olarak tanımlandı. Kryo veya diğer serileştiriciler bu örnekte kullanılmadı.
* Hazelcast sunucusu 5701 portu üzerinden bağlandı.
* Client uygulamasındaki veri yükleme ve okuma işlemleri basit döngülerle yapıldı.

---

## 📑 Hazırlayan

Esra – 2025 Yaz Stajı, i2i Systems

```
```
