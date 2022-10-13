package com.example.store.service;

import com.example.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Resource
    private IAddressService addressService;

    @Test
    public void insert() {
        Address address = new Address();
        address.setPhone("123456789");
        address.setName("男朋友");
        addressService.addNewAddress(12, "管理员", address);
    }
}
