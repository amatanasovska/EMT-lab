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
@CrossOrigin(origins = "http://localhost:3000")
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
    public List<BookType> findAll()
    {
        return this.bookTypeService.findAll();
    }
    @GetMapping("/copies")
    public List<Book> findAllCopies()
    {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookTypeDto> findById(@PathVariable Long id) {
        return this.bookTypeService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/copies/{booktype_id}")
    public List<Book> findCopiesByBookType(@PathVariable Long booktype_id)
    {
        return bookService.findByBookTypeId(booktype_id);
    }

    @PostMapping("/copies")
    public ResponseEntity<Book> insertCopy(@RequestBody BookDto bookDto)
    {
        return this.bookService.save(bookDto).map(b -> ResponseEntity.ok().body(b))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping
    public ResponseEntity<BookType> insertBook(@RequestBody BookTypeDto book)
    {
//        System.out.println(book);
        return this.bookTypeService.save(book)
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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id)
    {
        try
        {
            this.bookTypeService.deleteById(id);
            return ResponseEntity.accepted().build();
        }
        catch(RuntimeException e)
        {
            return ResponseEntity.badRequest().build();
        }


    }
    }



