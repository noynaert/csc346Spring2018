import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseModel {
    ArrayList<Course> list = new ArrayList<>();
    public ArrayList<Course> getArrayList(){
        return list;
    }
    public int buildList(String fileName){
        int n = 0;
        try {
            Scanner input = new Scanner(new File(fileName));
            while(input.hasNextLine()){
                String line = input.nextLine().trim();
                String parts[] = line.split("|");
                if(parts.length==2)
                    list.add(new Course(parts[0], parts[1]));
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return n;
    }
}
