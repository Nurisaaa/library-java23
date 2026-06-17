package services.library;

import models.Library;

import java.util.List;

public interface LibraryService {
    void saveLibrary(Library library);
    List<Library> getAllLibraries();
    Library getLibraryById(long id);
    void deleteLibrary(long id);
}
