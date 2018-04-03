public class WeatherMain {
    public static void main(String[] args) {
        String url = Credentials.getUrl();
        System.out.println("URL: "+ url);
        System.out.println("Table: " + Credentials.getTable());
        System.out.println("Done.");

    }
}
