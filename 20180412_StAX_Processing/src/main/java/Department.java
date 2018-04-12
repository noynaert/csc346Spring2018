public class Department {
    String abbreviation;
    String departmentName;

    public Department(String abbreviation, String departmentName) {
        this.abbreviation = abbreviation;
        this.departmentName = departmentName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "abbreviation='" + abbreviation + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
