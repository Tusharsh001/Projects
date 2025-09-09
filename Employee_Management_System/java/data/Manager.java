package data;

public class Manager {
    private int id;
    private String Name;
    private String department;
    private String email;
    private String PhoneNumber;
    public Manager(int id, String name, String department, String email, String phoneNumber) {
        this.department = department;
        this.email = email;
        this.id = id;
        Name = name;
        PhoneNumber = phoneNumber;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "department='" + department + '\'' +
                ", id=" + id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
