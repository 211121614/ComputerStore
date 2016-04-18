package com.computerstore.factories.sales;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.test.AndroidTestCase;

import com.computerstore.domain.sales.SalesComponents;

import junit.framework.Assert;

import org.junit.Test;

public class SalesComponentsTest extends AndroidTestCase {

    private SalesComponentsFactory factory;

    @Test
    public void testSalesComponentsCreation() throws Exception {
        SalesComponents salesComponents = factory.createSalesComponents("1234","1234",2);
        Assert.assertEquals(salesComponents.getProductNumber(),"1234");
        Assert.assertEquals(salesComponents.getSaleID(),"1234");
        Assert.assertNotNull(salesComponents.getId());
    }

    @Test
    public void testSalesComponentsUpdate() throws Exception {
        SalesComponents salesComponents = factory.createSalesComponents("1234","1234",2);
        Assert.assertEquals(salesComponents.getProductNumber(),"1234");
        Assert.assertEquals(salesComponents.getSaleID(),"1234");
        Assert.assertNotNull(salesComponents.getId());

        // Updated Description

        SalesComponents updateSalesComponents = new SalesComponents.Builder()
                .SalesComponents(salesComponents)
                .amount(1)
                .build();

        Assert.assertEquals(updateSalesComponents.getAmount(),1);
        Assert.assertEquals(salesComponents.getProductNumber(),updateSalesComponents.getProductNumber());
        Assert.assertEquals(salesComponents.getSaleID(),updateSalesComponents.getSaleID());
        Assert.assertEquals(salesComponents.getId(),updateSalesComponents.getId());




    }
}

