package santander.bookstore.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import santander.bookstore.domain.Book;
import santander.bookstore.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;



    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllBooks() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Book> listBooks = Arrays.asList(new Book("Title1", "Author1", "Genre1"), new Book("Title2", "Author2", "Genre2"));
        Page<Book> bookPage = new PageImpl<>(listBooks, pageable, listBooks.size());

        when(bookRepository.findAllByActive(pageable,true)) .thenReturn(bookPage);

        ResponseEntity<Page<Book>> result = bookService.findAllBooks(pageable);
        assertEquals(bookPage, result.getBody());
    }


    @Test
    void testFindById() {
        Book book = new Book("A", "B", "C");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book foundBook = bookService.findById(1L);
        assertEquals(book, foundBook);
    }

    @Test
    void testFindByAuthor() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Book> listBooks = Arrays.asList(new Book("A", "Author Name", "C"));
        Page<Book> bookPage = new PageImpl<>(listBooks, pageable, listBooks.size());

        when(bookRepository.findByAuthorContaining(pageable, "Author Name")).thenReturn(bookPage);

        ResponseEntity<Page<Book>> booksByAuthor = bookService.findByAuthor(pageable, "Author Name");
        assertEquals(bookPage, booksByAuthor.getBody());
    }

    @Test
    void testFindByGenre() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Book> listBooks = Arrays.asList(new Book("A", "B", "Genre Name"));
        Page<Book> bookPage = new PageImpl<>(listBooks, pageable, listBooks.size());

        when(bookRepository.findByGenreContaining(pageable, "Genre Name")).thenReturn(bookPage);

        ResponseEntity<Page<Book>> booksByGenre = bookService.findByGenre(pageable, "Genre Name");
        assertEquals(bookPage, booksByGenre.getBody());
    }
}