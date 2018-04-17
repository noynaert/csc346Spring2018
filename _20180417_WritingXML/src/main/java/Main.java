import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static List<Section> allSections;

    public static void main(String[] args) {
        String inputFileName = "courses.txt";
        String outputFileName = "courses.xml";

        try {
            allSections = getSections(inputFileName);

            //print(allSections);

            getXML(allSections,outputFileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static void getXML(List<Section> allSections, String outputFileName) throws IOException, XMLStreamException {

       XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(
                new FileWriter(outputFileName)
        );

        //Start the document
        writer.writeStartDocument();
        writer.writeStartElement("courses"); //root

        /*
        //hard-coding one section
        writer.writeStartElement("section");
           writer.writeStartElement("courseId");
           writer.writeAttribute("crn", "12345");
           writer.writeCharacters("CSC184");  //inner text
           writer.writeEndElement();
           writer.writeEndElement(); //section
        */
        for(Section sec: allSections){
            writer.writeStartElement("section");

            writer.writeStartElement("courseId");
            writer.writeAttribute("crn", sec.getCrn());
            writer.writeCharacters(sec.getCourseID());
            writer.writeEndElement();

            writer.writeStartElement("title");
            writer.writeCharacters(sec.getTitle());
            writer.writeEndElement();

            writer.writeStartElement("instructor");
            writer.writeCharacters(sec.getInstructor());
            writer.writeEndElement();

            writer.writeEndElement();//Section
        }
        //Wrap it up!
        writer.writeEndElement(); //root "courses"
        writer.writeEndDocument();

        writer.flush();
        writer.close();

    }

    public static <T> void print(List<T> list) {
        System.out.println("----------------------");
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static List<Section> getSections(String inputFileName) throws FileNotFoundException {
        ArrayList<Section> allSections = new ArrayList<>();

        Scanner input = new Scanner(new File(inputFileName));
        String line = input.nextLine();  //Throw away the header;
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] parts = line.split("\t");
            if (parts.length == 5) {
                allSections.add(new Section(parts[0], parts[3],
                        parts[2], parts[4]));
            }
        }
        input.close();

        return allSections;
    }
}

class Section {
    private String courseID;
    private String title;
    private String crn;
    private String instructor;

    public Section(String courseID, String title, String crn, String instructor) {
        this.courseID = courseID;
        this.title = title;
        this.crn = crn;
        this.instructor = instructor;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return
                "courseID='" + courseID + '\'' +
                        ", title='" + title + '\'' +
                        ", crn='" + crn + '\'' +
                        ", instructor='" + instructor + '\''  ;
    }
}
