package cnu.core.Book;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String author;
    private int quantity;
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}