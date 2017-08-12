package com.kimhuhg.service.impl;

import java.util.List;

import com.kimhuhg.dao.IPriviliageDAO;
import com.kimhuhg.dao.IUserDAO;
import com.kimhuhg.pojo.Role;
import com.kimhuhg.pojo.Users;
import com.kimhuhg.service.IUserService;
import org.springframework.stereotype.Service;


@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAOImpl;
	private IPriviliageDAO priviliageDAOImpl;
	
	public Users login(Users user) {
		if(user==null){
			return null;
		}
			Users u = userDAOImpl.login(user);
			return u;
	}
	
	public List<Users> findUsersSplit(int cp, int ps,Integer userid) {
		return userDAOImpl.findUsersSplit(cp, ps,userid);
	}

	public int getCount() {
		return userDAOImpl.getCount();
	}
	
	public boolean changeRole(Integer userid,Integer roleid) {
		Users u = new Users();
		u.setUserid(userid);
		Role r = new Role();
		r.setRoleid(roleid);
		u.setRole(r);
		return userDAOImpl.doUpdate(u);
	}
	
	public Users findUserById(Integer userid) {
		if(userid==null){
			return null;
		}
		return userDAOImpl.findUserById(userid);
	}
	
	
	

	public IUserDAO getUserDAOImpl() {
		return userDAOImpl;
	}

	public void setUserDAOImpl(IUserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	public IPriviliageDAO getPriviliageDAOImpl() {
		return priviliageDAOImpl;
	}

	public void setPriviliageDAOImpl(IPriviliageDAO priviliageDAOImpl) {
		this.priviliageDAOImpl = priviliageDAOImpl;
	}







}
