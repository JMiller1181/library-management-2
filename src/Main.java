public class Main {
    public static void main(String[] args){
        Book book = new Book("A Book", "Jacob", 2023, 204, "Fantasy");
        Book book1 = new Book("Big Book", "Jocob", 2022, 345, "Non-Fiction");
        Book book2 = new Book("Cook Book", "Jocob", 2023, 400, "Cooking");
        Book book3 = new Book("A small Book", "Jacob", 2022, 123, "Non-Fiction");
        Library library = new Library();
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        //Print the library
//        System.out.println(library);
        //Get books by year
//        System.out.println(library.getBookByYear(2023));
        //Get books by author
//        System.out.println(library.getBookByAuthor("Jacob"));
        //Get book with the most pages
//        System.out.println(library.getBookWithMostPages());
        //Get books with more than X pages
//        System.out.println(library.getBooksWithPages(200));
        //Get titles in alphabetical order
//        System.out.println(library.getAlphabeticalBookList());
        //Get books by category
//        System.out.println(library.getBooksByCategory("Non-Fiction"));
        //Check to see if book is onLoan
//        System.out.println(library);
//        System.out.println(library);
        //System to monitor checked out books

    }
}
