package org.example.bookapp;

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
import model.thevolumesdb.VolumeResult;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import services.BookAPIService;


import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){

        /*Εδω πλεον φτιαχνουμε το app μας που για καθε case καλειτε συγκεκριμενες μεθοδοι απο το αλλο project "GB"
        το οποιο το <<εχουμε φερει εδω>> δημιουργοντας ενα jar αρχειο και μεσα απο εκει εχουμε βρει
        τα dependencies και τα εχουμε βαλει εδω σε αυτο το pom.xml του συγκεκριμενου project
         */

        final BookAPIService bookDBService = BookAPI.getBookDBService();

         System.out.println("Καλώς ήρθες στο Book App μας");
         Boolean x=true;


         //Θα μπαινει συνεχεια στην loopa μας μεχρι να πατησει το 6 και το x απο true να γινει false και να τερματισει το App
         while(x){
             System.out.println("Διάλεξε μια επιλογή πατώντας έναν αριθμό");
             System.out.println("1-> Επέλεξε βιβλίο με βάση κάποιο χαρακτηριστικό");
             System.out.println("2-> Επέλεξε VolumeInfo");
             System.out.println("3-> Επέλεξε BookShelve");
             System.out.println("4-> Επέλεξε BookShelf");
             System.out.println("5-> Επέλεξε BookshelveVolume");
             System.out.println("6-> Έξοδος");

             Scanner sc = new Scanner(System.in);
             String input=sc.nextLine();

             System.out.println("Η επιλογή σου είναι η: " +input);
             switch (input){
                 case "1":
                     System.out.println("Επέλεξες 1, δηλαδή για βιβλίο");
                     System.out.println("Δώσε λατινικό γράμμα για κρητήριο αναζήτησης βιβλίου:");
                     System.out.println("A-> Αναζήτηση βάση τίτλου");
                     System.out.println("B-> Αναζήτηση βάση ηθοποιού");
                     System.out.println("C-> Αναζήτηση βάση εκδότη");
                     System.out.println("D-> Αναζήτηση βάση θέματος");
                     System.out.println("E-> Αναζήτηση βάση ISBN");

                     String input2=sc.nextLine();
                     if (Objects.equals(input2, "A")) {

                             System.out.println("Επέλεξες Α, δηλαδή τίτλο");
                             System.out.println("Δώσε τίτλο ταινίας:");

                             //Σε αυτο το σημειο διαβαζει μια τιμη απο τον χρηστη και δημιουργει ενα αντικειμενο τυπου λιστα του BookInfo, ωπου περναει τα αποτελεσματα που παιρνει απο την μεθοδο searchForBooks
                             try {
                                 final String title = sc.nextLine();
                                 List<BookInfo> results;
                                 results = bookDBService.searchForBooks(title);
                                 System.out.println(results);
                             } catch (BookAPIException e) {
                                 System.out.println("Έδωσες λάθος τιμή");
                             }
                     }
                     if (Objects.equals(input2, "B")) {

                             System.out.println("Επέλεξες B, δηλαδή ηθοποιό");
                             System.out.println("Δώσε ηθοποιό ταινίας:");

                             try {
                                 final String author = sc.nextLine();
                                 List<BookInfo> results = bookDBService.searchForBooks(author);
                                 System.out.println(results);
                             } catch (BookAPIException e) {
                                 System.out.println("Έδωσες λάθος τιμή");
                             }

                     }
                     if (Objects.equals(input2, "C")) {

                             System.out.println("Επέλεξες C, δηλαδή εκδότη");
                             System.out.println("Δώσε εκδότη ταινίας:");

                             try {
                                 final String publisher = sc.nextLine();
                                 List<BookInfo> results;
                                 results = bookDBService.searchForBooks(publisher);
                                 System.out.println(results);
                             } catch (BookAPIException e) {
                                 System.out.println("Έδωσες λάθος τιμή");
                             }

                     }
                     if (Objects.equals(input2, "D")) {

                             System.out.println("Επέλεξες D, δηλαδή θέμα");
                             System.out.println("Δώσε θέμα ταινίας:");

                             try {
                                 final String publisher = sc.nextLine();
                                 List<BookInfo> results;
                                 results = bookDBService.searchForBooks(publisher);
                                 System.out.println(results);
                             } catch (BookAPIException e) {
                                 System.out.println("Έδωσες λάθος τιμή");
                             }

                     }
                     if (Objects.equals(input2, "E")) {

                             System.out.println("Επέλεξες E, δηλαδή ISBN");
                             System.out.println("Δώσε ISBN ταινίας:");
                             try {
                                 final String publisher = sc.nextLine();
                                 List<BookInfo> results;
                                 results = bookDBService.searchForBooks(publisher);
                                 System.out.println(results);
                             } catch (BookAPIException e) {
                                 System.out.println("Έδωσες λάθος τιμή");
                             }

                     }
                     break;


                 case "2":
                     /*
                     Σε αυτη την περιπτωση οπως και στο case 4 το εχω κανει διαφορετικα εχω φερει εδω την κληση και το print των results του API
                     */
                     System.out.println("Επέλεξες 4, δηλαδή τα BookShelf");
                     DefaultHttpClient httpCl = new DefaultHttpClient();
                     try {

                         HttpGet getRequest = new HttpGet("https://www.googleapis.com/books/v1/volumes/KRzGndH1JZIC");
                         getRequest.addHeader("accept","application/json");

                         HttpResponse response = httpCl.execute(getRequest);

                         VolumeResult v=null;
                         ObjectMapper mapper = new ObjectMapper();
                         mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

                         v=mapper.readValue(response.getEntity().getContent(),VolumeResult.class);
                         System.out.println(v.toString());


                     }
                     catch (JsonMappingException e){
                         System.out.println("json mapping");
                         e.printStackTrace();
                     }
                     catch (ClientProtocolException e){
                         System.out.println("client exception");
                         e.printStackTrace();
                     }
                     catch (IOException e){
                         System.out.println("IO Exception");
                         e.printStackTrace();
                     }

                     break;
                 case "3":
                     System.out.println("Επέλεξες 3, δηλαδή τα BookShelves");
                     try{
                         List<BookshelvesInfo> results;
                         results = bookDBService.searchForBookshelves();
                         System.out.println(results);
                     }catch (BookAPIException e){
                         System.out.println("Έδωσες λάθος τιμή");
                     }
                     break;
                 case "4":

                     System.out.println("Επέλεξες 4, δηλαδή τα BookShelf");
                     DefaultHttpClient httpClient = new DefaultHttpClient();
                     try {

                         HttpGet getRequest = new HttpGet("https://www.googleapis.com/books/v1/users/108364080949372785094/bookshelves/0");
                         getRequest.addHeader("accept","application/json");

                         HttpResponse response = httpClient.execute(getRequest);

                         BookshelfResult b=null;
                         ObjectMapper mapper = new ObjectMapper();
                         mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

                         b=mapper.readValue(response.getEntity().getContent(),BookshelfResult.class);
                         System.out.println(b.toString());


                     }
                     catch (JsonMappingException e){
                         System.out.println("json mapping");
                         e.printStackTrace();
                     }
                     catch (ClientProtocolException e){
                         System.out.println("client exception");
                         e.printStackTrace();
                     }
                     catch (IOException e){
                         System.out.println("IO Exception");
                         e.printStackTrace();
                     }

                     break;
                 case "5":
                     System.out.println("Επέλεξες 5, δηλαδή τα BookShelveVolume");
                     try{
                         List<BookshelfVolumeInfo> results;
                         results = bookDBService.searchForBookshelfVolume();
                         System.out.println(results);
                     }catch (BookAPIException e){
                         System.out.println("Έδωσες λάθος τιμή");
                     }
                     break;
                 case "6":
                     x=false;
                     break;

             }
         }
    }
}
