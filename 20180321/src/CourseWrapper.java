import javafx.beans.property.SimpleStringProperty;

public class CourseWrapper {
    SimpleStringProperty courseId;
    SimpleStringProperty title;

    public CourseWrapper(String courseId, String title){
        this.courseId = new SimpleStringProperty(courseId);
        this.title = new SimpleStringProperty(title);
    }

    public void setCourseId(String courseId) {
        this.courseId.set(courseId);
    }

    public String getCourseId() {
        return courseId.get();
    }

    public SimpleStringProperty courseIdProperty() {
        return courseId;
    }


    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }


}
