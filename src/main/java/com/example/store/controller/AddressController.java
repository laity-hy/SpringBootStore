package com.example.store.controller;

import com.example.store.entity.Address;
import com.example.store.service.IAddressService;
import com.example.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/addresses")
@RestController
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
        addressService.addNewAddress(getUidFromSession(session), getUsernameFromSession(session), address);
        return new JsonResult<>(OK);
    }
}
