package com.example.store.service;

import com.example.store.entity.Address;

import java.util.List;

/**
 * 收货地址业务层接口
 */
public interface IAddressService {
    /**
     * 创建新的收货地址
     *
     * @param uid      当前登陆的用户的id
     * @param username 当前登录的用户名
     * @param address  用户提交的收货地址数据
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 查询某用户的收货地址列表数据
     *
     * @param uid 收货地址归属的用户id
     * @return 该用户的收货地址列表数据
     */
    List<Address> getByUid(Integer uid);

    /**
     * 设置默认收货地址
     *
     * @param uid      归属的用户id
     * @param username 当前登陆的用户名
     * @param aid      收货地址id
     */
    void setDefault(Integer uid, String username, Integer aid);

    /**
     * 删除收货地址
     *
     * @param aid      收货地址id
     * @param uid      归属的用户id
     * @param username 当前登陆的用户名
     */
    void delete(Integer aid, Integer uid, Integer username);

    /**
     * @param aid
     * @param uid
     * @return
     */
    Address getByAid(Integer aid, Integer uid);
}
