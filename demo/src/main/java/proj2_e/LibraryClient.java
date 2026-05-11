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
        while ( (running)) {
            System.out.println("BIBLIOTEK");
            System.out.println("1. Hämta böcker från server");
            System.out.println("2. Hämta tidningar från server");
            System.out.println("3. Visa alla böcker/magazine");
            System.out.println("4. Lägg till bok");
            System.out.println("5. Lägg till magazine");
            System.out.println("6. Avsluta");
            System.out.println("Val: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    fetchBooks();
                    break;

                case "2":
                    fetchMagazines();
                    break;

                case "3":
                    printAll();
                    break;

                case "4":
                    addBook();
                    break;

                case "5":
                    addMagazine();
                    break;

                case "6":
                    System.out.println("Avslutar");
                    break;
            
                default:
                    System.out.println("Ogiltigt val");
                    break;
            }
        }
    }

    private static String getFromServer(String urlString) throws Exception{
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null){
            sb.append(line);
        }

        reader.close();
        return sb.toString();
    }

    private static void fetchBooks() {
        try {
            String json = getFromServer(SERVER_URL + "/books");

            System.out.println("Böcker hämtade!");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Fel vid hämtning av böcker");
        }
    }

    private static void fetchMagazines() {
        try {
            String json = getFromServer(SERVER_URL + "/magazines");

            System.out.println("Magazine hämtade!");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Fel vid hämtning av magazine");
        }
    }

    private static void printAll() {
        System.out.println("Böcker");
        if (books.isEmpty()) {
            System.out.println("Inga böcker sparade lokalt");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }

        System.out.println("Magazine");
        if (magazines.isEmpty()) {
            System.out.println("Inga magazines sparade lokalt");
        } else {
            for (Magazine m : magazines) {
                System.out.println(m);
            }
        }
    }

    private static void addBook() {
        System.out.println("Titel: ");
        String title = scanner.nextLine();

        System.out.println("Författare: ");
        String author = scanner.nextLine();

        System.out.println("Genre: ");
        String genre = scanner.nextLine();

        System.out.println("Sidor: ");
        String pages = Integer.parseInt(scanner.nextLine());


    }
    
}
