/**
 * The Book class is meant to store information regarding books,
 * specifically title, author, and the year it was published in
 */
public class Book {
    // fields to store basic book info
    public String title;
    public String author;
    public int yearPublished;
    /**
     * constructor for a new Book object with data for the fields
     * @param title Book's title
     * @param author Book's author
     * @param yearPublished Year in which the book was first published 
     */
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    /**
     *  retrieves the title
     * 
     * @return Book's title
     */
    public String getTitle() {
        return title;
    }
    /** 
     * retrieves the author
     * 
     * @return Book's author
    */
    public String getAuthor() {
        return author;
    } 
    /**
     * retrieves the year it was published in
     * @return Book's publishing year
     */
    public int getYearPublished() {
        return yearPublished;
    }
    /**
     * sets the new title of the book
     * 
     * @param title new title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * sets the new author of the book
     * 
     * @param author new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * sets the new year it was published in
     * @param yearPublished new publishing year
     */
    public void setyearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
 
}
