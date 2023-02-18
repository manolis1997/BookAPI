package bookapi;

import services.BookAPIService;

public class BookAPI {

    /*Εδώ δημιουργούνται μέθοδοι τύπου BookAPIService για να περάσει τα ορίσματα URL και API για κάθε ερώτημα ξεχωριστά (μερικές δεν χρησιμοποιούνται γιατί έχει γίνει
    διαφορετικά η υλοποίηση τους*/
    public static BookAPIService getBookDBService() {
        // API key needed. Register and generate API KEY
        return new BookAPIService("https://www.googleapis.com/books/v1/volumes?q=search", "AIzaSyAL4tMBL2An2pG0i3ev2mB8dZ2GQ-B74h8");
    }

    public static BookAPIService getVolumeDBService(){
        // API key needed. Register and generate API KEY
        return new BookAPIService("https://www.googleapis.com/books/v1/volumes/", "AIzaSyAL4tMBL2An2pG0i3ev2mB8dZ2GQ-B74h8");
    }
   public static BookAPIService getBookshelvesDBService(){
       // API key needed. Register and generate API KEY
       return new BookAPIService("https://www.googleapis.com/books/v1/users/", "AIzaSyAL4tMBL2An2pG0i3ev2mB8dZ2GQ-B74h8");
   }

    public static BookAPIService getBookshelfVolumeDBService(){
        // API key needed. Register and generate API KEY
        return new BookAPIService("https://www.googleapis.com/books/v1/users/", "AIzaSyAL4tMBL2An2pG0i3ev2mB8dZ2GQ-B74h8");
    }

}
