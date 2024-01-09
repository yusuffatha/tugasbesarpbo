import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      

        Scanner input = new Scanner (System.in);
        String pilihan;
        boolean isLanjutkan = true;

        clearScreen();
        login();

        while (isLanjutkan) {
            
            System.out.println("Database Kamar Hotel\n");
            System.out.println("1. Lihat Kamar");
            System.out.println("2. Update Kamar");
            System.out.println("3. Tambah Kamar");
            System.out.println("4. Hapus Kamar");

            System.out.println("\n\nPilihan Anda: ");
            pilihan = input.next();

            switch (pilihan){
                case "1":
                    System.out.println("==========");
                    System.out.println("List Kamar");
                    System.out.println("==========");
                    tampilkanKamar();
                    break;
                case "2":
                    System.out.println("===========");
                    System.out.println("Update Kamar");
                    System.out.println("===========");
                    updateKamar();
                    break;
                case "3":
                    System.out.println("================");
                    System.out.println("Check in");
                    System.out.println("================");
                    tambahKamar();
                    break;
                case "4":
                    System.out.println("==============");
                    System.out.println("Check out");
                    System.out.println("==============");
                    hapusKamar();
                    break;
                default:
                    System.err.println("\nInput Anda Tidak Ditemukan\nSilahkan pilih opsi 1 - 5");
            }
            isLanjutkan = getYesorNO("Apakah anda ingin melanjutkan");
            clearScreen();
        }
    }    

    private static void tampilkanKamar() throws IOException{
        ReadKamar baca = new ReadKamar();
        baca.ReadKamar();
    }

    private static void updateKamar() throws IOException{
        Scanner scan = new Scanner(System.in);
        UpdateKamar.updateDataKamar(scan);
        System.out.println("");
    }

    private static void tambahKamar() throws IOException{
        Scanner scanner = new Scanner(System.in);
        CreateKamar.insertDataKamar(scanner);
        System.out.println("");
    }

    private static void hapusKamar() throws IOException{
        DeleteKamar.deleteKamarById();
        System.out.println(""); 
    }

    private static boolean getYesorNO(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihan = input.next();
    
        while (!pilihan.equalsIgnoreCase("y") && (!pilihan.equalsIgnoreCase("n"))) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihan = input.next();
        }

        return pilihan.equalsIgnoreCase("y");
    }

    private static void clearScreen(){
        try{
            if (System.getProperty("os.name").contains("windows")){
                new ProcessBuilder ("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        }catch (Exception ex){
            System.err.println("Tidak bisa clear screen");
        }
    }

    public static void login(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("DATABASE KAMAR HOTEL");
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        Manager admin = new Manager("Arif", "Arif123");

        if (admin.authenticate(inputUsername, inputPassword)) {
            admin.displayLoginMessage();
            // Lakukan operasi admin lainnya di sini
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
    
