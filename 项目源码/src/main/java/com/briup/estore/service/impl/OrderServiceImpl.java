package com.briup.estore.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderFormExample;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.OrderLineExample;
import com.briup.estore.mapper.OrderFormMapper;
import com.briup.estore.mapper.OrderLineMapper;
import com.briup.estore.service.IOrderService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class OrderServiceImpl implements IOrderService{
	@Override
	public List<OrderForm> findOrderFormsByCustomerId(int customerId) throws RuntimeException {
		OrderFormMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(OrderFormMapper.class);
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andCustomerIdEqualTo(customerId);
		List<OrderForm> orders = mapper.selectByExample(example);
		return orders;
	}
	@Override
	public OrderForm submitOrder(OrderForm orderForm) throws RuntimeException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
		
		mapper.insert(orderForm);
		sqlSession.commit();
		return orderForm;
	}
	@Override
	public void addOrderLines(Collection<OrderLine> orderLines) throws RuntimeException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
		orderLines.forEach((orderLine) -> 
			mapper.insert(orderLine)
		);
		
		sqlSession.commit();
	}
	@Override
	public List<OrderLine> findOrderLinesByOrderFormId(Integer orderFormId) throws RuntimeException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
		OrderLineExample example = new OrderLineExample();
		example.createCriteria().andOrderformIdEqualTo(orderFormId);
		List<OrderLine> orderLines = mapper.selectByExample(example);
		return orderLines;
	}
	@Override
	public OrderForm findOrderFormById(Integer id) throws RuntimeException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
		OrderForm orderForm = mapper.selectByPrimaryKey(id);
		return orderForm;
	}
}
