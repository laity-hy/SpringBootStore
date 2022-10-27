package com.example.store.controller;

import com.example.store.entity.District;
import com.example.store.service.IDistrictService;
import com.example.store.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {
    @Resource
    private IDistrictService districtService;

    @GetMapping
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK, data);
    }
}
