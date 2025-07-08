# 📚 ORACLEDB-EX-03 — Oracle SQL Developer ile BOOK Tablosu Oluşturma

Bu proje, Oracle SQL Developer üzerinden Oracle XE veritabanına bağlanarak `BOOK` isimli bir tablo olulanarak `BOOK` isimli bir tablo olu\u015kturmayı ve temel SQL komutlarının uygulanmasını kapsamaktadır. Proje, \[i2i Systems Summer Internship 2025] kapsamında verilen ORACLEDB-EX-03 adlı ödevin çözümdür.

---

## 🔧 Kullanılan Teknolojiler

* Oracle Database 21c Express Edition (Docker üzerinden)
* Oracle SQL Developer
* Docker (container yönetimi)
* SQL (DDL komutu ile tablo oluşturma)

---


## 📘 Oluşturulan Tablo: `BOOK`

```sql
CREATE TABLE BOOK (
  ID NUMBER,
  NAME VARCHAR2(128),
  ISBN VARCHAR2(32),
  CREATE_DATE DATE DEFAULT SYSDATE
);
```

| Kolon Adı     | Veri Tipi     | Varsayılan Değer |
| ------------- | ------------- | ---------------- |
| `ID`          | NUMBER        | -                |
| `NAME`        | VARCHAR2(128) | -                |
| `ISBN`        | VARCHAR2(32)  | -                |
| `CREATE_DATE` | DATE          | `SYSDATE`        |

---

## 📸 Ekran Görüntüleri

1. Oracle SQL Developer bağlantı ekranı (Status: Success)


2. `CREATE TABLE` komutunun çalıştırıldığı SQL Worksheet


3. `BOOK` tablosunun tablolar listesinde görünmesi


4. `BOOK` tablosunun kolon detaylarının incelenmesi



*Tüm ekran görüntüleri `screenshots/` klasörü içinde yer almaktadır.*

---

## 🚀 Çalıştırmak için

> Bu repo sadece belge ve SQL tanımı içermektedir. Oracle kurulumuna dair bilgi gerekiyorsa lütfen `docs/setup.md` dosyasına göz atın (isteğe bağlı olarak eklenebilir).

---

## 👩‍💻 Hazırlayan

**Esra Kanğ**
📍 i2i Systems Stajyeri – Summer Internship 2025

---
