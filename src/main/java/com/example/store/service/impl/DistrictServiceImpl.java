package com.example.store.service.impl;

import com.example.store.entity.District;
import com.example.store.mapper.DistrictMapper;
import com.example.store.service.IDistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理省/市/区数据的业务层实现类
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        return null;
    }

    @Override
    public String getNameByCode(String code) {
        return null;
    }
}
