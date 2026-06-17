package services.book;

import models.Book;

import java.util.List;

public interface BookService {
    // Creat
    String saveBook(Book book);
    // Read
    List<Book> getAllBooks();
    Book getBootById(long id);

    // Update

    // Delete
    void deleteBook(long id);
}
