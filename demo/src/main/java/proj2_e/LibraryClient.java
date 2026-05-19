package proj2_e;

import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import kong.unirest.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryClient {
    private static final String SERVER_URL = "http://10.151.168.5:3107";
    private static ArrayList<Magazine> magazines = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while ((running)) {
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
                    running = false;
                    break;

                default:
                    System.out.println("Ogiltigt val");
                    break;
            }
        }
    }

    private static String getFromServer(String urlString) throws Exception {
        
        HttpResponse<String> response = Unirest.get(urlString).asString();
        String json_data = response.getBody();
        return json_data;

    }

    private static void fetchBooks() {
        try {
            String json = getFromServer(SERVER_URL + "/books");
            Type listType = new TypeToken<ArrayList<Book>>() {}.getType();
            books = new Gson().fromJson(json, listType);
            System.out.println("Böcker hämtade! Antal: " + books.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Tryck enter för att fortsätta...");
        scanner.nextLine();
    }

    private static void fetchMagazines() {
        try {
            String json = getFromServer(SERVER_URL + "/magazines");
            Type listType = new TypeToken<ArrayList<Magazine>>() {
            }.getType();
            magazines = new Gson().fromJson(json, listType);
            System.out.println("Magazine hämtade! Antal: " + magazines.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Tryck enter för att fortsätta...");
        scanner.nextLine();
    }

    private static void printAll() {2
        System.out.println("Antal böcker: " + books.size());     
    System.out.println("Antal magazines: " + magazines.size());
        System.out.println("Böcker");
        if (books.isEmpty()) {
            System.out.println("Inga böcker sparade lokalt");
        } else {
            for (Book b : books) {
                b.displayInfo();
                ;
            }
        }

        System.out.println("Magazine");
        if (magazines.isEmpty()) {
            System.out.println("Inga magazines sparade lokalt");
        } else {
            for (Magazine m : magazines) {
                m.displayInfo();
                ;
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
        int pages = Integer.parseInt(scanner.nextLine());

        books.add(new Book(String.valueOf(books.size() + 1), title, author, genre, pages, true));

        System.out.println("bok tillagd");

    }

    private static void addMagazine() {
        System.out.println("Titel: ");
        String title = scanner.nextLine();

        System.out.println("Issues number: ");
        int issues = Integer.parseInt(scanner.nextLine());

        System.out.println("Kategory: ");
        String category = scanner.nextLine();

        System.out.println("År: ");
        int year = Integer.parseInt(scanner.nextLine());

        magazines.add(new Magazine(String.valueOf(magazines.size() + 1), title, issues, category, year, true));

        System.out.println("magazine tillagd");

    }

}
