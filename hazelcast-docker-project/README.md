# Hazelcast on Docker (Local Kurulum)

Bu proje, Hazelcast dağıtık veri yapısını ve Hazelcast Management Center'ı Docker üzerinde çalıştırmayı amaçlamaktadır. Amaç, yerel ortamda bir Hazelcast kümesi (cluster) oluşturmak ve bunu yönetim paneli üzerinden izlemektir.

---

## ✨ Proje Hedefleri

* Hazelcast container kurulumu
* Management Center ile görsel izleme
* Docker ağı içinde bağlantı kurma
* Hataları analiz etme ve çözümleme
* Görseller ile belgelenmiş kurulum adımları

---

## 🚀 Gereksinimler

* Docker yüklü bir işletim sistemi
* Komut satırı (PowerShell / Terminal)
* Modern bir tarayıcı (Chrome, Edge, vs.)

---

## 📁 Proje Yapısı

```
hazelcast-docker-project/
├── README.md
└── screenshots/
    ├── hazelcast-pull.png
    ├── hazelcast-node-ps.png
    └── mc-connect-success.png
```

---

## 🧱 1. Hazelcast Kurulumu

### 🔹 Hazelcast İmajını İndirme

```bash
docker pull hazelcast/hazelcast:latest
```

> 📸 ![Ekran görüntüsü 2025-07-02 131338](https://github.com/user-attachments/assets/336430c5-3e91-4f8a-a6a5-ed34eb22c71a)


### 🔹 Hazelcast Node Başlatma

```bash
docker run --name hazelcast-node -d hazelcast/hazelcast:latest
```

> 📸 ![Ekran görüntüsü 2025-07-02 125850](https://github.com/user-attachments/assets/5b48a7a2-8525-4243-ab74-29f66890d883)


---

## 🧭 2. Hazelcast Management Center Kurulumu

### 🔹 Yönetim Panelini Başlatma

```bash
docker run --rm -p 8080:8080 hazelcast/management-center:latest
```

Tarayıcıdan `http://localhost:8080` adresine giderek arayüzü açın.

---

## 🔌 3. Web UI Üzerinden Cluster Bağlantısı

### 🔹 Bağlantı Ekranı Bilgileri:

* **Cluster Name**: `dev`
* **Member Addresses**: `hazelcast-node:5701`

> ⚠️ `localhost` veya `127.0.0.1` kullanmak yerine `hazelcast-node` yazılmalıdır. Docker konteynerleri birbirine kendi adlarıyla bağlanır.

> 📸 ![Ekran görüntüsü 2025-07-02 131518](https://github.com/user-attachments/assets/f29a9d67-a3c1-412c-9ffe-76384e1b0b34)
 — Başarılı bağlantı sonrası ekran

---

## ✅ Sonuç

* Hazelcast container'ı başarıyla çalıştı
* Web arayüzüyle izleme ve yapılandırma sağlandı
* Docker'da hostname kullanımı pratikte test edildi

---

> 📌 Bu proje, Docker ortamında Hazelcast ve yönetim araçlarını çalıştırmak ve izlemek için temel bir deneyim sunmaktadır. Gerçek uygulamalar için yapılandırmalar genişletilebilir.

---

## 👤 Katkı

**Esra Kanğ** – 2025 Yaz Dönemi I2I Systems Stajı kapsamında hazırlanmıştır.

---

## 📚 Kaynaklar

* [Hazelcast Docker Hub](https://hub.docker.com/r/hazelcast/hazelcast)
* [Hazelcast Management Center Docker](https://hub.docker.com/r/hazelcast/management-center)
* [Hazelcast Documentation](https://docs.hazelcast.com/)
