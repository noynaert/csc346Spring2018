import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String website = "http://quotes.toscrape.com/";

        try {
            Document doc = Jsoup.connect(website).get();

            String title = doc.title();
            System.out.println("The title is "+ title);

            Elements links = doc.select(".quote a[href]");
            System.out.println(links.get(0));
            for(Element link : links){
                System.out.println("Link:" + link);
                System.out.println("\tthe link: " + link.attr("href"));
                System.out.println("\tthe text: " + link.text());
            }
            Elements quotes = doc.select(".quote");
            System.out.println("Quotes on this page:" + quotes.size());
            for(Element quote: quotes){
                System.out.println("---------------------------------");
                System.out.println(quote);
                String author = quote.select(".author").text();
                System.out.println("\tauthor: " + author);
                String wiseWords = quote.select(".text").text();
                System.out.println("\twise words: " +wiseWords);

                Elements tags = quote.select(".tag");
                for(Element tag : tags){
                    System.out.println("\t\t--"+tag.text());
                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
