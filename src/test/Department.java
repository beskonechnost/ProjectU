package test;

/**
 * Created by Андрей on 07.07.2016.
 */
public class Department {
    private int idDepartment = 0;
    private String nameDepartment = null;

    public Department(String nameDepartment){
        this.nameDepartment = nameDepartment;
    }
    public Department(int idDepartment, String nameDepartment){
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    public int getIdDepartment() {
        return idDepartment;
    }
    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }
    public String getNameDepartment() {
        return nameDepartment;
    }
    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return nameDepartment.equals(that.nameDepartment);

    }
    @Override
    public int hashCode() {
        return nameDepartment.hashCode();
    }
}
