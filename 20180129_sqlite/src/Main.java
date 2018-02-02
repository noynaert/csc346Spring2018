import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
       Sqlite db = new Sqlite();
       if(db.makeConnection("stocks.db")){
           System.out.println("Opened Successfully");
           String queryString = "Select * from symbols where symbol LIKE 'A%'";
           ArrayList<Stock> list = db.query(queryString);
           if(list == null){
               System.out.println("The query failed.");
           }else{
               print(list);
           }
           Stock stk = new Stock("ZZZ", "ZZ Zop", 25.0);
           db.insert(stk);

           db.close();
       }else{
           System.out.println("Database did not open");
       }
    }
    static <T> void print(ArrayList<T> list){
        System.out.println("-------------------");
        for(T t : list){
            System.out.println(t);
        }
        System.out.printf("----Printed %d entries\n\n", list.size());
    }
}
