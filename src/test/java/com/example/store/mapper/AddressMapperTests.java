package com.example.store.mapper;

import com.example.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    @Test
    public void findByUid() {
        List<Address> result = addressMapper.findByUid(12);
        for (Address address : result) {
            System.out.println(address);
        }
    }

    @Test
    public void updateNonDefaultByUid() {
        Integer rows = addressMapper.updateNonDefaultByUid(12);
        System.out.println(rows);
    }

    @Test
    public void updateDefaultByAid() {
        Integer rows = addressMapper.updateDefaultByAid(1, "管理员", new Date());
        System.out.println(rows);
    }

    @Test
    public void findByAid() {
        Address result = addressMapper.findByAid(1);
        System.out.println(result);
    }

    @Test
    public void deleteByAid() {
        Integer rows = addressMapper.deleteByAid(1);
        System.out.println(rows);
    }

    @Test
    public void findLastModified() {
        Address result = addressMapper.findLastModified(12);
        System.out.println(result);
    }
}
