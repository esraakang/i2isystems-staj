VoltDB on Docker (Cloud & DBeaver Setup)
Bu proje, VoltDB’yi hem AWS EC2 bulut ortamında Docker ile ayağa kaldırmayı, hem de DBeaver arayüzü üzerinden tablo işlemleri yapmayı amaçlamaktadır.

✨ Proje Hedefleri

AWS EC2 üzerinde Docker ile VoltDB kurulum ve çalıştırma

DBeaver ile uzak bağlantı ve SQL işlemleri (tablo oluşturma, veri ekleme, sorgu)

Hatalarla mücadele (container durma, port hatası, driver problemleri)

Ekran görüntüleriyle belgelenmiş tam süreç

🚀 Gereksinimler

AWS hesabı + EC2 Instance (Amazon Linux 2023)

Docker (ve docker-compose, opsiyonel)

Dış dünyaya açık 21212 portu (Security Group ayarı)

DBeaver (v25+), lokal makinede

SSH erişimi (.pem anahtar dosyası)

📁 Proje Dosya Yapısı

pgsql
Kopyala
Düzenle
volt-db-cloud-demo/
├── docker-run-command.txt
├── README.md
└── screenshots/
    ├── ec2-terminal-login.png
    ├── docker-ps-up.png
    ├── dbeaver-connection.png
    ├── dbeaver-tables.png
    └── dbeaver-query-result.png
🖥️ 1. AWS EC2 ve Docker’da VoltDB Kurulumu

bash
Kopyala
Düzenle
# Sunucuya SSH ile bağlan
ssh -i "staj-key.pem" ec2-user@<EC2_PUBLIC_IP>

# Docker ve Network
docker rm volt
docker network create voltLocalCluster

# VoltDB Docker ile başlat
docker run -d --name volt --network=voltLocalCluster -p 21212:21212 -p 8080:8080 -p 55004:55004 full360/docker-voltdb-ce
📷 Ekran Görüntüsü: EC2 terminal ve docker ps çıktısı

🔗 2. DBeaver ile VoltDB Bağlantısı

JDBC URL:
jdbc:voltdb://<EC2_PUBLIC_IP>:21212

Driver JAR: Uyumlu bir voltdb-jdbc-*.jar dosyası

Class Name: org.voltdb.jdbc.Driver

Test Connection: SUCCESS

📷 Ekran Görüntüsü: DBeaver bağlantı ayarları ve başarılı bağlantı testi

🗄️ 3. Tablo Oluşturma ve Veri Ekleme (DBeaver SQL Editörü)

sql
Kopyala
Düzenle
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
📷 Ekran Görüntüsü: DBeaver’da tablo oluşturma, veri ekleme ve select sonucu

🧑‍💻 Hatalar ve Çözümler

JDBC Driver Hatası: Doğru voltdb-jdbc jar dosyasını yükleyin.

Port veya Security Group Hatası: EC2’da 21212 portunun açık olduğundan emin olun.

Container Exited (137): RAM düşükse instance tipini yükseltin (t3.medium önerilir).

📚 Kaynaklar

VoltDB Quick Start

VoltDB JDBC Maven Repo

DBeaver Docs

📅 Katkıda Bulunanlar

Esra Kanğ