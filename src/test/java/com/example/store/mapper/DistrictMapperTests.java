package com.example.store.mapper;

import com.example.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {
    @Resource
    private DistrictMapper districtMapper;

    @Test
    public void findByParent() {
        String parent = "110100";
        List<District> list = districtMapper.findByParent(parent);
        System.out.println("count = " + list.size());
        for (District district : list) {
            System.out.println(district);
        }
    }

    @Test
    public void findNameByCode() {
        String code = "540000";
        String name = districtMapper.findNameByCode(code);
        System.out.println(name);
    }
}
