# ⚡ VoltDB - Docker ile AWS EC2 Üzerinde Kurulum (Staj Ödevi)

Bu proje, VoltDB Community Edition'ın **AWS EC2 bulut sunucusunda Docker ile kurulup başlatılmasını** adım adım ve kanıtlı şekilde gösterir. Terminal çıktıları, açıklamalar ve ekran görüntüsü bölümü içerir.

---

🎯 **Proje Hedefleri**

* VoltDB’yi bulut ortamında Docker ile ayağa kaldırmak
* Port açma, canlı erişim ve terminal kanıtlarıyla raporlamak

---

⚙️ **Gereksinimler**

* AWS EC2 sunucusu (Amazon Linux önerilir)
* SSH erişimi (.pem anahtar dosyası)
* Docker kurulumu
* Açık portlar: 8080 (Web UI), 21212 (Client)

---

🗂️ **Kurulum Adımları ve Terminal Komutları**

```bash
# 1. AWS EC2'ya SSH ile bağlan
ssh -i "C:/Users/Esra/Downloads/staj-key.pem" ec2-user@13.61.8.225

# 2. Docker kurulu mu kontrol et
docker --version

# (Gerekirse) Docker kurulumu (Amazon Linux için)
sudo yum update -y
sudo amazon-linux-extras install docker -y
sudo systemctl start docker
sudo systemctl enable docker
sudo usermod -aG docker ec2-user
# Kullanıcıyı gruba eklediyseniz, çıkıp tekrar bağlanın

# 3. VoltDB için Docker ağı oluştur (opsiyonel)
docker network create voltLocalCluster

# 4. VoltDB Docker imajını çek
docker pull full360/docker-voltdb-ce

# 5. VoltDB container'ı başlat
docker run -d --name volt --network=voltLocalCluster -p 21212:21212 -p 8080:8080 full360/docker-voltdb-ce

# 6. Çalışıyor mu kontrol et
docker ps
docker logs volt
```

> **Sık hata ve çözümler:**
>
> * `network not found`:  `docker network create voltLocalCluster`
> * `container name ... is already in use`:  `docker rm volt`

---

🔐 **AWS Security Group Ayarları**

* EC2 instance > Security Group > Inbound Rules:

  * TCP 8080  (Web UI)
  * TCP 21212 (VoltDB Client, istenirse)

---


🧪 **Canlı Terminal Çıktısı Örneği**

```text
Initializing VoltDB...

 _    __      ____  ____  ____
| |  / /___  / / /_/ __ \/ __ )
| | / / __ \/ / __/ / / / __  |
| |/ / /_/ / / /_/ /_/ / /_/ /
|___/\____/_/\__/_____/_____/

--------------------------------

Build: 6.4 This is not from a known repository Community Edition
Connecting to VoltDB cluster as the leader...
Host id of this node is: 0
Initializing the database. This may take a moment...
Server Operational State is: NORMAL
Server completed initialization.

---

🖼️ **Ekran Görüntüleri**

* VoltDB terminal log çıktısı
* AWS EC2 instance ayrıntıları

Tüm görseller `/screenshots` klasörüne eklenebilir.

---

🛠️ **Ekstra Komutlar**

* Container’ı durdur: `docker stop volt`
* Container’ı sil: `docker rm volt`
* İçine bağlan: `docker exec -it volt bash`
* SQL prompt: `sqlcmd`

---

👩‍💻 **Geliştirici & Notlar**
Bu kurulum Esra tarafından staj ödevi kapsamında gerçekleştirilmiştir.

Gelecekte yapılabilecekler:

* Çok düğümlü (multi-node) cluster kurulumları
* VoltDB’ye uzaktan SQL işlemleri

---
