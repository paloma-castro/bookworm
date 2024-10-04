package santander.bookstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import santander.bookstore.domain.Book;

public interface BookService {
    ResponseEntity<Page<Book>> findAllBooks(Pageable pageable);
    Book findById(Long id);
    ResponseEntity<Page<Book>> findByAuthor(Pageable pageable, String author);
    ResponseEntity<Page<Book>> findByGenre(Pageable pageable, String genre);
}
