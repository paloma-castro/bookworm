package santander.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import santander.bookstore.domain.Book;

public interface BookRepository extends JpaRepository <Book,Long> {
    Page<Book> findAllByActive(Pageable pageable, boolean active);
    Page<Book> findByAuthorContaining(Pageable pageable, String author);
    Page<Book> findByGenreContaining(Pageable pageable, String genre);
}
