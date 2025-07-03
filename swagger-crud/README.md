# 📚 Spring Boot + Swagger UI Müşteri CRUD Uygulaması

Bu proje, Spring Boot ile geliştirilmiş bir RESTful web servisidir. `Customer` (Müşteri) nesnesi için CRUD (Create, Read, Update, Delete) işlemlerini sunar ve API uç noktaları **Swagger UI** üzerinden belgelenmiştir. Uygulama basit, katmanlı mimari ile oluşturulmuş ve kalıcı bir veritabanı yerine `Map` tabanlı geçici bir bellek kullanmaktadır.

---

## 🎯 Hedefler

* Katmanlı Spring Boot uygulaması geliştirme
* Swagger/OpenAPI entegrasyonu
* DTO kullanımı ile veri transferi
* Validasyon (@NotBlank, @Email)
* Swagger UI üzerinden interaktif test
* Geliştirici dostu ve temiz kod yapısı

---

## ⚙️ Gereksinimler

* Java 21
* Maven 3.x
* IDE (VS Code, IntelliJ, Eclipse...)

---

## 🗂️ Proje Yapısı

```
src/
└── main/
    └── java/com/example/swagger/
        ├── SwaggerCrudApplication.java
        ├── controller/
        │   └── CustomerController.java
        ├── dto/
        │   └── CustomerDTO.java
        └── service/
            └── CustomerService.java
```

---

## 📦 Maven Bağımlılıkları (`pom.xml`)

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

---

## 🚀 Uygulama Nasıl Çalıştırılır?

```bash
# Proje klasörüne gir
cd swagger-crud

# Maven ile uygulamayı başlat
mvn spring-boot:run
```

Ardından tarayıcıda şu URL'yi aç:

```
http://localhost:8080/swagger-ui.html
```

Swagger UI arayüzü açıldığında tüm uç noktaları otomatik görebilir, JSON girdilerle testler yapabilirsin.

---

## 🔗 REST API Uç Noktaları

| Metot  | URL                   | Açıklama                      |
| ------ | --------------------- | ----------------------------- |
| POST   | `/api/customers`      | Yeni müşteri oluştur          |
| GET    | `/api/customers`      | Tüm müşterileri getir         |
| GET    | `/api/customers/{id}` | Belirli müşteri bilgisi getir |
| PUT    | `/api/customers/{id}` | Müşteri bilgilerini güncelle  |
| DELETE | `/api/customers/{id}` | Müşteri kaydını sil           |

---

## 🧪 Test Verisi Örneği

```json
{
  "name": "Esra Kanğ",
  "email": "esrakang01@gmail.com"
}
```

---

## 🧾 DTO Sınıfı

```java
public class CustomerDTO {
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    // getter - setter
}
```

---

## 🧪 Swagger UI Üzerinden Yapılan Testler

| Test               | Durum |
| ------------------ | ----- |
| POST: Müşteri Ekle | ✅     |
| GET: Listele       | ✅     |
| GET: Tek müşteri   | ✅     |
| PUT: Güncelle      | ✅     |
| DELETE: Sil        | ✅     |

---

## 🖼️ Ekran Görüntüleri

* Swagger UI anasayfa
* POST /api/customers isteği ve cevabı
* GET /api/customers tüm kayıtlar
* PUT /api/customers/{id} güncelleme testi
* DELETE /api/customers/{id} silme testi

> Ekran görüntüleri klasöre eklenmiş olmalıdır: `/screenshots`

---

## 👩‍💻 Geliştirici

> Bu proje, Esra tarafından staj ödevi kapsamında geliştirilmiştir.

Gelecekte veritabanı entegrasyonu, JWT kimlik doğrulama, loglama ve hata yönetimi gibi konularla genişletilebilir.

---

## 🔗 Kaynaklar

* [Spring Boot Docs](https://spring.io/projects/spring-boot)
* [Springdoc OpenAPI](https://springdoc.org/)
* [Swagger UI](https://swagger.io/tools/swagger-ui/)
