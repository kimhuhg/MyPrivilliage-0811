package com.kimhuhg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kimhuhg.dao.IRoleDAO;
import com.kimhuhg.pojo.Role;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("roleDAO")
public class RoleDAOImpl extends SqlSessionDaoSupport implements IRoleDAO {

	public List<Role> findall() {
		return super.getSqlSession().selectList("cn.sz.gl.pojo.Role.findallRole");
	}

	public List<Role> findRoleSplit(int cp, int ps) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", (cp-1)*ps);
		map.put("ps", ps);
		return super.getSqlSession().selectList("cn.sz.gl.pojo.Role.findRoleSplit", map);
	}

	public int getCount() {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Role.countRole");
	}

	@Override
	public List<Role> getRoleByUsername(Integer roleid) {
		return super.getSqlSession().selectOne("mappe.Role.findRoleByRoleid",roleid);
	}

}
