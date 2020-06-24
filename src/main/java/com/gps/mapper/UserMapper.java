package com.gps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.gps.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Long id);
    int updateByPrimaryKey(User record);
    @Select("SELECT * FROM USERS WHERE name=#{name} AND pwd=#{pwd}")
    int login(String name, String pwd);
    @Select("SELECT * FROM USERS")
	List<User> selectUsers();
}