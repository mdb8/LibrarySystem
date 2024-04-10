public class Book {
    public String bookname;
    public String bookauthor;
    public String isbn;
    public boolean isAvailable = true;

    public Book(String bookname, String bookauthor, String isbn){
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.isbn = isbn;
    }
}
