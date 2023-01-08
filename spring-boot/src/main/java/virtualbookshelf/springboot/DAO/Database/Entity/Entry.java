package virtualbookshelf.springboot.DAO.Database.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Virtual_Shelf")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EntryType entryType;

    private String title;
    private String author;

    public Entry(Long id, EntryType entryType, String title, String author) {
        this.id = id;
        this.entryType = entryType;
        this.title = title;
        this.author = author;
    }

    public Entry(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntryType getType() {
        return entryType;
    }

    public void setType(EntryType entryType) {
        this.entryType = entryType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", type=" + entryType +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
