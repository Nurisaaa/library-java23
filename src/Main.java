import db.Database;
import exceptions.NotFoundException;
import models.*;
import services.book.BookService;
import services.book.BookServiceImpl;
import services.library.LibraryService;
import services.library.LibraryServiceImpl;
import services.reader.ReaderService;
import services.reader.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Database database = new Database(
                List.of(
                        new Library(1L, "Alykul Osmonov", "Abdyrahmanova"),
                        new Library(34L, "Alykul Osmonov", "Abdyrahmanova"),
                        new Library(56L, "Alykul Osmonov", "Abdyrahmanova"),
                        new Library(12L, "Alykul Osmonov", "Abdyrahmanova")
                ),
                List.of(
                        new Reader(1L, "Nurayim Toktonalieva", "n@gmail.com", "0999787878",Gender.FEMALE),
                        new Reader(4L, "Nurayim Toktonalieva", "n@gmail.com", "0999787878",Gender.FEMALE),
                        new Reader(2L, "Nurayim Toktonalieva", "n@gmail.com", "0999787878",Gender.FEMALE),
                        new Reader(7L, "Nurayim Toktonalieva", "n@gmail.com", "0999787878",Gender.FEMALE)

                ),
                List.of(
                        new Book(1L, "Kylym karytar bir kun", "Chyngyz Aitmatov", Gengre.ROMAN),
                        new Book(2L, "Kylym karytar bir kun", "Chyngyz Aitmatov", Gengre.ROMAN),
                        new Book(3L, "Kylym karytar bir kun", "Chyngyz Aitmatov", Gengre.ROMAN),
                        new Book(4L, "Kylym karytar bir kun", "Chyngyz Aitmatov", Gengre.ROMAN),
                        new Book(5L, "Kylym karytar bir kun", "Chyngyz Aitmatov", Gengre.ROMAN)
                )
        );

        try {
            LibraryService libraryService = new LibraryServiceImpl(database);
            libraryService.saveLibrary(new Library(42L, "Baialinov", "Abdyrahmanova"));
            libraryService.deleteLibrary(1L);
            System.out.println(libraryService.getAllLibraries());
            System.out.println(libraryService.getLibraryById(42L));

            BookService bookService = new BookServiceImpl(database);
            bookService.saveBook(new Book(2L, "Toolor kulaganda", "Chyngyz Aitmatov", Gengre.ROMAN));
            bookService.deleteBook(1L);
            System.out.println(bookService.getBootById(34L));
            System.out.println(bookService.getAllBooks());

            ReaderService readerService = new ReaderServiceImpl(database);
            readerService.saveReader( new Reader(7L, "Nurayim Toktonalieva", "n@gmail.com", "0999787878",Gender.FEMALE));
            System.out.println(readerService.getAllReaders());
            System.out.println(readerService.getReaderById(7L));
            readerService.updateReader(4L, new Reader(7L, "Kutbidin ", "k@gmail.com", "0999999999",Gender.MALE));
            readerService.assignReaderToLibrary(7L, 12L);

        }catch (NotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}