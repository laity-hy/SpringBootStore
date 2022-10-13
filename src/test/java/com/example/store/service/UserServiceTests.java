package com.example.store.service;

import com.example.store.entity.User;
import com.example.store.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Resource
    private IUserService userService;

    @Test
    public void register() {
        try {
            User user = new User();
            user.setUsername("test");
            user.setPassword("123456789");
            userService.register(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            //获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User user = userService.login("laityzzzz1", "123456789");
        System.out.println(user);
    }

    @Test
    public void changePassword() {
        userService.changePassword(12, "管理员", "12345678", "123456789");
    }

    @Test
    public void getByUid() {
        User result = userService.getByUid(12);
        System.out.println(result);
    }

    @Test
    public void changeInfo() {
        User user = new User();

        user.setPhone("15673711635");
        user.setEmail("1810638451@qq.com");
        user.setGender(0);
        userService.changeInfo(12, "管理员", user);
    }

    @Test
    public void changeAvatar() {
        userService.changeAvatar(12, "/upload/test.png", "管理员");
    }
}
