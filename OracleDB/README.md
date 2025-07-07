# Oracle XE 21c Docker Lokal Kurulum Rehberi

Bu döküman, **Windows** üzerinde Docker Desktop ve Git Bash/WSL kullanarak Oracle Database 21c Express Edition (XE) Docker container’ını **lokal olarak** nasıl build edip çalıştıracağınızı adım adım açıklar.

## Gereksinimler

* [Docker Desktop](https://www.docker.com/products/docker-desktop/) (Windows, Mac veya Linux)
* [Git Bash](https://gitforwindows.org/) veya WSL terminali
* [Oracle XE 21c RPM](https://www.oracle.com/database/technologies/oracle-database-software-downloads.html) (İndirmek için ücretsiz Oracle hesabı gerekir. Örn: `oracle-database-xe-21c-1.0-1.ol8.x86_64.rpm`)
* En az 12 GB boş disk alanı

## 1. Adım: Oracle Docker Images Reposunu Klonlayın

```bash
git clone https://github.com/oracle/docker-images.git
cd docker-images/OracleDatabase/SingleInstance/dockerfiles
```

## 2. Adım: Oracle XE RPM Dosyasını Yerleştirin

Oracle’ın web sitesinden **Oracle XE 21c RPM** dosyasını indirin ve klonladığınız repo içindeki `21.3.0` klasörüne kopyalayın:

```bash
mv /indirilen-dosya-yolu/oracle-database-xe-21c-1.0-1.ol8.x86_64.rpm ./21.3.0/
```

## 3. Adım: Docker İmajını Build Edin

`dockerfiles` klasöründe **Git Bash** veya **WSL** üzerinden aşağıdaki komutu çalıştırın:

```bash
./buildContainerImage.sh -v 21.3.0 -x
```

Başarılı olursa aşağıdaki gibi bir çıktı alırsınız:

```
Oracle Database container image for 'xe' version 21.3.0 is ready to be extended:
    --> oracle/database:21.3.0-xe
Build completed in ... seconds.
```

## 4. Adım: Oracle XE Container’ını Çalıştırın

Eğer 1521 portu boşsa:

```bash
docker run --name oraclexe -p 1521:1521 -p 5500:5500 -e ORACLE_PWD=ORACLE -d oracle/database:21.3.0-xe
```

Eğer 1521 portu doluysa, alternatif portlar kullanın (örn: host 1522 → container 1521):

```bash
docker run --name oraclexe -p 1522:1521 -p 5501:5500 -e ORACLE_PWD=ORACLE -d oracle/database:21.3.0-xe
```

## 5. Adım: Container İçinde SQLPlus’a Bağlanın

```bash
docker exec -it oraclexe bash
sqlplus sys/ORACLE@//localhost:1521/XE as sysdba
```

> Host’ta farklı bir port kullansanız bile container içinde **:1521** kullanmalısınız.

## 6. Adım: Veritabanını Test Edin

SQLPlus promptunda:

```sql
select name from v$database;
```

Beklenen çıktı:

```
NAME
---------
XE
```

## Faydalı Komutlar

* **Docker imajlarını listele:**

  ```bash
  docker images
  ```
* **Çalışan containerları listele:**

  ```bash
  docker ps
  ```
* **Container durdur/sil:**

  ```bash
  docker stop oraclexe
  docker rm oraclexe
  ```

## Notlar

* Yeterli boş disk alanınız olduğundan emin olun.
* Port çakışması hatası alırsanız farklı portlar kullanın.
* Resmi dökümantasyon: [Oracle XE 21c Docker Guide](https://docs.oracle.com/en/database/oracle/oracle-database/21/xeinl/running-oracle-database-free-in-a-docker-container.html)

---

> **Esra tarafından, lokal Oracle Database 21c XE Docker kurulumu demo amaçlı hazırlanmıştır.**
