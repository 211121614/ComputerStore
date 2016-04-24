package com.computerstore.factories.employees;

/**
 * Created by Aidem on 2016/04/17.
 */

import com.computerstore.factories.employees.EmployeesFactory;
import com.computerstore.domain.employees.Employees;

import junit.framework.Assert;

import org.junit.Test;

public class EmployeesTest {

    private EmployeesFactory factory;

    @Test
    public void testEmployeesCreation() throws Exception {
        Employees emp = factory.createEmployees(211121614,"Aiden","Page","Casher");
        Assert.assertEquals(emp.getEmpID(),211121614);
        Assert.assertEquals(emp.getEmpName(),"Aiden");
        Assert.assertNotNull(emp.getId());
    }

    @Test
    public void testEmployeesUpdate() throws Exception {
        Employees emp = factory.createEmployees(211121614,"Aiden","Page","Casher");
        Assert.assertEquals(emp.getEmpID(),211121614);
        Assert.assertEquals(emp.getEmpName(),"Aiden");
        Assert.assertNotNull(emp.getId());

        // Updated Description

        Employees updateEmployees = new Employees.Builder()
                .Employees(emp)
                .empSurname("something")
                .build();

        Assert.assertEquals(updateEmployees.getEmpSurname(),"something");
        Assert.assertEquals(emp.getEmpID(),updateEmployees.getEmpID());
        Assert.assertEquals(emp.getId(),updateEmployees.getId());




    }

}
