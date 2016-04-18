package com.computerstore.factories.employees;

/**
 * Created by Aidem on 2016/04/17.
 */

import com.computerstore.domain.employees.Employees;
import java.util.UUID;

public class EmployeesFactory {

    public static Employees createEmployees(int empID, String empName, String empSurname, String empJob) {
        Employees  emp = new Employees
                .Builder()
                .id(UUID.randomUUID().toString())
                .empID(empID)
                .empName(empName)
                .empSurname(empSurname)
                .empJob(empJob)
                .build();
        return emp;
    }

}
