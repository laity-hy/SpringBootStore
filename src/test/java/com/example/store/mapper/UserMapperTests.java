package com.example.store.mapper;

import com.example.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123456852");
        Integer ros = userMapper.insert(user);
        System.out.println(ros);
    }

    @Test
    public void findByUsername() {
        User tim = userMapper.findByUsername("tim");
        System.out.println(tim);
    }

    @Test
    public void updatePasswordByUid() {
        userMapper.updatePasswordByUid(1, "12345678", "管理员", new Date());
    }


    @Test
    public void findByUid() {
        System.out.println(userMapper.findByUid(1));
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(12);
        user.setPhone("19958129387");
        user.setEmail("1810638451@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid() {
        Integer rows = userMapper.updateAvatarByUid(12, "/upload/avatar.png", "管理员", new Date());
        System.out.println(rows);
    }
}
