# AWS Ping Test Ödevi

Bu ödev kapsamında AWS (Amazon Web Services) üzerinde bir sanal makine (EC2 instance) oluşturuldu ve yerel makineden bu sunucuya **ping** komutu ile bağlantı testi gerçekleştirildi.

---

## 🔧 Yapılan Adımlar

1. **AWS Hesabı Açma**

   * Free Tier (ücretsiz katman) avantajı kullanıldı.

2. **EC2 Sunucusu Oluşturma**

   * AMI: Amazon Linux 2023
   * Sunucu Tipi: t3.micro
   * Otomatik Genel IP (IPv4) atandı.
   * Anahtar çifti oluşturularak `.pem` dosyası indirildi.

3. **Güvenlik Grubu Ayarları**

   * SSH (port 22) erişimi: Her yer (0.0.0.0/0)
   * ICMP (All ICMP - IPv4): Ping için izin verildi

4. **Ping Testi**

   * Komut İstemi üzerinden `ping [sunucu IP]` komutu çalıştırıldı
   * Başarılı yanıtlar alındı

---

## 📸 Ekran Görüntüleri

### 📷 EC2 Instance Özeti

> `screenshots/ec2-instance-summary.png`

### 📷 Ping Testi Çıktısı

> `screenshots/ping-test.png`

---

## ✅ Sonuç

Yapılan test sonucunda, AWS bulut ortamında başlatılan sanal makineye başarıyla **erişim sağlandı** ve ağ bağlantısı doğrulandı.
Ping çıktıları gecikme süresi ve bağlantının aktif olduğunu göstermektedir.

---

> 🧠 Not: Bu ödev, temel düzeyde bulut bilişim hizmetlerine giriş ve uzaktan bağlantı testini amaçlamaktadır.
