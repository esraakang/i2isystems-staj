# Selenium Login Automation

Bu proje, Java ile Selenium kullanarak bir e-ticaret sitesine otomatik giriş (login) işlemi gerçekleştiren temel bir test otomasyon uygulamasıdır.

---

## ✨ Proje Hedefleri

* Java + Selenium WebDriver ile otomatik login testi geliştirmek
* Login sonrası otomatik ekran görüntüsü almak
* Maven ile proje ve bağımlılık yönetimi
* Proje klasöründe ekran görüntüsü ile sonucu belgelemek

---

## 🚀 Gereksinimler

* Java JDK (11+ veya 17 önerilir)
* Maven
* Google Chrome (güncel)
* Visual Studio Code (veya herhangi bir Java IDE)
* İnternet bağlantısı (bağımlılıkları çekmek için)

---

## 📁 Proje Dosya Yapısı

```
selenium-login-test/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── seleniumtest/
│                       └── LoginTest.java
├── pom.xml
├── login_result.png
└── README.md
```

---

## 🖥️ 1. Proje Kurulumu ve Maven Yapılandırması

### a) Maven ile Proje Oluşturma

Terminalde:

```bash
mvn archetype:generate -DgroupId=com.example.seleniumtest -DartifactId=selenium-login-test -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

### b) Gerekli Bağımlılıkları Ekleme

`pom.xml` dosyasına şu bağımlılıkları ekleyin:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.21.0</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.8.0</version>
    </dependency>
</dependencies>
```

---

## 🧑‍💻 2. Otomasyon Kodunun Yazılması

`src/main/java/com/example/seleniumtest/LoginTest.java` içerik:

```java
package com.example.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class LoginTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com/");
            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            loginButton.click();

            Thread.sleep(2000);

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File("login_result.png"));
            System.out.println("Login test completed. Screenshot saved.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
```

---

## 🔄 Projeyi Çalıştırma

Terminalde proje klasöründe:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.example.seleniumtest.LoginTest"
```

> **Not:** Kod başarıyla çalışınca proje klasöründe `login_result.png` oluşacaktır.

---

---

## 🚫 Karşılaşılan Hatalar & Çözümler

* **no POM in this directory**
  → Yanlış klasörde komut çalıştırıldı, `pom.xml` olan klasöre geçilmeli.

* **package junit.framework does not exist**
  → Otomatik oluşan test dosyası silinmeli veya JUnit bağımlılığı eklenmeli.

* **SLF4J(W): No SLF4J providers were found**
  → Sadece log uyarısı, çalışmaya engel değildir.

* **CDP implementation matching 137 not found**
  → Chrome'un güncelliğinden kaynaklanır, testin çalışmasını etkilemez.

---

## 📂 Dosya ve Klasörler

```
selenium-login-test/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── seleniumtest/
│                       └── LoginTest.java
├── login_result.png
└── README.md
```

---

## 📅 Katkıda Bulunanlar

* Esra Kanğ – Proje Sahibi

---

## 📚 Kaynaklar

* [Selenium Java Documentation](https://www.selenium.dev/documentation/)
* [WebDriverManager GitHub](https://github.com/bonigarcia/webdrivermanager)
* [SauceDemo Practice Site](https://www.saucedemo.com/)
