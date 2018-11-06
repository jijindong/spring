package com.xinyan.crowdfunding.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinyan.crowdfunding.dao.RoleMapper;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.RoleCondition;

import com.xinyan.crowdfunding.service.RoleService;

@Transactional
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	public RoleMapper roleMapper;
	 /**
	  * 角色分页查询
	  */
	@Override
	public PageInfo<Role> findRoleByCondition(RoleCondition roleCondition) {
		PageHelper.startPage(roleCondition.getPageNo(), roleCondition.getPageSize());
		
		List<Role> list = roleMapper.queryRoleByCondition(roleCondition);
		
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	/**
	 * 新增角色
	 */
	@Override
	public void saveRole(Role role) {
		role.setCreateTime(new Date());
		roleMapper.addRole(role);
	}
	/**
	 * 根据id查询角色
	 */
	@Override
	public Role findRoleById(Integer id) {
		return roleMapper.queryRoleById(id);
	}
	/**
	 * 更新角色
	 */
	@Override
	public void updateRole(Role role) {
		roleMapper.updateRoleById(role);
	}
	/**
	 * 删除角色
	 */
	@Override
	public void deleteRole(Integer id) {
		roleMapper.deleteRoleById(id);
		
	}
	/**
	 * 批量删除角色
	 */
	@Override
	public void batchDeleteRole(String[] ids) {
		roleMapper.batchDeleteRole(ids);
	}
	/**
	 * 查询所有未分配角色
	 */
	@Override
	public List<Role> findAllRole() {
		return roleMapper.queryAllRole();
	}
	/**
	 * 查询角色的所有Id
	 */
	@Override
	public List<Integer> findPermission(Integer id) {
		return roleMapper.queryPermissionById(id);
	}
	/**
	 * 分配权限
	 */
	@Override
	public void saveRolePermissions(Integer roleId, Integer[] permissionIds) {
		//删除角色许可
		roleMapper.deleteRolePermission(roleId);
		//保存角色许可
		roleMapper.insertPermission(roleId, permissionIds);
	}

	
}
