package com.innoq.mploed.ddd.customercontact.controller;

import com.innoq.mploed.ddd.customercontact.domain.Address;
import com.innoq.mploed.ddd.customercontact.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    private AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(path = "/addresses", method = RequestMethod.GET)
    public List<Address> index() {
        return addressRepository.findAll();
    }

}
