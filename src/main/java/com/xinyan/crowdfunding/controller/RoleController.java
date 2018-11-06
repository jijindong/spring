package com.xinyan.crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.github.pagehelper.PageInfo;
import com.xinyan.crowdfunding.domain.JsonMessage;
import com.xinyan.crowdfunding.domain.Permission;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.RoleCondition;
import com.xinyan.crowdfunding.service.PermissionService;
import com.xinyan.crowdfunding.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService premissionService;
	
	@ResponseBody
	@RequestMapping("/doAssignPermission")
 	public JsonMessage doAssignPermission(@RequestParam("roleId") Integer roleId ,
 			@RequestParam("permissionIds") Integer[] permissionIds) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			roleService.saveRolePermissions(roleId,permissionIds);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("许可分配成功!!!");
		} catch (Exception e) {
			jsonMessage.setContent("许可分配失败!!!");
		}
		
		return jsonMessage;
	}
	/**
	 * 查询角色许可在列表显示
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goAssignPermission")
	public List<Permission> goAssignPermission(@RequestParam("id") Integer id){
		//查询所有许可
		List<Permission> permissions = premissionService.findPermission();
		
		//角色的许可,返回权限的所有id
		List<Integer> integers = roleService.findPermission(id);
		for(Permission p : permissions) {
			if(integers.contains(p.getId())) {
				p.setChecked(true);
			}
		}
		return permissions;
	}
	
	/**
	 * 去许可页面
	 * @return
	 */
	@RequestMapping("/assignPermission")
	public String assignPermission() {	
		return "role/assignPermission";
	}
	/**
	 * 角色批量删除
	 */
	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonMessage deleteRole(@RequestParam("ids") String[] ids) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			roleService.batchDeleteRole(ids);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户删除成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户删除失败!!!");
		}
		return jsonMessage;
	}
	
	/**
	 * 角色删除页面
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public JsonMessage deleteRole(@RequestParam("id") Integer id) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			roleService.deleteRole(id);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户删除成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户删除失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 角色修改页面
	 */
	@ResponseBody
	@RequestMapping("/doUpdate")
	public JsonMessage updateRole(Role role) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			roleService.updateRole(role);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户更新成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户更新失败!!!");
		}
		return jsonMessage;
	}
	
	/**
	 * 角色添加页面
	 * @return
	 */
	@RequestMapping("/add")
	public String addRole() {
		return "role/input";
	}

	/**
	 * 修改角色页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateRole(@RequestParam("id") Integer id, Model model) {
		Role role = roleService.findRoleById(id);
		model.addAttribute("role", role);
		return "role/input";
	}

	/**
	 * 角色新增页面
	 */
	@ResponseBody
	@RequestMapping("doAdd")
	public JsonMessage saveRole(Role role) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			roleService.saveRole(role);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户添加成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户添加失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 角色列表
	 * @param userCondition
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/roles")
	public PageInfo<Role> roles(RoleCondition roleCondition){
		PageInfo<Role> pageInfo = roleService.findRoleByCondition(roleCondition);
		return pageInfo;
		
	}

}
