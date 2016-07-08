package test;

import java.util.Date;

/**
 * Created by Андрей on 07.07.2016.
 */
public class Employee {
    private int idEmployee;
    private String FIO;
    private Date birthday;
    private String email;
    private int yearOfBirth;
    private int idDepartment;

    public Employee(String FIO, Date birthday, String email, int yearOfBirth, int idDepartment) {
        this.FIO = FIO;
        this.birthday = birthday;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        this.idDepartment = idDepartment;
    }
    public Employee(int idEmployee, String FIO, Date birthday, String email, int yearOfBirth, int idDepartment) {
        this.idEmployee = idEmployee;
        this.FIO = FIO;
        this.birthday = birthday;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        this.idDepartment = idDepartment;
    }

    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getFIO() {
        return FIO;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public int getIdDepartment() {
        return idDepartment;
    }
    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FIO='" + FIO + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", idDepartment=" + idDepartment +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return email.equals(employee.email);

    }
    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
