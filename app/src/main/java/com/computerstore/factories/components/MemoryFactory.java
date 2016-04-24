package com.computerstore.factories.components;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.computerstore.domain.components.Memory;
import java.util.UUID;

public class MemoryFactory{

    public static Memory createMemory(String productNumber,int stock, String description,double price) {
        Memory  cpu = new Memory
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
