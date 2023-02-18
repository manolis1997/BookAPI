package bookshelfvolumeinfo;

import model.thebookshelfvolumedb.AccessInfo;
import model.thebookshelfvolumedb.Item;
import model.thebookshelfvolumedb.SaleInfo;
import model.thebookshelfvolumedb.VolumeInfo;

public class BookshelfVolumeInfo {
    private final String kind;
    private final String id;
    private final String etag;
    private final String selflink;
    private final VolumeInfo volumeInfo;
    private final SaleInfo saleInfo;
    private final AccessInfo accessInfo;

    public BookshelfVolumeInfo(String kind, String id, String etag, String selflink, VolumeInfo volumeInfo, SaleInfo saleInfo, AccessInfo accessInfo) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selflink = selflink;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
        this.accessInfo = accessInfo;
    }
    public BookshelfVolumeInfo(Item theItem){
        this.kind=theItem.getKind();
        this.id=theItem.getId();
        this.etag=theItem.getEtag();
        this.selflink=theItem.getSelfLink();
        this.volumeInfo=theItem.getVolumeInfo();
        this.saleInfo=theItem.getSaleInfo();
        this.accessInfo=theItem.getAccessInfo();
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

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }
}
