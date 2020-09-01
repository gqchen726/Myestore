package com.briup.estore.service;

import java.util.Collection;
import java.util.List;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;

public interface IOrderService {
	List<OrderForm> findOrderFormsByCustomerId(int customerId) throws RuntimeException;
	OrderForm submitOrder(OrderForm orderForm) throws RuntimeException;
	void addOrderLines(Collection<OrderLine> orderLines) throws RuntimeException;
	List<OrderLine> findOrderLinesByOrderFormId(Integer orderFormId) throws RuntimeException;
	OrderForm findOrderFormById(Integer id) throws RuntimeException;
}
