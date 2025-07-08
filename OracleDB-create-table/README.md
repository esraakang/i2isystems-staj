# 📚 ORACLEDB-EX-03 — Oracle SQL Developer ile BOOK Tablosu Oluşturma

Bu proje, Oracle SQL Developer üzerinden Oracle XE veritabanına bağlanarak `BOOK` isimli bir tablo oluşturularak `BOOK` isimli bir tablo oluşturmayı ve temel SQL komutlarının uygulanmasını kapsamaktadır. Proje, \[i2i Systems Summer Internship 2025] kapsamında verilen ORACLEDB-EX-03 adlı ödevin çözümdür.

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

![Ekran görüntüsü 2025-07-08 132433](https://github.com/user-attachments/assets/5e1cf4d1-e40b-4010-865b-bfcee395d607)


2. `CREATE TABLE` komutunun çalıştırıldığı SQL Worksheet

![Ekran görüntüsü 2025-07-08 132851](https://github.com/user-attachments/assets/98abaaf7-72be-4b30-863a-559ca29da1cf)

3. `BOOK` tablosunun tablolar listesinde görünmesi

![Ekran görüntüsü 2025-07-08 132902](https://github.com/user-attachments/assets/4862ef69-e24e-4d54-b76a-254c9b33a6e2)

4. `BOOK` tablosunun kolon detaylarının incelenmesi

![Ekran görüntüsü 2025-07-08 132925](https://github.com/user-attachments/assets/7d848b1f-4023-4a80-b70d-bb8ace5431d4)


*Tüm ekran görüntüleri `screenshots/` klasörü içinde yer almaktadır.*

---

## 👩‍💻 Hazırlayan

**Esra Kanğ**
📍 i2i Systems Stajyeri – Summer Internship 2025

---
