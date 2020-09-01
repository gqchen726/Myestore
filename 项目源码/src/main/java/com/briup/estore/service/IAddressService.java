package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public interface IAddressService {
	List<ShopAddress> findAddressesByCustomer(int customerId) throws RuntimeException;
	void addAddress(ShopAddress address) throws RuntimeException;
}
