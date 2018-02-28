package edu.missouriwestern.noynaert.csc346;

public class Section {
    String department;
    String crn;
    String courseID;
    String discipline;
    String courseNumber;
    //...
    String message;
    String days;
    String time;
    String instructor;
    String beginDate;
    int hours;
    int maximumEnrollment;
    String url;

    public Section() {
        message = "";
        //initialize anything that needs initializing
    }

    @Override
    public String toString() {
        return "Section{" +
                "department='" + department + '\'' +
                ", crn='" + crn + '\'' +
                ", courseID='" + courseID + '\'' +
                ", discipline='" + discipline + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", message='" + message + '\'' +
                ", days='" + days + '\'' +
                ", time='" + time + '\'' +
                ", instructor='" + instructor + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", hours=" + hours +
                ", maximumEnrollment=" + maximumEnrollment +
                ", url='" + url + '\'' +
                '}';
    }
}