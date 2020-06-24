package com.gps.service;

import java.util.List;

import com.gps.entity.User;

/**
 * <p>HSBC</p>
 * <p>作者：毛兆伟</p>
 * <p>邮箱：itzwmao@163.com</p>
 * <p>创建时间： 2018年11月16日 下午1:55:33 </p>
 * <p>类说明：用户模块接口</p>
 * <p>修改记录： </p> 
 */
public interface UserService {

	/** 
	 * TODO (根据用户ID删除用户)
	 * @author 毛兆伟 
	 * @param id
	 * @return int
	 * @throws 
	 */
	int deleteByPrimaryKey(Long id);
    /** 
     * TODO (保存用户信息)
     * @author 毛兆伟 
     * @param record
     * @return int
     * @throws 
     */
    int insert(User record);
    /** 
     * TODO (保存选中的用户)
     * @author 毛兆伟 
     * @param record
     * @return int
     * @throws 
     */
    int insertSelective(User record);
    /** 
     * TODO (根据用户ID查询用户)
     * @author 毛兆伟 
     * @param id
     * @return User
     * @throws 
     */
    User selectByPrimaryKey(Long id);
    /** 
     * TODO (更新用户信息)
     * @author 毛兆伟 
     * @param record
     * @return int
     * @throws 
     */
    int updateByPrimaryKey(User record);
    /** 
     * TODO (登陆验证)
     * @author 毛兆伟 
     * @param name
     * @param pwd
     * @return int
     * @throws 
     */
    int login(String name, String pwd);
    /** 
     * TODO (查询所有用户)
     * @author 毛兆伟 
     * @return List<User>
     * @throws 
     */
    List<User> selectUsers();
}