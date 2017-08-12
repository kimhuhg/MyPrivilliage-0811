package com.kimhuhg.dao;

import com.kimhuhg.pojo.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.List;
import java.util.Set;



public interface IRoleDAO {

	public List<Role> findall();
	
	public List<Role> findRoleSplit(int cp, int ps);
	
	public int getCount();

	/**
	 * Create by kimhuhg@163.com on 2017/8/12.
	 * 根据用户名查找群用户角色
	 */
//	@Select("SELECT ROLE_EN FROM ROLE WHERE ROLEID = #{roleid}")
	List<Role> getRoleByUsername(Integer roleid);
}
