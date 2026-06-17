package services.library;

import db.Database;
import exceptions.NotFoundException;
import models.Library;

import java.util.List;

public class LibraryServiceImpl implements LibraryService{
    private Database database;

    public LibraryServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveLibrary(Library library) {
        database.setLibraries(library);
    }

    @Override
    public List<Library> getAllLibraries() {
        return database.getLibraries();
    }

    @Override
    public Library getLibraryById(long id) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == id){
                return library;
            }
        }
        throw new NotFoundException("library with id: "+id +" not found");
    }

    @Override
    public void deleteLibrary(long id) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == id){
                database.getLibraries().remove(library);
            }
        }
    }
}
