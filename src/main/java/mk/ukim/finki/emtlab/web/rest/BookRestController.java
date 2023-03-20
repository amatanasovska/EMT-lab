package mk.ukim.finki.emtlab.web.rest;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.dto.BookTypeDto;
import mk.ukim.finki.emtlab.model.exceptions.BookAlreadyTakenException;
import mk.ukim.finki.emtlab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emtlab.service.BookService;
import mk.ukim.finki.emtlab.service.BookTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/book")
public class BookRestController {
    private final BookService bookService;
    private final BookTypeService bookTypeService;

//    private final Book

    public BookRestController(BookService bookService, BookTypeService bookTypeService) {
        this.bookService = bookService;
        this.bookTypeService = bookTypeService;
    }

    @GetMapping
    public List<Book> findAll()
    {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> insertBook(@RequestBody BookDto book)
    {
        return this.bookService.save(book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<BookType> edit(@PathVariable Long id, @RequestBody BookTypeDto bookTypeDto)
    {
        return this.bookTypeService.edit(id,bookTypeDto)
                .map(bookType -> ResponseEntity.ok().body(bookType))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/take/{book_type_id}/{id}")
    public ResponseEntity<Book> takeBook(@PathVariable Long book_type_id,@PathVariable Long id) throws BookAlreadyTakenException, BookNotFoundException {
        return this.bookService.takeBook(book_type_id, id)
                .map(bookType -> ResponseEntity.ok().body(bookType))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }



}
