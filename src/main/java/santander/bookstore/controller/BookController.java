package santander.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import santander.bookstore.domain.Book;
import santander.bookstore.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public ResponseEntity<Page<Book>> findAllBooks(@PageableDefault(size = 10) Pageable pageable){
        return bookService.findAllBooks(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<Page<Book>> findByGenre(@PageableDefault(size = 10) Pageable pageable, @PathVariable String genre){
        return bookService.findByGenre(pageable, genre);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Page<Book>> findByAuthor(@PageableDefault(size = 10) Pageable pageable,@PathVariable String author){
        return bookService.findByAuthor(pageable, author);
    }



}
