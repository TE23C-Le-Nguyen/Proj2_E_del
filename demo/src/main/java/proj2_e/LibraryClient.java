package proj2_e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
public class LibraryClient {
    private static final String SERVER_URL = "http://10.151.168.5:3107";
    private static ArrayList<Magazine> Book = new ArrayList<>();
    private static ArrayList<Book> Magazine = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    FetchBooks();
                    break;
                case "2":
                

            
                default:
                    break;
            }
        }
    }
    
}
