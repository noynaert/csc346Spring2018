import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseModel {
    static ArrayList<CourseWrapper> list = new ArrayList<>();
    public static ArrayList<CourseWrapper> getArrayList(){
        if(list==null || list.size()==0){
            buildList("courses.txt");
        }

        return list;
    }
    private static int buildList(String fileName){
        int n = 0;
        try {
            Scanner input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                String parts[] = line.split("\\|");
                if(parts.length==2)
                    list.add(new CourseWrapper(parts[0], parts[1]));
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return n;
    }
}
