package cnu.mvc.domain.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
