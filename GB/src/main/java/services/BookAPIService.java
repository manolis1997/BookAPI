package services;

import bookinfo.BookInfo;
import bookshelfvolumeinfo.BookshelfVolumeInfo;
import bookshelvesinfo.BookshelvesInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.BookAPIException;
import model.thebookdb.BookResult;
import model.thebookdb.Item;
import model.thebookshelfvolumedb.BookshelfVolumeResult;
import model.thebookshelvesdb.BookshelveResult;
import model.thevolumesdb.VolumeResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import errorresponse.ErrorResponse;
import volumeinfo.VolInfo;

public class BookAPIService {

    /*
    Εδω για καθε ερωτημα περναμε το URL και το API για να μπορουμε να τα διαχειριστουμε
     */
    private final String API_URL;
    private final String API_KEY;

    //Κανουμε την αρχικοποιηση τους με τον constructor μας
    public BookAPIService(String aPI_URL, String aPI_KEY) {
        API_URL = aPI_URL;
        API_KEY = aPI_KEY;
    }


    /*
    Δημιουργουμε μια μεθοδο τυπου List<BookInfo> πέρνοντας το όρισμα από την JUNIT μεθοδο και θα μας επιστρεψει μια λιστα με τα ορισματα που εχουμε βαλει στην κλαση BookInfo
     */
    //BookInfo-------------------------------------------------------------------------------------------------------------------------------------------
    public List<BookInfo> searchForBooks(String par) throws BookAPIException {
        //Βαζουμε στην μεταβλητη result που ειναι τυπου BookResult το αποτελεσμα της getAPIData για να το βαλει μετα στην λιστα
        BookResult result = getAPIData(par,API_URL, API_KEY);
        List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
        //Φτιάχνουμε μια loopa όσα ειναι τα Item που μας φέρνει το αποτέλεσμα μας κάνοντας το add στην λιστα μας τυπου BookInfo
        for (Item theItem : result.getItems()) {
            bookInfoList.add(new BookInfo(theItem));
        }

        return bookInfoList;

    }
    //BookInfo
    private BookResult getAPIData(String par,String API_URL, String API_KEY) throws BookAPIException {
        try {
            //Με την συνάρτηση URIBuilder χτιζουμε το url μας βαζοντας και τις παραμετρους
            final URIBuilder uriBuilder = new URIBuilder(API_URL).addParameter("api_key", API_KEY);
            if (par != null){
                uriBuilder.addParameter("+q:", par);
            }
            //Παιρνει την τελικη μορφη το url
            final URI uri = uriBuilder.build();

            //Κανουμε την κληση get βαζοντας πλεον το url μας
            final HttpGet getRequest = new HttpGet(uri);
            //Αυτη η εντολη ειναι σαν να εχω ανοιξει το postman
            final CloseableHttpClient httpclient = HttpClients.createDefault();

            //Το command μεσα στο try αντιπροσωπευει την διαδικασια του παταω το κουμπι του postman για να παρω την απαντηση του απο αιτημα που του εστειλα
            try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
                //Με την παρακατω εντολη παιρνω το αποτελεσμα που θελω δηλαδη το JSON χωρις τα metadata που το περιλαμβανουν
                final HttpEntity entity = response.getEntity();
                final ObjectMapper mapper = new ObjectMapper();

                /*Με το IF εδω ελεγχουμε το status που θα παρουμε απο την κληση μας. Αν ειναι 200 τοτε ειναι ολα ενταξει αλλιως εχουμε προβλημα
                και φυσικα μετα πρεπει να εμφανισω το αποτελεσμα της αποτυχημενης κλησης με τον ιδιο τροπο που κανω αν εχω επιτυχημενη κληση*/
                if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
                    if (errorResponse.getStatusMessage() != null)
                        throw new BookAPIException("Error occurred on API call: " + errorResponse.getStatusMessage());
                }

                //Εδω μας επιστρεφεται το JSON response του API (την function readValue την βαζω γιατι κανω αποσειριοποιηση JSON σε JAVA) ως αποτελεσμα βαση του BookResult(BookResult.class)
                return mapper.readValue(entity.getContent(), BookResult.class);
            } catch (IOException e) {
                throw new BookAPIException("Error requesting data from the TheBookDB API.", e);
            }
        } catch (URISyntaxException e) {
            throw new BookAPIException("Unable to create request URI.", e);
        }
    }


    //Bookshelves---------------------------------------------------------------------------------------------------------------------------------------------------------
public List<BookshelvesInfo> searchForBookshelves() throws BookAPIException {
    BookshelveResult result = getapiData(API_URL, API_KEY);
    List<BookshelvesInfo> bookshelvesInfoList = new ArrayList<>(result.getItems().size());
    for (model.thebookshelvesdb.Item theItem : result.getItems()) {
        bookshelvesInfoList.add(new BookshelvesInfo(theItem));
    }

    return bookshelvesInfoList;

}

//Bookshelves
private BookshelveResult getapiData(String API_URL, String API_KEY) throws BookAPIException {
    try {
        //String baseurl="https://www.googleapis.com/books/v1/users/";
        //String s1=userid;
        //String s2="bookshelves";
//
        //String totalurl= baseurl+s1+"/"+s2;
        //final URI uri = new URI(totalurl);


        final URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("www.googleapis.com").setPath("/books/v1/users/102701940585560677579/bookshelves").addParameter("api_key", API_KEY);


        final URI uri = uriBuilder.build().toURL().toURI();

        final HttpGet getRequest = new HttpGet(uri);
        final CloseableHttpClient httpclient = HttpClients.createDefault();

        try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
            final HttpEntity entity = response.getEntity();
            final ObjectMapper mapper = new ObjectMapper();

            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
                if (errorResponse.getStatusMessage() != null)
                    throw new BookAPIException("Error occurred on API call: " + errorResponse.getStatusMessage());
            }

            return mapper.readValue(entity.getContent(), BookshelveResult.class);
        } catch (IOException e) {
            throw new BookAPIException("Error requesting data from the TheBookshelvesDB API.", e);
        }
    } catch (URISyntaxException e) {
        throw new BookAPIException("Unable to create request URI.", e);
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    }
}


//BookshelfVolume--------------------------------------------------------------------------------------------------------------------------------

   public List<BookshelfVolumeInfo> searchForBookshelfVolume() throws BookAPIException {
       BookshelfVolumeResult result = getData(API_URL, API_KEY);
       List<BookshelfVolumeInfo> bookshelfvolumeInfoList = new ArrayList<>(result.getItems().size());
       for (model.thebookshelfvolumedb.Item theItem : result.getItems()) {
           bookshelfvolumeInfoList.add(new BookshelfVolumeInfo(theItem));
       }

       return bookshelfvolumeInfoList;

   }
   private BookshelfVolumeResult getData(String API_URL, String API_KEY) throws BookAPIException {
       try {

           final URIBuilder uriBuilder = new URIBuilder();
           uriBuilder.setScheme("https").setHost("www.googleapis.com").setPath("/books/v1/users/102701940585560677579/bookshelves/1001/volumes").addParameter("api_key", API_KEY);

           final URI uri = uriBuilder.build();

           final HttpGet getRequest = new HttpGet(uri);
           final CloseableHttpClient httpclient = HttpClients.createDefault();

           try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
               final HttpEntity entity = response.getEntity();
               final ObjectMapper mapper = new ObjectMapper();

               if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                   ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
                   if (errorResponse.getStatusMessage() != null)
                       throw new BookAPIException("Error occurred on API call: " + errorResponse.getStatusMessage());
               }

               return mapper.readValue(entity.getContent(), BookshelfVolumeResult.class);
           } catch (IOException e) {
               throw new BookAPIException("Error requesting data from the TheBookDB API.", e);
           }
       } catch (URISyntaxException e) {
           throw new BookAPIException("Unable to create request URI.", e);
       }
   }


}
