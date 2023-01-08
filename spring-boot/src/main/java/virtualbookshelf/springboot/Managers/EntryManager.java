package virtualbookshelf.springboot.Managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import virtualbookshelf.springboot.DAO.Database.Entity.Entry;
import virtualbookshelf.springboot.DAO.Database.Entity.EntryType;
import virtualbookshelf.springboot.DAO.Database.EntryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EntryManager {

    private EntryRepo entryRepo;

    @Autowired
    public EntryManager(EntryRepo entryRepo){
        this.entryRepo = entryRepo;
    }

    public Optional<Entry>findById(Long id){
        return entryRepo.findById(id);
    }

    public Entry addEntry(Entry entry) {
        return entryRepo.save(entry);
    }

    public void deleteById(Long id){
         entryRepo.deleteById(id);
    }

    public Iterable<Entry> findAllEntries(){
        return entryRepo.findAll();
    }

    public List<Entry> findAllByEntryType(EntryType entryType){
        return entryRepo.findAllByEntryType(entryType);
    }

    public List<Entry> findAllByAuthor (String author){
        return entryRepo.findAllByAuthor(author);
    }

    public List<Entry> findAllByTitle (String title){
        return entryRepo.findAllByTitle(title);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase(){
        addEntry(new Entry(1L, EntryType.BOOK, "Lord of the Rings", "J.R.R. Tolkien"));
        addEntry(new Entry(2L, EntryType.GAME, "The Witcher: Wild hunt", "CD Projekt RED"));
    }

}
