public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    public Book (String title, String author, int publicationYear, int pages, String category){
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.category = category;
        this.isOnLoan = false;
    }

    public String getCategory(){
        return category;
    }
    public String getTitle(){
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getAuthor() {
        return author;
    }
    public void setOnLoan(){
        if(!isOnLoan){
            isOnLoan = true;
        } else {
            System.out.println("Book already checked out, cannot loan out " + title);
        }
    }
    public void setOffLoan(){
        isOnLoan = false;
    }
    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Year published: " + publicationYear + "\n" +
                "Pages: " + pages + "\n" +
                "Category: " + category + "\n" +
                "Loaned out: " + isOnLoan;
    }
}
