package data;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String contact;
    private String email;
    private String joiningDate;
    private String salary;

    // View for the Manager
    public Employee(int id, String name, String department, String email,String contact, String joiningDate, String salary) {
        this.contact = contact;
        this.joiningDate = joiningDate;
        this.department = department;
        this.email = email;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    //view for the Employee
    public Employee(int id, String name, String department, String email,String contact) {
        this.contact = contact;
        this.department = department;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name:-" +name+
                "Id:-" + id + '\'' +
                " Deaptment:- " + department +
                "Email:- " + email+ '\'' +
                "Contact:- '" + contact + '\'' +
                "JoiningDate:- " + joiningDate + '\'' +
                ", Salary:- " + salary ;
    }
}
