package bookshelfinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.thebookdb.Item;

public class BookshelfInfo {
    private final String kind;

    private final Integer id;

    private final String title;

    private final String access;

    private final String updated;

    private final String created;

    private final Integer volumeCount;

    private final String volumesLastUpdated;

    public BookshelfInfo(String kind, Integer id, String title, String access, String updated, String created, Integer volumeCount, String volumesLastUpdated) {
        this.kind = kind;
        this.id = id;
        this.title = title;
        this.access = access;
        this.updated = updated;
        this.created = created;
        this.volumeCount = volumeCount;
        this.volumesLastUpdated = volumesLastUpdated;
    }

    public BookshelfInfo(BookshelfInfo theBookShelf){

        this.kind= theBookShelf.getKind();
        this.id=theBookShelf.getId();
        this.title=theBookShelf.getTitle();
        this.access=theBookShelf.getAccess();
        this.updated=theBookShelf.getUpdated();
        this.created=theBookShelf.getCreated();
        this.volumeCount=theBookShelf.getVolumeCount();
        this.volumesLastUpdated=theBookShelf.getVolumesLastUpdated();
    }

    public String getKind() {
        return kind;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAccess() {
        return access;
    }

    public String getUpdated() {
        return updated;
    }

    public String getCreated() {
        return created;
    }

    public Integer getVolumeCount() {
        return volumeCount;
    }

    public String getVolumesLastUpdated() {
        return volumesLastUpdated;
    }
}
