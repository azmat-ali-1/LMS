package Models;

public class Books {
    private String name;
    private String Author;
    private String serialNo;
    private int bookCount;

    public Books(String name, String author, String serialNo, int bookCount) {
        this.name = name;
        this.Author = author;
        this.serialNo = serialNo;
        this.bookCount = bookCount;
    }
    public Books(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
}