package santander.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import santander.bookstore.domain.Book;
import santander.bookstore.exceptions.NotFoundException;
import santander.bookstore.repository.BookRepository;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService
{

    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable("book")
    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            return book;
        } else {
            throw new NotFoundException("Id " + id +" does not exist.");
        }
    }

    @Cacheable("author")
    @Override
    public ResponseEntity<Page<Book>> findByAuthor(Pageable pageable, String author) {
        Page<Book> bookPage = bookRepository.findByAuthorContaining(pageable, author);
            return ResponseEntity.ok(bookPage);
    }

    @Cacheable("genre")
    @Override
    public ResponseEntity<Page<Book>> findByGenre(Pageable pageable, String genre) {
        Page<Book> bookPage = bookRepository.findByGenreContaining(pageable, genre);
        return ResponseEntity.ok(bookPage);
    }

    @Cacheable("books")
    @Override
    public ResponseEntity<Page<Book>> findAllBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAllByActive(pageable, true);
        return ResponseEntity.ok(books);
    }


}
