package com.example.store.controller;

import com.example.store.entity.User;
import com.example.store.service.IUserService;
import com.example.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/register")
    public JsonResult<Void> register(User user) {
        userService.register(user);
        return new JsonResult<>(OK);
    }


    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        //向session对象中完成数据的绑定（session全局的）
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        User data = userService.getByUid(uid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(HttpSession session, User user) {
        //user对象有四部分的数据：username/phone/email/gender
        //uid数据再次封装到user对象中
        userService.changeInfo(getUidFromSession(session), getUsernameFromSession(session), user);
        return new JsonResult<>(OK);
    }
}
