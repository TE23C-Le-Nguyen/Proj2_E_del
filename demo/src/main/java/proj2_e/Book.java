package proj2_e;

public class Book extends LibraryItem{
    private String author;
    private String genre;
    private int pages;


    public Book(String id, String title, String author, String genre, int pages, boolean isAvailable) {
        super(id, title, isAvailable);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    public String getAuthor() {return author;}
    public String getGenre() {return genre;}
    public int getPages() {return pages;}

    @Override
    public void displayInfo() {
        System.out.println("BOK");
        System.out.println("ID:" + id);
        System.out.println("Title:" + title);
        System.out.println("Författare:" + author);
        System.out.println("Genre:" + genre);
        System.out.println("Sidor:" + pages);
        System.out.println("Tillgänglig:" + (isAvailable ? "ja" : "nej"));

    }
        
    
}
