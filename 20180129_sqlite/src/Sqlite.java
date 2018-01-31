import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {
    static Connection conn;

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


    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
