package com.xinyan.crowdfunding.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.xinyan.crowdfunding.domain.Permission;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.User;
import com.xinyan.crowdfunding.domain.UserCondition;

public interface UserService {
	/**
	 * 查找用户:根据帐号和密码
	 * @param user
	 * @return
	 */
	public User findUserByAccountAndPassword(User user);
	
	/**
	 * 用户分页:按条件查询
	 * @param condition
	 * @return
	 */
	public PageInfo<User> findUserByCondition(UserCondition userCondition);

	/**
	 * 新增用户
	 */
	public void saveUser(User user);
	/**
	 * 查询用户:根据id
	 */
	public User findUserById(Integer id);
	/**
	 * 更新用户根据id
	 * @param id
	 */
	public void updateUser(User user);
    /**
     * 删除删除用户
     * @param id
     */
	public void deleteUser(Integer id);
    /**
     * 批量删除用户
     * @param ids
     */
	public void batchDeleteUser(String[] ids);
	/**
	 * 用户角色查询
	 * @param id
	 * @return
	 */
	public List<Role> findRoleByUserId(Integer id);
	/**
	 * 分配角色
	 * @param map
	 */
	public void saveAssignRole(Map<String, Object> map);
    /**
     * 移除角色
     * @param map
     */
	public void deleteAssignRole(Map<String, Object> map);
	/**
	 * 根据用户id查询权限
	 * @param id
	 * @return
	 */
	public List<Permission> getPermissionById(Integer id);
 
}
