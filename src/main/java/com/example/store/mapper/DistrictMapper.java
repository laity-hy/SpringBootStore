package com.example.store.mapper;

import com.example.store.entity.District;

import java.util.List;

/**
 * 处理省市区数据的持久层接口
 */
public interface DistrictMapper {
    /**
     * 获取全国所有省/某省所有市/某市所有区
     *
     * @param parent 父级代号。当获取某市所有的代号，使用市的代号；当获取省所有的市时，使用省的代号；当获取全国所有的省时，使用”x86“作为父级代号
     * @return
     */
    List<District> findByParent(String parent);

    /**
     * 根据省市区的行政代号来获取省市区的名称
     *
     * @param code 省市区的行政代号
     * @return 匹配省市区的名称，如果没有匹配的数据则返回null
     */
    String findNameByCode(String code);
}
