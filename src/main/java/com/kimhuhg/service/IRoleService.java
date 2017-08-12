package com.kimhuhg.service;


import com.kimhuhg.pojo.Role;

import java.util.List;
import java.util.Set;

public interface IRoleService {
	/**
	 * Create by kimhuhg@163.com on 2017/8/12.
	 * 根据用户名查找群用户角色
	 */

	public List<Role> getRoleByUsername(Integer username);
}
