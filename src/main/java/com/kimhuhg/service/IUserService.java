package com.kimhuhg.service;

import com.kimhuhg.pojo.Users;

import java.util.List;



public interface IUserService {

	public Users login(Users user);

	public List<Users> findUsersSplit(int cp, int ps, Integer userid);

	public int getCount();
	
	public boolean changeRole(Integer userid, Integer roleid);
	
	public Users findUserById(Integer userid);
	
}
