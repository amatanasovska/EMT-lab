package mk.ukim.finki.emtlab.model;

import lombok.Data;
import mk.ukim.finki.emtlab.model.idclass.BookId;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@IdClass(BookId.class)
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bookId;


    @ManyToOne
    @PrimaryKeyJoinColumn(name="booktype_id", referencedColumnName="id")
    @Id
    BookType bookType;

    boolean isTaken;
    public Book() {
        this.isTaken = false;
    }

    public Book(Long bookId, BookType bookType) {
        this.bookId = bookId;
        this.bookType = bookType;
        this.isTaken = false;
    }

    public Book(BookType bookType, boolean isTaken) {
        this.bookType = bookType;
        this.isTaken = isTaken;
    }

    public Book(BookType bookType) {
        this.bookType = bookType;
        this.isTaken = false;
    }
//    @PrePersist
//    public void logNewBookAttempt() {
//        System.out.println("Attempt to add book.");
//    }

//    @PostPersist
//    public void logNewUserAdded() {
//        log.info("Adding new book with type: " + bookType.getName());
//    }
//
//    @PreRemove
//    public void logUserRemovalAttempt() {
//        log.info("Attempting to delete book with type: " + bookType.getName());
//    }
//
//    @PostRemove
//    public void logUserRemoval() {
//        log.info("Deleted book: " + bookType.getName());
//    }
//
//    @PreUpdate
//    public void logUserUpdateAttempt() {
//        log.info("Attempting to update book with type: " + bookType.getName());
//    }
//
//    @PostUpdate
//    public void logUserUpdate() {
//        log.info("Updated book: " + bookType.getName());
//    }
}
