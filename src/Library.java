import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> bookList;
    public Library (){
        bookList = new ArrayList<>();
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

        System.out.println("User " + user.getName() + " now registered.");
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
