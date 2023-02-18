import bookapi.BookAPI;
import bookinfo.BookInfo;
import bookshelfinfo.BookshelfInfo;
import bookshelfvolumeinfo.BookshelfVolumeInfo;
import bookshelvesinfo.BookshelvesInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.BookAPIException;
import model.thebookshelfdb.BookshelfResult;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Test;
import services.BookAPIService;
import volumeinfo.VolInfo;

import java.io.IOException;
import java.util.List;

import java.net.URI;

public class BookAPITest {

    /*Εδώ έχουμε τα unit tests που μας επιτρέπουν να τρέξουμε κάθε μέρος-ερώτημα της εργασίας μας ξεχωριστά δημιουργόντας κάποιες μεθόδους
     */

    //Search
    @Test
    public void testSearchAPI() throws BookAPIException {
        /*Δημιουργούμε μια μεταβλητή τύπου BookAPIService αρχικοποιόντας την με τα αποτελέσματα της getBookDBService δηλαδή τα URL και ΑPI τα οποία εκείνη θα τα περάσει στην BookAPIService
        για να φέρει τα αποτελέσματα του Resst API*/
        final BookAPIService bookSearchService = BookAPI.getBookDBService();
        /*Δημιουργούμε μια λίστα τύπου BookInfo που θα περάσουμε τα αποτελέσματα που έχουμε επιλέξει από το JSON στην BookInfo list για να τα εμφανίσουμε στο επόμενο βήμα
         */
        final List<BookInfo> results = bookSearchService.searchForBooks("Nick");
        Assert.assertFalse(results.isEmpty());
        results.forEach(System.out::println);
    }

    //Volumes
//    @Test
//    public void testVolumeAPI() throws BookAPIException {
//        final BookAPIService bookVolumeService = bookapi.BookAPI.getBookDBService();
//        final List<VolInfo> results = bookVolumeService.searchForVolumes();
//        Assert.assertFalse(results.isEmpty());
//        results.forEach(System.out::println);
//    }


    //Bookshelves
    @Test
    public void testBookshelvesAPI() throws BookAPIException {
        final BookAPIService bookshelvesSearchService = bookapi.BookAPI.getBookshelvesDBService();
        final List<BookshelvesInfo> results = bookshelvesSearchService.searchForBookshelves();
        Assert.assertFalse(results.isEmpty());
        results.forEach(System.out::println);
    }


    //BookshelfVolume
  @Test
  public void testBookshelfVolumeAPI() throws BookAPIException {
      final BookAPIService bookshelfVolumeService = BookAPI.getBookDBService();
      final List<BookshelfVolumeInfo> results = bookshelfVolumeService.searchForBookshelfVolume();
      Assert.assertFalse(results.isEmpty());
      results.forEach(System.out::println);
  }



}