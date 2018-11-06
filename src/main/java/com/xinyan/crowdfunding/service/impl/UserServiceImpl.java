package com.xinyan.crowdfunding.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinyan.crowdfunding.dao.UserMapper;
import com.xinyan.crowdfunding.domain.Permission;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.User;
import com.xinyan.crowdfunding.domain.UserCondition;
import com.xinyan.crowdfunding.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserMapper UserMapper;
	/**
	 * 查询用户:根据用户和密码
	 */
	@Override
	public User findUserByAccountAndPassword(User user) {
		return UserMapper.queryUserByAccountAndPassword(user);
	}
	/**
	 * 用户分页查询
	 */
	@Override
	public PageInfo<User> findUserByCondition(UserCondition userCondition) {
		PageHelper.startPage(userCondition.getPageNo(), userCondition.getPageSize());
		
		List<User> list = UserMapper.queryUserByCondition(userCondition);
		
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	/**
	 * 新增用户
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword("123456");
		user.setCreateTime(new Date());
		UserMapper.addUser(user);
	}
	/**
	 * 根据id查询用户
	 */
	@Override
	public User findUserById(Integer id) {
		return UserMapper.queryUserById(id);
	}
	/**
	 * 更新用户
	 */
	@Override
	public void updateUser(User user) {
		UserMapper.updateUserById(user);
	}
	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(Integer id) {
		UserMapper.deleteUserById(id);
		
	}
	/**
	 * 批量删除用户
	 */
	@Override
	public void batchDeleteUser(String[] ids) {
		UserMapper.batchDeleteUser(ids);
	}
	/**
	 * 根据用户Id查询id
	 */
	@Override
	public List<Role> findRoleByUserId(Integer id) {
		return UserMapper.queryRoleByUserId(id);
	}
	/**
	 * 分配角色
	 */
	@Override
	public void saveAssignRole(Map<String, Object> map) {
		 UserMapper.insertAssignRole(map);
	}
	/**
	 * 移除角色
	 */
	@Override
	public void deleteAssignRole(Map<String, Object> map) {
		UserMapper.deleteAssignRole(map);
	}
	/**
	 * 根据用户id查询权限
	 */
	@Override
	public List<Permission> getPermissionById(Integer id) {
		return UserMapper.queryPermissionById(id);
	}

	
}
