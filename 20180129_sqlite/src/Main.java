public class Main {

    public static void main(String[] args) {
       Sqlite db = new Sqlite();
       if(db.makeConnection("stocks.db")){
           System.out.println("Opened Successfully");
           db.close();
       }else{
           System.out.println("Database did not open");
       }
    }
}
