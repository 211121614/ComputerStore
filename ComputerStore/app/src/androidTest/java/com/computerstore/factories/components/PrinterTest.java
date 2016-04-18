package com.computerstore.factories.components;

/**
 * Created by Aidem on 2016/04/17.
 */

import android.test.AndroidTestCase;

import com.computerstore.domain.components.Printer;

import junit.framework.Assert;

import org.junit.Test;

public class PrinterTest extends AndroidTestCase {

    private PrinterFactory factory;

    @Test
    public void testPrinterCreation() throws Exception {
        Printer printer = factory.createPrinter("4103B003",50,"Canon PIXMA iP2700",449.00);
        Assert.assertEquals(printer.getDescription(),"Canon PIXMA iP2700");
        Assert.assertEquals(printer.getProductNumber(),"4103B003");
        Assert.assertNotNull(printer.getId());
    }

    @Test
    public void testPrinterUpdate() throws Exception {
        Printer printer = factory.createPrinter("4103B003",50,"Canon PIXMA iP2700",449.00);
        Assert.assertEquals(printer.getDescription(),"Canon PIXMA iP2700");
        Assert.assertEquals(printer.getProductNumber(),"4103B003");
        Assert.assertNotNull(printer.getId());

        // Updated Description

        Printer updatePrinter = new Printer.Builder()
                .Printer(printer)
                .price(500.00)
                .build();

        Assert.assertEquals(updatePrinter.getPrice(),500.00);
        Assert.assertEquals(printer.getProductNumber(),updatePrinter.getProductNumber());
        Assert.assertEquals(printer.getId(),updatePrinter.getId());




    }
}

