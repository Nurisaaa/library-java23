package services.book;

import db.Database;
import exceptions.NotFoundException;
import models.Book;

import java.util.List;

public class BookServiceImpl implements BookService{
    private Database database;

    public BookServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public String  saveBook(Book book) {
        database.getBooks().add(book);
        return "saved";
    }

    @Override
    public List<Book> getAllBooks() {
        return database.getBooks();
    }

    @Override
    public Book getBootById(long id) {
        for (Book book : database.getBooks()) {
            if (book.getId() == id){
                return book;
            }
        }
        throw new NotFoundException("Book with id: "+id+" not found");
    }

    @Override
    public void deleteBook(long id) {
        for (Book book : database.getBooks()) {
            if (book.getId() == id){
                database.getBooks().remove(book);
                return;
            }
        }
        throw new NotFoundException("Book with id: "+id+" not found");
    }
}
