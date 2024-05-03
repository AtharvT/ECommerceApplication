package org.ecommerceapplication.service;

import org.ecommerceapplication.model.Address;

import java.util.List;

public interface IAddressService {
    void addAddress(Address address);
    void updateAddress(Address address);
    Address getAddressById(String addressId);
    List<Address> getAddressesByUserId(String userId);
}