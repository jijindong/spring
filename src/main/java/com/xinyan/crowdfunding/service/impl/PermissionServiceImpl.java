package com.xinyan.crowdfunding.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.xinyan.crowdfunding.dao.PermissionMapper;
import com.xinyan.crowdfunding.domain.Permission;
import com.xinyan.crowdfunding.service.PermissionService;


@Transactional
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    public PermissionMapper permissionMapper;
    /**
     * 查询权限列表
     */
	@Override
	public List<Permission> findPermission() {
		return permissionMapper.queryAllPermission();
	}
	/**
	 * 添加权限
	 */
	@Override
	public void addPermission(Permission permission) {
		permissionMapper.savePermission(permission);
	}
	/**
	 * 根据id查询权限
	 */
	@Override
	public Permission findPermissionById(Integer id) {
		return permissionMapper.queryPermissionById(id);
	}
	/**
	 * 更新权限
	 */
	@Override
	public void updatePermission(Permission permission) {
	     permissionMapper.updatePermission(permission);
	}
	/**
	 * 删除权限
	 */
	@Override
	public void deletePermission(Integer id) {
		permissionMapper.deletePermission(id);
	}
	

	
	
}
