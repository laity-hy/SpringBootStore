package com.example.store.mapper;

import com.example.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {
    @Resource
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(12);
        address.setPhone("123456789");
        address.setName("女朋友");
        Integer result = addressMapper.insert(address);
        System.out.println(result);
    }

    @Test
    public void countByUid() {
        Integer result = addressMapper.countByUid(12);
        System.out.println(result);
    }
}
