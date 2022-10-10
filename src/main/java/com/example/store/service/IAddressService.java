package com.example.store.service;

import com.example.store.entity.Address;

/**
 * 收货地址业务层接口
 */
public interface IAddressService {
    void addNewAddress(Integer uid, String username, Address address);
}
