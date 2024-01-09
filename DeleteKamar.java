import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteKamar {
    private static final String URL = "jdbc:mysql://localhost:3306/db_kamarhotel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void deleteKamarById() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM bookingkamar WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Scanner del = new Scanner(System.in);
                System.out.print("Masukkan ID kamar yang ingin dihapus: ");
                int idBuku = del.nextInt();
                preparedStatement.setInt(1, idBuku);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("data kamar berhasil dihapus!");
                } else {
                    System.out.println("tidak ditemukan data kamar dengan ID tersebut.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
