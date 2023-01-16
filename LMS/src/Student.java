public class Student {
    private String name;
    private String EnrolmentId;
    private String Branch;
    private int numberOfBookIssue;

    public Student(String name, String enrolment, String branch,int count) {
        this.name = name;
        this.EnrolmentId = enrolment;
        this.Branch = branch;
        this.numberOfBookIssue = count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrolment() {
        return EnrolmentId;
    }

    public void setEnrolment(String enrolment) {
        EnrolmentId = enrolment;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public int getNumberOfBookIssue() {
        return numberOfBookIssue;
    }

    public void setNumberOfBookIssue(int numberOfBookIssue) {
        this.numberOfBookIssue = numberOfBookIssue;
    }
}