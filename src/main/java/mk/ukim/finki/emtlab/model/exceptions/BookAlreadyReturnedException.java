package mk.ukim.finki.emtlab.model.exceptions;

public class BookAlreadyReturnedException extends RuntimeException {
    public BookAlreadyReturnedException(Long book_type_id, Long id) {
        super("Book with book type id " + book_type_id + " and id " + id + " is already returned.");
    }
}