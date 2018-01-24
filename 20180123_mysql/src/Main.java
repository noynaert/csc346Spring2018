import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	    String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
	    String user = "csc254";
	    String password="age126";

	    Connection conn;
	    Statement st;
	    ResultSet rs;

        try {
            conn = DriverManager.getConnection(host, user, password);
            String queryString = "SELECT * from zips";
            st = (Statement) conn.createStatement();
            st.execute(queryString);
            //rs = st.getResultSet();
            rs = st.executeQuery(queryString);

            while(rs.next()){
                System.out.print(rs.getString("zip_code"));
                System.out.print(" "+ rs.getString("city"));
                System.out.println(" "+ rs.getDouble("lat"));
            }


            conn.close();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Oops.  Failed to connect to " + host);
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}
