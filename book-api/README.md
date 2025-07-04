# 📚 Book API - Spring Boot Uygulaması

Bu proje, Spring Boot ile geliştirilmiş basit bir RESTful web servisidir. Kitap (Book) nesnesi için CRUD (Create, Read, Update, Delete) işlemleri sunar ve kullanıcı dostu bir web arayüzü ile desteklenmiştir.

---

## 🎯 Proje Hedefleri

* Spring Boot kullanarak REST API oluşturma
* H2 hafıza içi veritabanı ile hızlı veri yönetimi
* Basit, anlaşılır Thymeleaf tabanlı frontend
* Spring Data JPA ile kalıcı veri yönetimi
* Global hata yönetimi ve validasyon
* Temel Spring Security konfigürasyonu (tüm erişime izin verilir)

---

## ⚙️ Gereksinimler

* Java 17 veya üstü
* Maven 3.x
* IDE (VS Code, IntelliJ IDEA, Eclipse vb.)

---

## 🗂️ Proje Dosya Yapısı

```
src/
└── main/
    ├── java/com/example/bookapi/
    │   ├── config/
    │   │   └── SecurityConfig.java
    │   ├── controller/
    │   │   ├── BookController.java
    │   │   └── HomeController.java
    │   ├── exception/
    │   │   ├── BookIdMismatchException.java
    │   │   ├── BookNotFoundException.java
    │   │   └── RestExceptionHandler.java
    │   ├── model/
    │   │   └── Book.java
    │   ├── repository/
    │   │   └── BookRepository.java
    │   └── Application.java
    └── resources/
        ├── static/
        ├── templates/
        │   └── home.html
        └── application.properties
```

---

## 📦 Maven Bağımlılıkları (pom.xml)

```xml
<!-- Spring Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Spring Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- Spring Web & Thymeleaf -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Jakarta Validation API -->
<dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>3.0.2</version>
</dependency>
```

---

## 🚀 Uygulama Nasıl Çalıştırılır?

```bash
# Proje klasörüne git
cd book-api

# Maven ile uygulamayı başlat
./mvnw spring-boot:run
```

Ardından tarayıcıda aç:
[http://localhost:8090](http://localhost:8090)

---

## 🔗 API Uç Noktaları

| Metot  | URL                      | Açıklama                   |
| ------ | ------------------------ | -------------------------- |
| GET    | /api/books               | Tüm kitapları listele      |
| GET    | /api/books/{id}          | ID’ye göre kitap getir     |
| GET    | /api/books/title/{title} | Başlığa göre kitapları ara |
| POST   | /api/books               | Yeni kitap ekle            |
| PUT    | /api/books/{id}          | Var olan kitabı güncelle   |
| DELETE | /api/books/{id}          | Kitabı sil                 |

---

## 🧪 Örnek API Testleri (curl)

**Yeni Kitap Ekleme:**

```bash
curl -X POST http://localhost:8090/api/books -H "Content-Type: application/json" -d "{\"title\":\"Kitap 1\", \"author\":\"Yazar 1\"}"
```

**Kitapları Listeleme:**

```bash
curl http://localhost:8090/api/books
```

**Kitap Güncelleme:**

```bash
curl -X PUT http://localhost:8090/api/books/1 -H "Content-Type: application/json" -d "{\"id\":1, \"title\":\"Kitap 1 Updated\", \"author\":\"Yeni Yazar\"}"
```

**Kitap Silme:**

```bash
curl -X DELETE http://localhost:8090/api/books/1
```

---

## 🖼️ Ekran Görüntüleri

* Uygulama Anasayfa (Kitap Listesi ve Form)
* Kitap Ekleme / Güncelleme / Silme işlemleri
* API çağrılarının terminal çıktıları

*(Ekran görüntüleri `/screenshots` klasöründe yer alıyor.)*

---

## 👩‍💻 Geliştirici

Bu proje, **Esra** tarafından staj ödevi kapsamında geliştirilmiştir.

Gelecekte geliştirilmesi planlanan özellikler:

* Kalıcı veritabanı entegrasyonu (örn. MySQL)
* JWT kimlik doğrulama
* Swagger UI entegrasyonu
* Daha kapsamlı test senaryoları

---
