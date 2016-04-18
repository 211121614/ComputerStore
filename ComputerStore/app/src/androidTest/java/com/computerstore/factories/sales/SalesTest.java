package com.computerstore.factories.sales;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.test.AndroidTestCase;

import com.computerstore.domain.sales.Sales;

import junit.framework.Assert;

import org.junit.Test;

public class SalesTest extends AndroidTestCase {

    private SalesFactory factory;

    @Test
    public void testSalesCreation() throws Exception {
        Sales sales = factory.createSales("cs12345",211121614,"2016/04/03",5000.00,100.00);
        Assert.assertEquals(sales.getSalesId(),"cs12345");
        Assert.assertEquals(sales.getEmpID(),211121614);
        Assert.assertNotNull(sales.getId());
    }

    @Test
    public void testSalesUpdate() throws Exception {
        Sales sales = factory.createSales("cs12345",211121614,"2016/04/03",5000.00, 100.00);
        Assert.assertEquals(sales.getSalesId(),"cs12345");
        Assert.assertEquals(sales.getEmpID(),211121614);
        Assert.assertNotNull(sales.getId());

        // Updated Description

        Sales updateSales = new Sales.Builder()
                .Sales(sales)
                .totalSales(4000.00)
                .build();

        Assert.assertEquals(updateSales.getTotalSales(),4000.00);
        Assert.assertEquals(sales.getSalesId(),updateSales.getSalesId());
        Assert.assertEquals(sales.getId(),updateSales.getId());




    }

}

