package com.computerstore.factories.components;

/**
 * Created by Aidem on 2016/04/17.
 */

import org.junit.Test;
import com.computerstore.factories.components.OpticalDevicesFactory;
import com.computerstore.domain.components.OpticalDevices;
import junit.framework.Assert;

public class OpticalDevicesTest {

    private OpticalDevicesFactory factory;

    @Test
    public void testOpticalDevicesCreation() throws Exception {
        OpticalDevices opticalDevices = factory.createOpticalDevices("GH24LS70",50,"Internal SATA 24x Super-Multi DVD Rewriter",199.00);
        Assert.assertEquals(opticalDevices.getDescription(),"Internal SATA 24x Super-Multi DVD Rewriter");
        Assert.assertEquals(opticalDevices.getProductNumber(),"GH24LS70");
        Assert.assertNotNull(opticalDevices.getId());
    }

    @Test
    public void testOpticalDevicesUpdate() throws Exception {
        OpticalDevices opticalDevices = factory.createOpticalDevices("GH24LS70",50,"Internal SATA 24x Super-Multi DVD Rewriter",199.00);
        Assert.assertEquals(opticalDevices.getDescription(),"Internal SATA 24x Super-Multi DVD Rewriter");
        Assert.assertEquals(opticalDevices.getProductNumber(),"GH24LS70");
        Assert.assertNotNull(opticalDevices.getId());

        // Updated Description

        OpticalDevices updateOpticalDevices = new OpticalDevices.Builder()
                .OpticalDevices(opticalDevices)
                .price(250.00)
                .build();

        Assert.assertEquals(updateOpticalDevices.getPrice(),250.00);
        Assert.assertEquals(opticalDevices.getProductNumber(),updateOpticalDevices.getProductNumber());
        Assert.assertEquals(opticalDevices.getId(),updateOpticalDevices.getId());




    }

}
