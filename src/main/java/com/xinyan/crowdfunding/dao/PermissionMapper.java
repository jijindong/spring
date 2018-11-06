package com.xinyan.crowdfunding.dao;

import java.util.List;

import com.xinyan.crowdfunding.domain.Permission;

public interface PermissionMapper {

	/**
	 * 查询所有许可列表
	 * @return
	 */
	public List<Permission> queryAllPermission();
    /**
     * 添加许可
     */
	public void savePermission(Permission permission);
	/**
	 * 根据id查询权限
	 * @param id
	 * @return
	 */
	public Permission queryPermissionById(Integer id);
	/**
	 * 更新权限
	 * @param permission
	 * @return
	 */
	public void updatePermission(Permission permission);
	/**
	 * 删除许可
	 * @param id
	 */
	public void deletePermission(Integer id);
}
