# Oracle Book Insert (Java JDBC + Docker Oracle XE)

Bu proje, Java programlama diliyle JDBC kullanılarak Oracle XE veritabanına bağlanmayı ve `BOOK` tablosuna 100 adet örnek veri eklemeyi amaçlamaktadır. Veritabanı Docker üzerinden çalışmakta olup, Java uygulaması ile doğrudan bağlantı kurulmuştur.

---

## ✨ Proje Hedefleri

* Java ile Oracle JDBC bağlantısını kurmak
* `PreparedStatement` ile veritabanına veri eklemek
* Rastgele verilerle `BOOK` tablosunu doldurmak
* Oracle SQL Developer üzerinden sonucu doğrulamak
* Ekran görüntüleriyle belgelemek

---

## 🚀 Gereksinimler

* Docker kurulu bir işletim sistemi (Oracle XE çalışıyor olmalı)
* Java JDK (en az 8+ önerilir)
* `ojdbc8.jar` (Oracle JDBC Driver)
* Oracle SQL Developer
* VS Code veya başka bir metin editörü

---

## 📁 Proje Yapısı

```
oracle-insert-project/
├── BookBatchInsert.java
├── libs/
│   └── ojdbc8.jar
├── screenshots/
│   ├── bookbatchinsert-java-code.png
│   ├── bookbatchinsert-java-output.png
│   └── book-select-result.png
```

---

## 🧱 1. Java Uygulaması

🔹 `BookBatchInsert.java` dosyasında JDBC bağlantısı kurulmuş ve 100 kayıt hazırlanmıştır. Her kayıt için rastgele `NAME` ve `ISBN` oluşturulmuştur.

![bookbatchinsert-java-code](https://github.com/user-attachments/assets/5c5e1ecc-35e3-4efa-b3e0-576f54634585)



```java
String sql = "INSERT INTO BOOK (ID, NAME, ISBN) VALUES (?, ?, ?)";
for (int i = 1; i <= 100; i++) {
    ps.setInt(1, i);
    ps.setString(2, generateRandomName());
    ps.setString(3, generateRandomIsbn());
    ps.executeUpdate();
}
```

---

## ▶️ 2. Programın Çalıştırılması

```bash
javac -cp ".;libs/*" BookBatchInsert.java
java -cp ".;libs/*" BookBatchInsert
```

![bookbatchinsert-java-output](https://github.com/user-attachments/assets/69cf8158-2afa-4175-acf8-9d11bab1d410)

---

## 🧾 3. Sonuçların Doğrulanması

🔹 Oracle SQL Developer'da aşağıdaki sorgu çalıştırılmıştır:

```sql
SELECT * FROM BOOK;
```

🔹 `ID`, `NAME`, `ISBN`, `CREATE_DATE` sütunlarıyla birlikte 100 kayıt başarıyla görüntülenmiştir.

![book-select-result](https://github.com/user-attachments/assets/8ad3f3c8-a732-4006-b4a4-ff35247eef81)


---

## ✅ Sonuç

* JDBC bağlantısı başarıyla kuruldu
* 100 kayıt Java tarafından eklendi
* Oracle SQL Developer'da kayıtlar görüntülendi
* Ekran görüntüleriyle adımlar belgelendi

Bu proje, Java ile Oracle veritabanı etkileşiminin temelini göstermek için hazırlanmıştır. Daha büyük sistemler için `ConnectionPool`, `ORM` ve `Exception Handling` mekanizmalarıyla genişletilebilir.

---

## 👤 Katkı

**Esra Kanğ** – 2025 Yaz Dönemi I2I Systems Stajı kapsamında hazırlanmıştır.

---

## 📚 Kaynaklar

* [Oracle JDBC Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)
* [StackOverflow – Java Oracle JDBC Select Example](https://stackoverflow.com/questions/8778422/java-oracle-jdbc-select-statement)
* Oracle SQL Developer
