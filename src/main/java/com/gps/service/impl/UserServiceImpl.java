package com.gps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gps.entity.User;
import com.gps.mapper.UserMapper;
import com.gps.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	//方法级别添加事务
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=6000,rollbackFor=Exception.class)
	public int deleteByPrimaryKey(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public  int login(String name, String pwd) {
		return userMapper.login(name, pwd);
	}

	@Override
	public List<User> selectUsers() {
		return userMapper.selectUsers();
	}

}
