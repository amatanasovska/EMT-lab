package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.BookType;
import mk.ukim.finki.emtlab.model.idclass.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {
    List<Book> findAll();
    Book save(Book b);
    void deleteByBookIdAndBookType(Long Id, BookType bookType);
    Optional<Book> findByBookId(Long Id);
    Optional<Book> findByBookIdAndBookType_Id(Long Id, Long bookType);
    List<Book> findAllByBookType_Id(Long bookTypeId);

}
