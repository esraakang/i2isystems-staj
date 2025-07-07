# VoltDB on Docker (Cloud & DBeaver Setup)

Bu proje, VoltDB’yi AWS EC2 bulut ortamında Docker ile ayağa kaldırmayı ve DBeaver arayüzüyle tablo işlemleri yapmayı amaçlar.

---

✨ **Proje Hedefleri**

* AWS EC2 üzerinde Docker ile VoltDB kurulum & çalıştırma
* DBeaver ile uzaktan bağlantı ve SQL işlemleri (tablo, veri ekleme, sorgu)
* Hatalarla mücadele (container, port, driver, RAM sorunları)
* Ekran görüntüleriyle tam dökümantasyon

---

🚀 **Gereksinimler**

* AWS hesabı + EC2 Instance (Amazon Linux 2023, 1GB+ RAM)
* Docker (ve docker-compose, opsiyonel)
* Dış dünyaya açık 21212 portu (Security Group)
* DBeaver (v25+)
* SSH erişimi (.pem dosyası)

---

📁 **Proje Dosya Yapısı**

```
volt-db-cloud-demo/
├── docker-run-command.txt
├── README.md
└── screenshots/
    ├── ec2-terminal-login.png
    ├── docker-ps-up.png
    ├── dbeaver-connection.png
    ├── dbeaver-tables.png
    └── dbeaver-query-result.png
```

---

🖥️ **1. AWS EC2 ve Docker’da VoltDB Kurulumu**

```bash
ssh -i "staj-key.pem" ec2-user@<EC2_PUBLIC_IP>
docker rm volt
docker network create voltLocalCluster
docker run -d --name volt --network=voltLocalCluster -p 21212:21212 -p 8080:8080 -p 55004:55004 full360/docker-voltdb-ce
```

📷 *Ekran görüntüsü: EC2 terminal ve docker ps çıktısı*

---

🔗 **2. DBeaver ile VoltDB Bağlantısı**

* **JDBC URL:**
  `jdbc:voltdb://<EC2_PUBLIC_IP>:21212`
* **Driver JAR:** Uyumlu `voltdb-jdbc-*.jar`
* **Class Name:** `org.voltdb.jdbc.Driver`

📷 *Ekran görüntüsü: DBeaver bağlantı ayarları ve test sonucu*

---

🗄️ **3. Tablo Oluşturma ve Veri Ekleme (DBeaver SQL Editörü)**

```sql
create table mth3902 (
  id bigint not null,
  start_date_epoch bigint,
  create_user varchar(32),
  constraint mth3902_pk primary key(id)
);
partition table mth3902 on column id;

insert into mth3902 ( id, start_date_epoch, create_user ) values ( 1, 1698295044, 'MENNAN');
insert into mth3902 ( id, start_date_epoch, create_user ) values ( 2, 1698295088, 'ERKUT');

select * from mth3902;
<<<<<<< HEAD
📷 Ekran Görüntüsü: 


=======
```
>>>>>>> 4d61a42abf6f59d2cf1bd2a94de5fbf826fd84a8

📷 *Ekran görüntüsü:

![Ekran görüntüsü 2025-07-06 234452](https://github.com/user-attachments/assets/19f37032-12d0-48cc-8289-d08ab6459200)


---

🧑‍💻 **Hatalar ve Çözümler**

* **JDBC Driver Hatası:** Doğru `voltdb-jdbc` jar dosyasını yükleyin.
* **Port veya Security Group Hatası:** EC2’da 21212 portunun açık olduğundan emin olun.
* **Container Exited (137):** RAM düşükse instance tipini büyütün (t3.medium önerilir).

---

📚 **Kaynaklar**

* VoltDB Quick Start
* VoltDB JDBC Maven Repo
* DBeaver Docs

---

**Katkı:**
Esra Kanğ
