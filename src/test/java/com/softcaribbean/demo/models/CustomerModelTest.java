package com.softcaribbean.demo.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class CustomerModelTest {
    @Autowired
    ApplicationContext context;

    @Autowired
    CustomerModel customerModel;

    @Test
    void customerLoadSuccessful() {
        customerModel = new CustomerModel(
                "Johan"
                , CustomerModel.IdentificationTypes.CC
                , "80111222-0"
                , "Armenia"
                , "Calle 16 # 2-41"
                , "3015552211"
                ,"The client always wants papers bags"
        );
        ReflectionTestUtils.setField(customerModel,"id",1L);

        assertEquals(
                "ID:1 NAME:Johan IDENTIFICATION_TYPE:CC IDENTIFICATION_NUMBER80111222-0 " +
                        "CITY:Armenia ADDRESS:Calle 16 # 2-41 PHONE:3015552211 " +
                        "OBSERVATION:The client always wants papers bags"
                ,customerModel.toString());
    }
}