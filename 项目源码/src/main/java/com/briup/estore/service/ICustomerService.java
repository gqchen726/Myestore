package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Customer;

public interface ICustomerService {
	// 注册
	void saveCustomer(Customer customer) throws RuntimeException;
	List<Customer> findCustomerByNameAndPassword(Customer customer) throws RuntimeException;
}
