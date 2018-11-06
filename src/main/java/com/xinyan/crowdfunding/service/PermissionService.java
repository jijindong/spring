package com.xinyan.crowdfunding.service;

import java.util.List;

import com.xinyan.crowdfunding.domain.Permission;



public interface PermissionService {
	
	/**
	 * 查询权限列表
	 */
	public List<Permission> findPermission();
    /**
     * 添加权限
     * @param permission
     */
	public void addPermission(Permission permission);
	/**
	 * 根据id查询权限
	 * @param id
	 */
	public Permission findPermissionById(Integer id);
	/**
	 * 更新权限
	 * @param permission
	 * @return
	 */
	public void updatePermission(Permission permission);
	/**
	 * 删除权限
	 * @param id
	 */
	public void deletePermission(Integer id);
}
