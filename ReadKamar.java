import java.sql.*;

public class ReadKamar {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_kamarhotel";
    static final String USER = "root";
    static final String PASSWORD = "";

    public void ReadKamar(){
        try {
            // Menghubungkan ke database
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Membuat statement SQL
            String query = "SELECT * FROM bookingkamar";
            Statement statement = connection.createStatement();

            // Mengeksekusi query dan mendapatkan hasilnya
            ResultSet resultSet = statement.executeQuery(query);

            // Menampilkan hasil query
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String Hari = resultSet.getString("Hari");
                String Pemilik = resultSet.getString("Pemilik");

                System.out.println(ID + ". " + Hari + " - " + Pemilik);
            }

            // Menutup resource
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}