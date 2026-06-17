package services.reader;

import db.Database;
import exceptions.NotFoundException;
import models.Library;
import models.Reader;

import java.util.List;

public class ReaderServiceImpl implements ReaderService{
    private Database database;

    public ReaderServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void saveReader(Reader reader) {
        database.getReaders().add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return database.getReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : database.getReaders()) {
            if (reader.getId() == id){
                return reader;
            }
        }
        throw new NotFoundException("Reader with id "+ id +" not found");
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader r : database.getReaders()) {
            if (r.getId() == id){
                r.setPhoneNumber(reader.getPhoneNumber());
                r.setEmail(reader.getEmail());
                r.setFullName(reader.getFullName());
                return r;
            }
        }
        throw new NotFoundException("Reader with id: "+id+" not found");
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader r = null;
        for (Reader reader : database.getReaders()) {
            if(reader.getId() == readerId){
                r = reader;
            }
        }

        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId){
                library.getReaders().add(r);
            }
        }
    }
}
