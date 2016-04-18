package com.computerstore.factories.components;

/**
 * Created by Aidem on 2016/04/17.
 */

import com.computerstore.domain.components.CPU;
import java.util.UUID;

public class CPUFactory {

    public static CPU createCPU(String productNumber,int stock, String description,double price) {
        CPU  cpu = new CPU
                .Builder()
                .id(UUID.randomUUID().toString())
                .productNumber(productNumber)
                .stock(stock)
                .description(description)
                .price(price)
                .build();
        return cpu;
    }
}
