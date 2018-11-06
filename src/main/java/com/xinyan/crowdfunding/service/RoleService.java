package com.xinyan.crowdfunding.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.RoleCondition;

public interface RoleService {
	/**
	 * 角色分页:按条件查询
	 * @param condition
	 * @return
	 */
	public PageInfo<Role> findRoleByCondition(RoleCondition roleCondition);

	/**
	 * 新增角色
	 */
	public void saveRole(Role role);
	/**
	 * 查询角色:根据id
	 */
	public Role findRoleById(Integer id);
	/**
	 * 更新角色
	 * @param id
	 */
	public void updateRole(Role role);
    /**
     * 删除角色根据id
     * @param id
     */
	public void deleteRole(Integer id);
    /**
     * 批量删除角色
     * @param ids
     */
	public void batchDeleteRole(String[] ids);
    /**
     * 查询所有未分配的角色
     * @return
     */
	public List<Role> findAllRole();
	/**
	 * 查询角色的所有权限id
	 * @param id
	 * @return
	 */
	public List<Integer> findPermission(Integer id);
	/**
	 * 分配权限
	 * @param roleId
	 * @param permissionIds
	 */
	public void saveRolePermissions(Integer roleId, Integer[] permissionIds);
	
}
