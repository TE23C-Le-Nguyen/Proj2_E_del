package proj2_e;

public abstract class LibraryItem {
    protected String id;
    protected String title;
    protected boolean isAvailable;

    public LibraryItem(String id, String title, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public String getID() {return id;}
    public String getTitle() {return title;}
    public boolean isAvailable() {return isAvailable;}

    public abstract void displayInfo();
}
