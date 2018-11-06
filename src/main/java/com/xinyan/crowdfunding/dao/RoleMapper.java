package com.xinyan.crowdfunding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.RoleCondition;

public interface RoleMapper {
	/**
	 * 角色分页界面
	 * @param condition
	 * @return
	 */
	public List<Role> queryRoleByCondition(RoleCondition roleCondition);
	/**
	 * 添加角色
	 */
	public void addRole(Role role);
	/**
	 * 查找角色根据id
	 * @param id
	 */
	public Role queryRoleById(Integer id);
	/**
	 * 更新角色
	 * @param id
	 */
	public void updateRoleById(Role role);
	/**
	 * 根据id删除角色
	 * @param id
	 */
	public void deleteRoleById(Integer id);
	/**
	 * 批量删除角色
	 * @param ids
	 */
	public void batchDeleteRole(String[] ids);
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> queryAllRole();
	/**
	 * 根据角色查找权限
	 * @param id
	 * @return
	 */
	public List<Integer> queryPermissionById(Integer id);
	/**
	 * 分配权限(许可)
	 * @param roleId
	 * @param permissionIds
	 * @return
	 */
	public void insertPermission(@Param("roleId") Integer roleId,@Param("permissionIds") Integer[] permissionIds);
	/**
	 * 删除角色许可
	 * @param roleId
	 * @param permissionIds
	 */
	public void deleteRolePermission(@Param("roleId") Integer roleId);
}
