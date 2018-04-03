import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        String urlString = "http://turing.cs.missouriwestern.edu/classes/textFiles/BaseballTeamsMLB2.xml";
        String xml = readFromURL(urlString);
        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());

        System.out.println(xml);

        String trivia = doc.select("trivia").first().text();
        System.out.println("Trivia: " + trivia);
        String date = doc.select("by").first().attr("date");
        System.out.println("Date: "+date);

        Elements teams = doc.select("team");
        //System.out.println(teams);
        for(Element team : teams){
            String league = team.attr("league");
            String division = team.attr("division");
            String city = team.select("city").text();
            String name = team.select("name").text();
            //Team team  = new Team(name, city, league, division);
            System.out.printf("The %s %s (%s league %s)\n", city, name, league, division);
        }

    }

    public static String readFromURL(String urlString) {
        String data = "";
        try {
            URL url = new URL(urlString);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String s;
            while((s = input.readLine()) !=null){
                data += s;
            }


            input.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
        return data;
    }
}
