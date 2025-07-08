import java.sql.*;
import java.util.Random;

public class BookBatchInsert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1522:XE";
        String username = "esra";
        String password = "1234";

        String sql = "INSERT INTO BOOK (ID, NAME, ISBN) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 1; i <= 100; i++) {
                ps.setInt(1, i);
                ps.setString(2, generateRandomName());
                ps.setString(3, generateRandomIsbn());
                ps.executeUpdate();
            }

            System.out.println("✅ 100 kayıt başarıyla eklendi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomName() {
        String[] names = {"Kafka", "Oracle", "Java", "Docker", "Spring", "Refactor", "CleanCode"};
        return names[new Random().nextInt(names.length)] + "_" + new Random().nextInt(1000);
    }

    private static String generateRandomIsbn() {
        return "ISBN-" + (100000 + new Random().nextInt(900000));
    }
}
