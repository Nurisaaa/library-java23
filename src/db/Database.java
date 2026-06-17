package db;

import models.Book;
import models.Library;
import models.Reader;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Library> libraries;
    private List<Reader> readers;
    private List<Book> books;

    public Database(List<Library> libraries,
                    List<Reader> readers,
                    List<Book> books) {
        this.libraries = libraries;
        this.readers = readers;
        this.books = books;
    }

    public Database() {
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Library library) {
        if (this.libraries == null){
            this.libraries = new ArrayList<>();
        }
        this.libraries.add(library);
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
