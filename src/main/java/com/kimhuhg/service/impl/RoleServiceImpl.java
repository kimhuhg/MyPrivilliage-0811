package com.kimhuhg.service.impl;

import java.util.List;
import java.util.Set;

import com.kimhuhg.dao.IRoleDAO;
import com.kimhuhg.pojo.Role;
import com.kimhuhg.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("roleServiceImpl")
public class RoleServiceImpl implements IRoleService {

	@Resource(name = "roleDAO")
	private IRoleDAO roleDAO;


	@Override
	public List<Role> getRoleByUsername(Integer roleid) {
		return roleDAO.getRoleByUsername(roleid);
	}
}
