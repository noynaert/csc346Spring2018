import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args){
        String fileName = "departments.xml";
        List<Department> departments = parseXML(fileName);
        print(departments);

        System.out.println("Done");
    }

    public static List<Department> parseXML(String fileName){
        List<Department> departments = new ArrayList<>();

        //create the factory to create the xmlEventReader we really want.
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            String departmentAbbreviation;
            String departmentName;
            Department department;
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                    new FileInputStream(fileName));

            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                //System.out.println(xmlEvent);
                if (xmlEvent.isStartElement()) {

                    System.out.println("Start Element: " + xmlEvent);
                }
                if (xmlEvent.isEndElement()) {

                    System.out.println("End Element: " + xmlEvent);
                }
            }

            xmlEventReader.close();
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(2);
        }




        return departments;
    }

    public static<T> void print(List<T> list){
        System.out.println("---------------------");
        for(T t:list){
            System.out.println(t);
        }
        System.out.println("---------------------");

    }
}
