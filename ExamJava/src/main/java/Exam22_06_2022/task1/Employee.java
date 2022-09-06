package Exam22_06_2022.task1;

/**
 * Entity сотрудника
 */
public class Employee {

    private String firstName;

    private String secondName;

    private String lastName;

    private int experience;

    private String positionCode;

    private String jobTitle;

    public Employee() {
    }

    public Employee(String firstName, String secondName, String lastName, int experience, String positionCode) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.experience = experience;
        this.positionCode = positionCode;
    }

    public Employee(String firstName, String secondName, String lastName, int experience, String positionCode, String jobTitle) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.experience = experience;
        this.positionCode = positionCode;
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + lastName + " " + jobTitle + " " + experience;
    }
}
