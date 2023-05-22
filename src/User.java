import java.util.ArrayList;

public class User {
    private String name;
    private int libraryID;
    private ArrayList<Book> checkedOutBooks;
    public User (String name){
        this.name = name;
        checkedOutBooks = new ArrayList<>();
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public String getName(){
        return name;
    }
    public void checkOutBook(Book book){
        book.setOnLoan();
        checkedOutBooks.add(book);
    }
    public void returnBook(Book book){
        book.setOffLoan();
        checkedOutBooks.remove(book);
    }
}
