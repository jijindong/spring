package com.xinyan.crowdfunding.domain;

import com.github.pagehelper.PageInfo;

public class RoleCondition {

	private String roleName;
	private Integer pageNo;
	private Integer pageSize;
	private PageInfo<User> pageInfo;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public PageInfo<User> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<User> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	
}
