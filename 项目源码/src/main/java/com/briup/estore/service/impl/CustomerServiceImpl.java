package com.briup.estore.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{
	@Override
	public void saveCustomer(Customer customer) throws RuntimeException {
		// 所有引用类型都要进行判空
		// 判空:判断customer是否为空
		if (customer == null) {
			throw new RuntimeException("参数为空");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		// 查询用户名是否重复
		CustomerExample example = new CustomerExample();
		example.createCriteria().andNameEqualTo(customer.getName());
		long countByExample = mapper.countByExample(example);
		if (countByExample!=0) {
			throw new RuntimeException("用户名已存在");
		}
		
		mapper.insert(customer);
		
		sqlSession.commit();
	}
	@SuppressWarnings("null")
	@Override
	public List<Customer> findCustomerByNameAndPassword(Customer customer) throws RuntimeException {
		if (StringUtils.isBlank(customer.getName()) && StringUtils.isBlank(customer.getPassword())) {
			return null;
		} 
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		CustomerExample example = new CustomerExample();
		example.createCriteria().andNameEqualTo(customer.getName()).andPasswordEqualTo(customer.getPassword());
//		long countByExample = mapper.countByExample(example);
		
		List<Customer> customers = mapper.selectByExample(example);
		
		return customers;
	}
}
