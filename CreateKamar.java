import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateKamar {
    private static final String URL = "jdbc:mysql://localhost:3306/db_kamarhotel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertDataKamar(Scanner scan) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO bookingkamar (ID, Hari, Pemilik) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                System.out.print("\nInputkan ID Kamar: ");
                int idKamar = scan.nextInt();

                System.out.print("Jumlah Hari Menginap: ");
                String jumlahhari = scan.next();

                System.out.print("Inputkan Pemilik Kamar: ");
                String pemilikKamar = scan.next();

                preparedStatement.setInt(1, idKamar);
                preparedStatement.setString(2, jumlahhari);
                preparedStatement.setString(3, pemilikKamar);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Berhasil menginputkan kamar baru");
                } else {
                    System.out.println("Tidak dapat menginputkan kamar baru");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
