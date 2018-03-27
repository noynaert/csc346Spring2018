public class Course {
    String courseId;
    String title;

    public Course(String courseId, String title) {
        this.courseId = courseId;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
