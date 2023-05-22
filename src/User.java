import java.util.ArrayList;

public class User {
    private String name;
    private int libraryCardNumber;
    private ArrayList<Book> checkedOutBooks;
    private int lateFeeRate;
    public User (String name){
        this.name = name;
        checkedOutBooks = new ArrayList<>();
        this.lateFeeRate = 3;
    }

    public void setLibraryID(int libraryID) {
        this.libraryCardNumber = libraryID;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
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

    public void setLateFeeRate(int lateFeeRate) {
        this.lateFeeRate = lateFeeRate;
    }

    public int getLateFee(){
        return lateFeeRate;
    }
    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public String toString(){
        return "User name: " + name + "\n"
                + "User ID: " + libraryCardNumber + "\n"
                + "Books checked out: " + checkedOutBooks;
    }
}
