package sample;

public class Employee {
        public Integer Employee_id;
        public String FirstName;
        public String LastName;
        public String Address;
        public Double Salary;

    public Employee(Integer Employee_id, String FirstName, String LastName, String Address, Double Salary) {
        this.Employee_id=Employee_id;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Address=Address;
        this.Salary=Salary;
    }

    public Integer getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        Employee_id = employee_id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        Salary = Salary;
    }
}