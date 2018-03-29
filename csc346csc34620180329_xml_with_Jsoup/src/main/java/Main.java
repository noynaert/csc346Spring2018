import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String xmlString = readFromFile("baseball.xml");
        System.out.println("XML as a string: " + xmlString);

        //Parse the string
        Document doc = Jsoup.parse(xmlString,"", Parser.xmlParser());

        Elements teams = doc.select("team");
        Elements source = doc.select("created");
        System.out.printf("There are %d teams and %d source(s)\n",
                teams.size(), source.size());

        Element whence = source.first();
        Element oneTeam = teams.first();

        System.out.println("The first team is " + oneTeam.text());
        System.out.println("The first team is in the city of " + oneTeam.attr("city"));

        for(Element team : teams){
            String city;
            String name;
            name = team.text();
            city = team.attr("city");
            // Team t = new Team(city, name);
            System.out.printf("The %s %s\n", city, name);
        }
        System.out.println("FROM A URL");

        System.out.println("+--------------------------+");
        System.out.println("+ Data provided by:        +");
        System.out.println("+ https://erikberg.com/api +");
        System.out.println("+                          +");
        System.out.println("+--------------------------+");
        xmlString = readFromURL("https://erikberg.com/nba/standings.xml");

        System.out.println("Done");
    }
    public static String readFromFile(String fileName){
        String xml = "";
        try {
            Scanner input = new Scanner(new File(fileName));
            while(input.hasNextLine())
                xml += input.nextLine();

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(2);
        }


        return xml;
    }
    public static String readFromURL(String urlString){
        String data = "";
        try {
            URL  url = new URL(urlString);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader( url.openStream())
            );

            input.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(3);
            e.printStackTrace();
        }


        return data;
    }
}
