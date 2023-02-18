package volumeinfo;

import model.thevolumesdb.VolumeInfo;

import java.util.List;

public class VolInfo {
    private final String title;
    private final String subtitle;
    private final List<String> authors;
    private final String publisher;
    private final String description;

    public VolInfo() {
        this.title = getTitle();
        this.subtitle = getSubtitle();
        this.authors = getAuthors();
        this.publisher = getPublisher();
        this.description = getDescription();
    }

    public VolInfo(VolumeInfo theVol){
        this.title=theVol.getTitle();
        this.subtitle=theVol.getSubtitle();
        this.authors=theVol.getAuthors();
        this.publisher=theVol.getPublisher();
        this.description=theVol.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }
}
