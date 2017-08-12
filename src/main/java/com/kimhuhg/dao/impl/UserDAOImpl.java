package com.kimhuhg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kimhuhg.dao.IUserDAO;
import com.kimhuhg.pojo.Users;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements IUserDAO {

	public Users login(Users user) {
		return super.getSqlSession().selectOne("mapper.Users.login",user);
	}

	public List<Users> findUsersSplit(int cp, int ps,Integer userid) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", (cp-1)*ps);
		map.put("ps", ps);
		map.put("userid", userid);
		return super.getSqlSession().selectList("com.kimhuhg.pojo.Users.findUserSplit", map);
	}

	public int getCount() {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Users.countUser");
	}

	public boolean doUpdate(Users users) {
		int res = super.getSqlSession().update("cn.sz.gl.pojo.Users.updateUser", users);
		return res>0?true:false;
	}

	public Users findUserById(Integer userid) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Users.findUserById", userid);
	}

}
