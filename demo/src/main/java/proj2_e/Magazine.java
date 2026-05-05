package proj2_e;

public class Magazine extends LibraryItem{
    private int issueNumber;
    private String category;
    private int publishedYear;

    public Magazine(String id, String title, int issueNumber, String category, int publishedYear, boolean isAvailable) {
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
        this.category = category;
        this.publishedYear = publishedYear;
    }
    public int getissueNumber() {return issueNumber;}
    public String getcategory() {return category;}
    public int getpublishedYear() {return publishedYear;}

    @Override
    public void displayInfo() {
        System.out.println("Magazine");
        System.out.println("ID:" + id);
        System.out.println("Title:" + title);
        System.out.println("Nummer:" + issueNumber);
        System.out.println("Kategory:" + category);
        System.out.println("Utgivningsår:" + publishedYear);
        System.out.println("Tillgänglig:" + (isAvailable ? "ja" : "nej"));

    }
        
    
}