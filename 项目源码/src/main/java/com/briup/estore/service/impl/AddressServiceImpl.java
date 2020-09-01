package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopAddressExample;
import com.briup.estore.mapper.ShopAddressMapper;
import com.briup.estore.service.IAddressService;
import com.briup.estore.utils.MyBatisSqlSessionFactory;

public class AddressServiceImpl implements IAddressService{
	@Override
	public List<ShopAddress> findAddressesByCustomer(int customerId) throws RuntimeException{
		ShopAddressMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(ShopAddressMapper.class);
		ShopAddressExample example = new ShopAddressExample();
		example.createCriteria().andCustomerIdEqualTo(customerId);
		List<ShopAddress> addresses = mapper.selectByExample(example);
		addresses.forEach(System.out::println);
		return addresses;
	}
	@Override
	public void addAddress(ShopAddress address) throws RuntimeException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
		mapper.insertSelective(address);
		sqlSession.commit();
	}
	
}
