import java.sql.*;

public class Main {
    static Connection conn;
    static ResultSet rs;
    static Statement stmt;
    public static void main(String[] args) {
	    String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
	    String user = "csc254";
	    String password="age126";

	    String queryString = "SELECT city, region, country, latitude, longitude FROM cities where region LIKE 'MO' LIMIT 25";

        try {
            conn = DriverManager.getConnection(host, user, password);
            if(conn == null)
                System.out.println("Connection failed");
            else
                System.out.println("Connection successful!");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();

            System.out.println("Number of columns: " + numberOfColumns);
            for(int i=1;i<=numberOfColumns;i++){
                System.out.printf("Column %2d: %s (%s)\n", i,
                        rsMetaData.getColumnName(i),
                        rsMetaData.getColumnTypeName(i));
            }

            while(rs.next()){
                String country = rs.getString("country");
                String name = rs.getString("city");
                String region = rs.getString("region");
                double lat = rs.getDouble("latitude");
                double lon = rs.getDouble("longitude");
                Place place = new Place(name,region, country,lat,lon);
                System.out.println(place);
            }


            conn.close();
        } catch (SQLException e) {
           // e.printStackTrace();
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}
