import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<User> users;
    public Library (){
        bookList = new ArrayList<>();
        users = new ArrayList<>();
    }
    public void addBook(Book book){
        bookList.add(book);
    }
    public void removeBook(String titleToRemove) {
        //removes a book using the Predicate functional interface to check if the titles are equal
        bookList.removeIf(book -> book.getTitle().equals(titleToRemove));
    }

    public List<Book> getBookByYear(int publicationYear) {
        //filters using a Predicate to see if the publication years match, and creates a new list
        return bookList.stream().filter(book -> book.getPublicationYear() == publicationYear)
                .collect(Collectors.toList());
    }
    public List<Book> getBookByAuthor(String authorName){
        //filters using a Predicate to see if the authors match, and creates a new list
        return bookList.stream().filter(book -> book.getAuthor().equals(authorName))
                .collect(Collectors.toList());
    }
    public List<Book> getBooksWithPages(int pageNumber){
        //filters using a Predicate to see if the number of pages is more than provided number
        //and creates a new list
        return bookList.stream().filter(book -> book.getPages() > pageNumber).collect(Collectors.toList());
    }
    public Book getBookWithMostPages(){
        //Makes a new list of just the page numbers, uses Function functional interface
        // in the .map method
      List<Integer> pagesList = bookList.stream().map(book -> book.getPages()).collect(Collectors.toList());
      //Gets the highest value from the previously made list
      int highestPages = Collections.max(pagesList);
      //filters the bookList looking for the one item that has the same number of pages as the highest
        //and gets that item
      return bookList.stream().filter(book -> book.getPages() == highestPages).findAny().get();
    }
    public List<String> getAlphabeticalBookList() {
        //Using Function functional interface in .map to create a new list of titles and sort it
        Function<Book, String> bookTitles = book -> book.getTitle();
        return bookList.stream().map(bookTitles).sorted().toList();
    }
    public List<Book> getBooksByCategory(String category) {
        return bookList.stream().filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }
    public void registerUser(User user){
        users.add(user);
        user.setLibraryID(users.size());
        System.out.println("User " + user.getName() + " now registered.");
    }

    public int calculateLateFees(User user){
        //The running tally of the total late fees
        int lateFee = 0;
        //Checks to see if the user has a book out
        Predicate<User> hasBooks = theUser -> theUser.getCheckedOutBooks().size() > 0;
        //Checks how many days the book has been out
        Function<Book, Integer> checkDays = book -> book.getDaysOut();
        //Sets the late fee to the TOTAL number of days the book has been out
        //Crazy high late fees, but the library means business
        Consumer<Integer> setOverdueRate = daysPastDue -> user.setLateFeeRate(daysPastDue);
        //Gets the late fee for calculation
        Supplier<Integer> feeCalc = () -> user.getLateFee();
        //If user has books out
        if(hasBooks.test(user)){
            //For each book check how many days they've been out and then...
            for(Book book: user.getCheckedOutBooks()){
                //Set that to days out
                int daysOut = checkDays.apply(book);
                //If it's been out for more than 2 weeks
                if(daysOut > 14){
                    //Set late fees
                    setOverdueRate.accept(daysOut);
                    //Calculate days overdue
                    daysOut -= 14;
                    System.out.println("The book is " + daysOut + " days overdue.");
                    System.out.println("The late fee is currently " + user.getLateFee() + " per day.");
                    //Lat fee == days overdue * the previously set fee rate
                    daysOut *= feeCalc.get();
                    //Add it to total late fees
                    lateFee += daysOut;
                }
            }
        }
        //return total late fees
        return lateFee;
    }
    @Override
    public String toString() {
        String bookCatalog = "";
        for(Book book: bookList){
            bookCatalog += book.toString() + "\n";
        }
        return bookCatalog;
    }
}
