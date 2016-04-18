package com.computerstore.factories.components;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.test.AndroidTestCase;

import com.computerstore.domain.components.Monitor;

import junit.framework.Assert;

import org.junit.Test;

public class MonitorTest extends AndroidTestCase {

    private MonitorFactory factory;

    @Test
    public void testMonitorCreation() throws Exception {
        Monitor monitor = factory.createMonitor("23MP55HQ-P",50,"LG 23MP55HQ-P Widescreen LCD",6117.95);
        Assert.assertEquals(monitor.getDescription(),"LG 23MP55HQ-P Widescreen LCD");
        Assert.assertEquals(monitor.getProductNumber(),"23MP55HQ-P");
        Assert.assertNotNull(monitor.getId());
    }

    @Test
    public void testMonitorUpdate() throws Exception {
        Monitor monitor = factory.createMonitor("23MP55HQ-P",50,"LG 23MP55HQ-P Widescreen LCD",6117.95);
        Assert.assertEquals(monitor.getDescription(),"LG 23MP55HQ-P Widescreen LCD");
        Assert.assertEquals(monitor.getProductNumber(),"23MP55HQ-P");
        Assert.assertNotNull(monitor.getId());

        // Updated Description

        Monitor updateMonitor = new Monitor.Builder()
                .Monitor(monitor)
                .price(7200.00)
                .build();

        Assert.assertEquals(updateMonitor.getPrice(),7200.00);
        Assert.assertEquals(monitor.getProductNumber(),updateMonitor.getProductNumber());
        Assert.assertEquals(monitor.getId(),updateMonitor.getId());




    }

}

