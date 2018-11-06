package com.xinyan.crowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xinyan.crowdfunding.domain.JsonMessage;
import com.xinyan.crowdfunding.domain.Role;
import com.xinyan.crowdfunding.domain.User;
import com.xinyan.crowdfunding.domain.UserCondition;
import com.xinyan.crowdfunding.service.RoleService;
import com.xinyan.crowdfunding.service.UserService;
//用户控制controller
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	/**
	 * 分配角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addassignRole")
	public JsonMessage addassignRole(@RequestParam("roleIds") String roleIds,
			@RequestParam("id") Integer id) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			String[] ids = roleIds.split(",");
			Map<String, Object> map = new HashMap<>();
			map.put("userId", id);
			map.put("roleIds",ids);
			
			userService.saveAssignRole(map);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("分配角色成功!!!");
		} catch (Exception e) {
			jsonMessage.setContent("分配角色失败!!!");
		}
		
		return jsonMessage;
	}
	/**
	 * 移除角色
	 * @param roleIds
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/unAssignRole")
	public JsonMessage unassignRole(@RequestParam("roleIds") String roleIds,
			@RequestParam("id") Integer id) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			String[] ids = roleIds.split(",");
			Map<String, Object> map = new HashMap<>();
			map.put("userId", id);
			map.put("roleIds",ids);
			userService.deleteAssignRole(map);
			
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("角色移除成功!!!");
		} catch (Exception e) {
			jsonMessage.setContent("角色移除失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 用户角色信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/assignRole")
	public String assignRole(@RequestParam("id") Integer id, Model model) {
		List<Role> roles = userService.findRoleByUserId(id);
	    List<Role> roles2 = roleService.findAllRole();
	    
	    if(roles != null && roles.size() > 0) {
	    	for (int i = 0; i < roles.size(); i++) {
				Role role = roles.get(i);
				for (int j = 0; j < roles2.size(); j++) {
					Role role2 = roles2.get(j);
					if(role.getId().intValue() == role2.getId().intValue()) {
					 roles2.remove(j);
					}
				}
			}
	    }
	    model.addAttribute("allRoles",roles2);
	    model.addAttribute("userRoles",roles);
	    
		return "user/assignRole";
	}
	/**
	 * 用户批量删除
	 */
	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonMessage deleteUser(@RequestParam("ids") String[] ids) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			userService.batchDeleteUser(ids);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户删除成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户删除失败!!!");
		}
		return jsonMessage;
	}
	
	/**
	 * 用户删除页面
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public JsonMessage deleteUser(@RequestParam("id") Integer id) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			userService.deleteUser(id);;
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户删除成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户删除失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 用户修改页面
	 */
	@ResponseBody
	@RequestMapping("/doUpdate")
	public JsonMessage updateUser(User user) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			userService.updateUser(user);;
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户更新成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户更新失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 用户新增页面
	 */
	@ResponseBody
	@RequestMapping("doAdd")
	public JsonMessage saveUser(User user) {
		JsonMessage jsonMessage = new JsonMessage();
		try {
			userService.saveUser(user);
			jsonMessage.setSuccess(true);
			jsonMessage.setContent("用户添加成功!!!");
		}catch (Exception e) {
			jsonMessage.setContent("用户添加失败!!!");
		}
		return jsonMessage;
	}
	/**
	 * 用户列表
	 * @param userCondition
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/users")
	public PageInfo<User> users(UserCondition userCondition){
		PageInfo<User> pageInfo = userService.findUserByCondition(userCondition);
		return pageInfo;
		
	}

}
