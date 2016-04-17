package com.computerstore.factories.components;

/**
 * Created by Aidem on 2016/04/17.
 */

import org.junit.Test;
import com.computerstore.factories.components.MainboardFactory;
import com.computerstore.domain.components.Mainboard;
import junit.framework.Assert;

public class MainboardTest {

    private MainboardFactory factory;

    @Test
    public void testMainboardCreation() throws Exception {
        Mainboard mainboard = factory.createMainboard("MB-AS-X99-A",50,"ASUS X99-A",5299.00);
        Assert.assertEquals(mainboard.getDescription(),"ASUS X99-A");
        Assert.assertEquals(mainboard.getProductNumber(),"MB-AS-X99-A");
        Assert.assertNotNull(mainboard.getId());
    }

    @Test
    public void testMainboardUpdate() throws Exception {
        Mainboard mainboard = factory.createMainboard("MB-AS-X99-A",50,"ASUS X99-A",5299.00);
        Assert.assertEquals(mainboard.getDescription(),"ASUS X99-A");
        Assert.assertEquals(mainboard.getProductNumber(),"MB-AS-X99-A");
        Assert.assertNotNull(mainboard.getId());

        // Updated Description

        Mainboard updateMainboard = new Mainboard.Builder()
                .Mainboard(mainboard)
                .price(5699.00)
                .build();

        Assert.assertEquals(updateMainboard.getPrice(),5699.00);
        Assert.assertEquals(mainboard.getProductNumber(),updateMainboard.getProductNumber());
        Assert.assertEquals(mainboard.getId(),updateMainboard.getId());




    }
}

