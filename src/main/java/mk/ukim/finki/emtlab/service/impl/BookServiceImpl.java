package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.exceptions.*;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.repository.BookTypeRepository;
import mk.ukim.finki.emtlab.service.BookService;
import mk.ukim.finki.emtlab.service.BookTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookTypeService bookTypeService;

    public BookServiceImpl(BookRepository bookRepository, BookTypeService bookTypeService) {
        this.bookRepository = bookRepository;
        this.bookTypeService = bookTypeService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto){


            Long bookTypeId = bookDto.getBookType();
            Boolean isTaken = bookDto.isTaken();
//            if(name==null) throw new NonNullableFieldException("name");

            BookType bookType = bookTypeService.find(bookTypeId).orElseThrow(()->new BookTypeNotFoundException(bookTypeId));
            Book book = bookRepository.save(new Book(bookType,isTaken));

            bookTypeService.updateAvailableCopies();

            return bookRepository.findByBookId(book.getBookId());
    }

    @Override
    public Optional<Book> takeBook(Long book_type_id, Long id) {

            Book book = bookRepository.findByBookIdAndBookType_Id(id,book_type_id)
                    .orElseThrow(()->new BookNotFoundException(book_type_id,id));
            if (book.isTaken())
                throw new BookAlreadyTakenException(book_type_id, id);
            book.setTaken(true);
            bookRepository.save(book);
            bookTypeService.updateAvailableCopies();

            return Optional.of(book);



    }
    @Override
    public Optional<Book> returnBook(Long book_type_id, Long id) {

        Book book = bookRepository.findByBookIdAndBookType_Id(id,book_type_id)
                .orElseThrow(()->new BookNotFoundException(book_type_id,id));
        if (!book.isTaken())
            throw new BookAlreadyReturnedException(book_type_id, id);
        book.setTaken(false);
        bookRepository.save(book);
        bookTypeService.updateAvailableCopies();

        return Optional.of(book);



    }
    @Override
    public List<Book> findByBookTypeId(Long id) {
        return bookRepository.findAllByBookType_Id(id);
    }

    @Override
    public void deleteByBookIdAndBookType(Long Id, Long bookTypeId) {
        BookType bt = bookTypeService.find(bookTypeId).orElseThrow(()->new BookTypeNotFoundException(bookTypeId));
        System.out.println(bt);
        Book b = bookRepository.findByBookIdAndBookType_Id(Id,bookTypeId).orElseThrow(()->new BookNotFoundException(Id, bookTypeId));
        System.out.println(b);
        bookRepository.delete(b);

        bookTypeService.updateAvailableCopies();
    }


}
