package virtualbookshelf.springboot.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import virtualbookshelf.springboot.DAO.Database.Entity.Entry;
import virtualbookshelf.springboot.Managers.EntryManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/myshelf")
@CrossOrigin
public class EntryApi {

    private EntryManager myShelf;

    @Autowired
    public EntryApi(EntryManager entryManager){
        this.myShelf = entryManager;
    }

    @GetMapping("/all")
    public Iterable<Entry> getAll(){
        return myShelf.findAllEntries();
    }

    @GetMapping
    public Optional<Entry> getById(@RequestParam Long index){
        return myShelf.findById(index);
    }

    @PostMapping
    public Entry addEntry(@RequestBody Entry entry){
        return myShelf.addEntry(entry);
    }

    @PutMapping
    public Entry updateEntry(@RequestBody Entry entry){
        return myShelf.addEntry(entry);
    }

    @DeleteMapping
    public void deleteEntry(@RequestParam Long index){
        myShelf.deleteById(index);
    }

}
