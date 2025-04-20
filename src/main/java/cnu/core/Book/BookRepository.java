package cnu.core.Book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private static final Map<Long, Book> store = new HashMap<>();
    private static long sequence = 0L;

    public Book save(Book book) {
        book.setId(++sequence);
        store.put(book.getId(), book);
        return book;
    }
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }
    public Book findById(Long id) {
        return store.get(id);
    }
}