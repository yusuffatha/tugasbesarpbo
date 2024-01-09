import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateKamar {
     //Driver
     private static final String URL = "jdbc:mysql://localhost:3306/db_kamarhotel";
     private static final String USER = "root";
     private static final String PASSWORD = "";
 
     
     public static void updateDataKamar(Scanner scanner) {
         try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
             String sql = "UPDATE bookingkamar SET Hari = ?, Pemilik = ? WHERE ID = ?";
             try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                 System.out.print("No. ID Kamar: ");
                 int ID = scanner.nextInt();
                 
                 System.out.print("Nginap Berapa Hari: ");
                 String jumlahhari = scanner.next();
 
                 System.out.print("Pemilik Kamar: ");
                 String pemilikBaru = scanner.next();
 
                 preparedStatement.setString(1, jumlahhari);
                 preparedStatement.setString(2, pemilikBaru);
                 preparedStatement.setInt(3, ID);
 
                 int rowsAffected = preparedStatement.executeUpdate();
 
                 if (rowsAffected > 0) {
                     System.out.println("Data Kamar telah diupdate!");
                 } else {
                     System.out.println("tidak ditemukan data kamar dengan ID tersebut");
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
