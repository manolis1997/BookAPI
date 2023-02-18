package bookshelvesinfo;


public class BookshelvesInfo {
    private final String kind;
    private final Integer id;
    private final String title;
    private final String access;
    private final String updated;
    private final String created;
    private final Integer volumeCount;
    private final String volumesLastUpdated;


    public BookshelvesInfo(String kind, Integer id, String title, String access, String updated, String created, Integer volumeCount, String volumesLastUpdated) {
        this.kind = kind;
        this.id = id;
        this.title = title;
        this.access = access;
        this.updated = updated;
        this.created = created;
        this.volumeCount = volumeCount;
        this.volumesLastUpdated = volumesLastUpdated;
    }

    public BookshelvesInfo(model.thebookshelvesdb.Item theItem){
        this.kind=theItem.getKind();
        this.id=theItem.getId();
        this.title=theItem.getTitle();
        this.access=theItem.getAccess();
        this.updated=theItem.getUpdated();
        this.created=theItem.getCreated();
        this.volumeCount=theItem.getVolumeCount();
        this.volumesLastUpdated=theItem.getVolumesLastUpdated();

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

    @Override
    public String toString() {
        return "BookshelvesInfo{" +
                "kind='" + kind + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", access='" + access + '\'' +
                ", updated='" + updated + '\'' +
                ", created='" + created + '\'' +
                ", volumeCount=" + volumeCount +
                ", volumesLastUpdated='" + volumesLastUpdated + '\'' +
                '}';
    }
}
