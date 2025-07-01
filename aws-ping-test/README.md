# AWS Ping Test Ödevi

Bu ödev kapsamında AWS (Amazon Web Services) üzerinde bir sanal makine (EC2 instance) oluşturuldu ve yerel makineden bu sunucuya **ping** komutu ile bağlantı testi gerçekleştirildi.

## 🔧 Yapılan Adımlar

1. **AWS Hesabı Açma**
   - Free Tier (ücretsiz katman) avantajı kullanıldı.

2. **EC2 Sunucusu Oluşturma**
   - AMI: Amazon Linux 2023
   - Sunucu Tipi: t3.micro
   - Otomatik Genel IP (IPv4) atandı.
   - Anahtar çifti oluşturularak `.pem` dosyası indirildi.

3. **Güvenlik Grubu Ayarları**
   - SSH (port 22) erişimi: Her yer (0.0.0.0/0)
   - ICMP (All ICMP - IPv4): Ping için izin verildi

4. **Ping Testi**
   - Komut İstemi üzerinden `ping [sunucu IP]` komutu çalıştırıldı
   - Başarılı yanıtlar alındı

---

## 📸 Ekran Görüntüleri

### EC2 Instance Özeti


![Ekran görüntüsü 2025-07-01 144631](https://github.com/user-attachments/assets/058e6214-c615-4aa0-8233-ac86757ee2b2)



### Ping Testi Çıktısı
![Ekran görüntüsü 2025-07-01 144730](https://github.com/user-attachments/assets/48d262b1-f0a0-427d-844a-17d1a849a265)



---

## ✅ Sonuç

Yapılan test sonucunda, AWS bulut ortamında başlatılan sanal makineye başarıyla **erişim sağlandı** ve ağ bağlantısı doğrulandı.  
Ping çıktıları gecikme süresi ve bağlantının aktif olduğunu göstermektedir.

---

> 🧠 Not: Bu ödev, temel düzeyde bulut bilişim hizmetlerine giriş ve uzaktan bağlantı testini amaçlamaktadır.
