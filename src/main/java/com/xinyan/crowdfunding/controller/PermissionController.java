package com.xinyan.crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinyan.crowdfunding.domain.JsonMessage;
import com.xinyan.crowdfunding.domain.Permission;
import com.xinyan.crowdfunding.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
   
	@Autowired
	private PermissionService permissionService;
	/**
	 * 权限列表页面
	 * @return
	 */
    @ResponseBody
	@RequestMapping("/list")
	public List<Permission> list(){
		List<Permission> permission = permissionService.findPermission();
		return permission;
	}
	/**
	 * 去添加权限页面
	 * @return
	 */
	
	@RequestMapping("/add")
	public String add() {
		return "permission/input";
	}
	/**
	 * 添加权限
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAdd")
	public JsonMessage doAdd(Permission permission) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
	       permissionService.addPermission(permission);
	       jsonMessage.setSuccess(true);
	       jsonMessage.setContent("权限添加成功!!!");
		} catch (Exception e) {
		   jsonMessage.setContent("权限添加失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 去修改权限页面
	 */
	
	@RequestMapping("/update")
	public String toUpdata(@RequestParam("id") Integer id , Model model){
		Permission permission = permissionService.findPermissionById(id);
		model.addAttribute("permission",permission);
		return "permission/input";
	}
	/**
	 * 修改权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doUpdate")
	public JsonMessage updatePermission(Permission permission) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			permissionService.updatePermission(permission);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("许可更新成功!!!");
		} catch (Exception e) {
			jsonMessage.setContent("许可更新失败!!!");
		}
		
		return jsonMessage;
	}
	/**
	 * 删除许可
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public JsonMessage deletePermission(@RequestParam("id") Integer id) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			permissionService.deletePermission(id);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("许可删除成功!!!");
		} catch (Exception e) {
			jsonMessage.setContent("许可删除失败!!!");
		}
		return jsonMessage;
	}
}
