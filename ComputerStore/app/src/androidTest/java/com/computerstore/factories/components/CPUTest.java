package com.computerstore.factories.components;

/**
 * Created by Aidem on 2016/04/17.
 */


import android.test.AndroidTestCase;

import com.computerstore.domain.components.CPU;

import junit.framework.Assert;

import org.junit.Test;


public class CPUTest  extends AndroidTestCase {
    private CPUFactory factory;

    @Test
    public void testCPUCreation() throws Exception {
        CPU cpu = factory.createCPU("i7-6820HQ",50,"INTEL CORE I5 4690K - 3.50GHZ QUAD CORE",3899.00);
        Assert.assertEquals(cpu.getDescription(),"INTEL CORE I5 4690K - 3.50GHZ QUAD CORE");
        Assert.assertEquals(cpu.getProductNumber(),"i7-6820HQ");
        Assert.assertNotNull(cpu.getId());
    }

    @Test
    public void testCPUUpdate() throws Exception {
        CPU cpu = factory.createCPU("i7-6820HQ",50,"INTEL CORE I5 4690K - 3.50GHZ QUAD CORE",3899.00);
        Assert.assertEquals(cpu.getDescription(),"INTEL CORE I5 4690K - 3.50GHZ QUAD CORE");
        Assert.assertEquals(cpu.getProductNumber(),"i7-6820HQ");
        Assert.assertNotNull(cpu.getId());

        // Updated Description

        CPU updateCPU = new CPU.Builder()
                .CPU(cpu)
                .price(4000.00)
                .build();

        Assert.assertEquals(updateCPU.getPrice(),4000.00);
        Assert.assertEquals(cpu.getProductNumber(),updateCPU.getProductNumber());
        Assert.assertEquals(cpu.getId(),updateCPU.getId());
    }

}
