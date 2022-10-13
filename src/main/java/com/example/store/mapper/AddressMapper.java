package com.example.store.mapper;

import com.example.store.entity.Address;

/**
 * 收货地址持久层接口
 */
//@Mapper
public interface AddressMapper {
    /**
     * 插入用户的收获地址数据
     *
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的id统计收货地址数量
     *
     * @param uid 用户的id
     * @return 当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);
}
