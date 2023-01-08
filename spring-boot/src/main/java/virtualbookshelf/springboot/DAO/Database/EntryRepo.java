package virtualbookshelf.springboot.DAO.Database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import virtualbookshelf.springboot.DAO.Database.Entity.Entry;
import virtualbookshelf.springboot.DAO.Database.Entity.EntryType;

import java.util.List;

@Repository
public interface EntryRepo extends CrudRepository<Entry, Long> {

    List<Entry> findAllByEntryType(EntryType entryType);

    List<Entry> findAllByAuthor (String author);

    List<Entry> findAllByTitle (String title);
}
