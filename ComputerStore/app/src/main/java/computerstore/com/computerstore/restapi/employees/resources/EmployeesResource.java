package computerstore.com.computerstore.restapi.employees.resources;

/**
 * Created by Aidem on 2016/04/17.
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Aidem
 */

public class EmployeesResource implements Serializable{

    private int EmpID;
    private String EmpName;
    private String EmpSurname;
    private String EmpJob;

    public int getEmpID() {
        return EmpID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public String getEmpSurname() {
        return EmpSurname;
    }

    public String getEmpJob() {
        return EmpJob;
    }

    private EmployeesResource(){

    }

    private EmployeesResource(Builder builder)
    {
        this.EmpID = builder.EmpID;
        this.EmpName = builder.EmpName;
        this.EmpSurname = builder.EmpSurname;
        this.EmpJob = builder.EmpJob;
    }

    public static class Builder
    {
        private int EmpID;
        private String EmpName;
        private String EmpSurname;
        private String EmpJob;

        public Builder empID(int EmpID) {
            this.EmpID = EmpID;
            return this;
        }

        public Builder empName(String EmpName) {
            this.EmpName = EmpName;
            return this;
        }

        public Builder empSurname(String EmpSurname) {
            this.EmpSurname = EmpSurname;
            return this;
        }

        public Builder empJob(String EmpJob) {
            this.EmpJob = EmpJob;
            return this;
        }

        public Builder Employees (EmployeesResource emp)
        {
            this.EmpID = emp.EmpID;
            this.EmpName = emp.EmpName;
            this.EmpSurname = emp.EmpSurname;
            this.EmpJob = emp.EmpJob;
            return this;
        }

        public EmployeesResource build ()
        {
            return new EmployeesResource(this);
        }


    }

}
