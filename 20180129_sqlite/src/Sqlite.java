import java.sql.*;
import java.util.ArrayList;

public class Sqlite {
    Connection conn;

    public boolean makeConnection(String fileName){
        boolean successfullyOpened = false;

        String connectString = "jdbc:sqlite:" + fileName;
        try {
            conn = DriverManager.getConnection(connectString);
            if(conn!=null)
                successfullyOpened = true;
        } catch (SQLException e) {
            e.printStackTrace();
            successfullyOpened = false;
        }

        return successfullyOpened;
    }

    public ArrayList<Stock> query(String queryString){
        ArrayList<Stock> stocks = null;

        Statement stmt;
        ResultSet rs;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryString);
            stocks = new ArrayList<>();
            while (rs.next()) {
                String symbol = rs.getString("symbol");
                String name = rs.getString("name");
                double closing = rs.getDouble("closingPrice");

                Stock stk = new Stock(symbol, name, closing);
                stocks.add(stk);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    void insert(Stock stk){
        try {
            Statement stmt = conn.createStatement();
            String queryString = String.format
                    ("INSERT INTO symbols(symbol, name, closingPrice) VALUES('%s', '%s', '%f');",
                       stk.symbol, stk.name, stk.closingPrice
                    );
            //System.out.println(queryString);
            stmt.executeUpdate(queryString);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
