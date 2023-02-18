package bookinfo;

import model.thebookdb.BookResult;
import model.thebookdb.Item;
import model.thebookdb.VolumeInfo;

public class BookInfo {

    //Αυτη εδω η κλαση μας και ολες οι κλασεις που εχω φτιαξει που τελειωνουν σε info ειναι το τι θα εμφανιζει καθε κλαση συνδεομενη με το Json που παιρνουμε
    private final String kind;
    private final String id;
    private final String etag;
    private final String selflink;
    private final VolumeInfo volume;

    public BookInfo(String kind, String id, String etag, String selflink, VolumeInfo volume) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selflink = selflink;
        this.volume = volume;
    }

    //Εδω φτιαχνουμε εναν δευτερο constractor ο οποιος παιρνει σαν παραμετρο ενα αντικειμενο τυπου Item και αρχικοποιει τις τιμες τους βαση των get μεθοδων που εχει αυτο το αντικειμενο
    public BookInfo(Item theItem){

        this.kind= theItem.getKind();
        this.id=theItem.getId();
        this.etag=theItem.getEtag();
        this.selflink=theItem.getSelfLink();
        this.volume=theItem.getVolumeInfo();
    }

    public String getKind() {

        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelflink() {
        return selflink;
    }

    public VolumeInfo getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", selflink='" + selflink + '\'' +
                ", volume=" + volume +
                '}';
    }
}
