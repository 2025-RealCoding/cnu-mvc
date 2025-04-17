package cnu.mvc.domain.book;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostConstruct
    public void init() {
        bookService.save(new Book("title1","author1",3));
        bookService.save(new Book("title2","author2",4));
        bookService.save(new Book("title3","author3",2));
        bookService.save(new Book("title4","author4",4));
    }
    // 도서 목록
    @GetMapping()
    public String books(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/books";
    }
    // 도서 등록 폼
    @GetMapping("/register")
    public String registerForm() {
        return "book/registerBookForm";
    }
    // 도서 등록 -> 도서 상세 반환
    @PostMapping("/register")
    public String registerBook(Book book) {
        bookService.save(book);
        return "book/book";
    }
}
