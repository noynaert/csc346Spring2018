import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        try {
            //usingGet("https://webservices.missouriwestern.edu/users/noynaert/csc346/target.php?firstName=tommy&car=truck");
            usingPost("https://webservices.missouriwestern.edu/users/noynaert/csc346/target.php?firstName=tommy&car=truck");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
    public static void usingGet(String website) throws IOException {
        Document doc = Jsoup.connect(website).get();
        System.out.println(doc);
    }
    public static void usingPost(String website) throws IOException{
        Connection.Response response = Jsoup.connect(website)
                .method(Connection.Method.POST)
                .timeout(10 * 1000)
                .data("firstName","Sally")
                .data("favoriteMovie","Titanic")
                .data("course_number","")
                .followRedirects(true)
                .execute();
        System.out.println("Connected");
        System.out.println(response.body());

    }
}
