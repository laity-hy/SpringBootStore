package com.example.store.controller;

import com.example.store.controller.exception.*;
import com.example.store.service.exception.*;
import com.example.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制层类的基类
 */
public class BaseController {
    /**
     * 操作成功的状态码
     */
    public static final int OK = 200;

    //请求处理方法，这个方法的返回值就是需要传递给前端的数据
    //自动将异常对象传递给此方法的参数列表上
    //当项目中产生了异常，被统一拦截到此方法中，这个方法的返回值直接给到前端
    @ExceptionHandler({ServiceException.class, FileUploadException.class}) //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {     //4000异常
            result.setState(4000);
            result.setMessage("用户名被占用的异常");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户名的密码错误的异常");
        } else if (e instanceof InsertException) {          //5000异常
            result.setState(5000);
            result.setMessage("插入数据时产生未知的异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        } else if (e instanceof FileEmptyException) {       //6000异常
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     *
     * @param session session对象
     * @return 当前登陆的用户uid的值
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取当前登陆用户的username
     *
     * @param session session对象
     * @return 当前登陆用户的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
