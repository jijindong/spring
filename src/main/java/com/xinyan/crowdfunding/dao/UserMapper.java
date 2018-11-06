package com.xinyan.crowdfunding.dao;

import java.util.List;
import java.util.Map;

import com.xinyan.crowdfunding.domain.Permission;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.User;
import com.xinyan.crowdfunding.domain.UserCondition;

public interface UserMapper {
    /**
     * 根据帐号和密码查找用户
     * @param user
     * @return
     */
	public User queryUserByAccountAndPassword(User user);
	/**
	 * 用户分页界面
	 * @param condition
	 * @return
	 */
	public List<User> queryUserByCondition(UserCondition userCondition);
	/**
	 * 添加用户
	 */
	public void addUser(User user);
	/**
	 * 查找用户根据id
	 * @param id
	 */
	public User queryUserById(Integer id);
	/**
	 * 根据id更新用户
	 * @param id
	 */
	public void updateUserById(User user);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteUserById(Integer id);
	/**
	 * 批量删除用户
	 * @param ids
	 */
	public void batchDeleteUser(String[] ids);
	/**
	 * 查询角色根据id
	 * @param id
	 * @return 
	 */
	public List<Role> queryRoleByUserId(Integer id);
	/**
	 * 用户分配角色
	 * @param map
	 * @return
	 */
	public void insertAssignRole(Map<String, Object> map);
	/**
	 * 用户移除角色
	 * @param map
	 */
	public void deleteAssignRole(Map<String, Object> map);
	/**
	 * 根据用户id查询觉权限
	 * @param id
	 * @return
	 */
	public List<Permission> queryPermissionById(Integer id);
}
