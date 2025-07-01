# Kafka on Docker (Local & Cloud Setup)

Bu proje, Apache Kafka'yı hem **lokal ortamda** hem de **AWS EC2 üzerinde bulut ortamında** Docker konteynerleri ile çalıştırmayı amaçlamaktadır.

---

## ✨ Proje Hedefleri

* Kafka + Zookeeper Docker Compose kurulumu (lokal)
* AWS EC2 üzerinde Docker + Kafka kurulumu
* Hatalarla mücadele (log takibi, port yönlendirme, config eksikleri)
* Git ve GitHub ile versiyon takibi
* Görseller ile belgelenmiş kurulum adımları

---

## 🚀 Gereksinimler

* Docker & Docker Compose
* Git
* AWS hesabı + EC2 Instance (Amazon Linux 2023 AMI)
* SSH üzerinden EC2zerinden EC2\u201ye erişim (.pem anahtar dosyası)
* Visual Studio Code (tercihen)

---

## 📁 Proje Dosya Yapısı

```
kafka-docker-project/
├── docker-compose.yml
├── README.md
└── screenshots/
```

---

## 🖥️ 1. Lokal Kafka Kurulumu

### 📂 docker-compose.yml

```yaml
version: '2'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_PROCESS_ROLES: broker
      CLUSTER_ID: "my-cluster-id"
```

### 🔄 Çalıştırma

```bash
docker-compose up -d
```

### 🔍 Log Kontrol

```bash
docker logs yeniklasr-kafka-1
```

**📷 Ekran Görüntüsü: docker ps sonucu (local)**

![docker-ps-local](https://github.com/user-attachments/assets/8b193a3b-8de4-4238-8ac9-b9addc97ac57)


---

## ☁️ 2. AWS EC2 Üzerinde Kafka Kurulumu

### 🔐 SSH ile EC2'ye Bağlanma

```bash
ssh -i "staj-key.pem" ec2-user@<EC2-PUBLIC-IP>
```

**📷 Ekran Görüntüsü: EC2 terminal girişi**

![ec2-terminal-login](https://github.com/user-attachments/assets/7fdb5d7c-0d81-44c5-80bb-465a2192344c)


### 🚚 Docker Versiyon Kontrol

```bash
docker version
```

Eğer docker yoksa:

```bash
sudo yum install docker -y
sudo systemctl start docker
sudo systemctl enable docker
```

**📷 Ekran Görüntüsü: docker version (EC2)**

![docker-version-ec2](https://github.com/user-attachments/assets/d52af062-ac89-4166-a203-37133e7c94d8)

### 🔧 docker-compose.yml Oluşturma

```bash
mkdir kafka-on-cloud
cd kafka-on-cloud
nano docker-compose.yml
```

> İçeriği local ile aynıdır.

### 🚀 Compose Çalıştırma

```bash
docker-compose up -d
```

### 🔍 Log Kontrol

```bash
docker logs kafka-on-cloud-kafka-1
```

**📷 Ekran Görüntüsü: docker ps sonucu (EC2)**

![docker-ps-cloud](https://github.com/user-attachments/assets/0bb24445-2078-48d7-89fc-0a3cabe964b6)


---

## 🚫 Karşılaşılan Hatalar ve Çözümler

### ❌ `CLUSTER_ID is required`

> `CLUSTER_ID` environment variable eksikti. docker-compose dosyasına eklendi.

### ❌ `KAFKA_PROCESS_ROLES is required`

> `KAFKA_PROCESS_ROLES: broker` satırı eklendi.

### ❌ `controller.quorum.voters` hatası

> Yeni Kafka sürümlerinde quorum değeri zorunludur; KRaft moddan çıkmak için `KAFKA_PROCESS_ROLES: broker` yeterlidir.

---

## 📃 Git Versiyon Kontrolü

```bash
git init
git add .
git commit -m "Kafka on Docker"
git push origin main
```

Merge durumlarında:

```bash
git pull origin main --no-rebase

```

**📷 Ekran Görüntüsü: Git Merge Commit ekranı**

> `screenshots/git-merge-editor.png`

---

## 📂 Dosya ve Klasörler

```
kafka-docker-project/
├── docker-compose.yml
├── README.md
└── screenshots/
    ├── docker-ps-local.png
    ├── ec2-terminal-login.png
    ├── docker-version-ec2.png
    └── docker-ps-cloud.png
```

---

## 📅 Katkıda Bulunanlar

* **Esra Kanğ** – Proje Sahibi

---

## 📚 Kaynaklar

* [Confluent Docker Kafka](https://hub.docker.com/r/confluentinc/cp-kafka/)
* [Confluent Quick Start](https://docs.confluent.io/platform/current/quickstart/index.html)
* [Kafka Documentation](https://kafka.apache.org/documentation/)
