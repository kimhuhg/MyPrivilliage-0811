package com.kimhuhg.dao;

import com.kimhuhg.pojo.Users;

import java.util.List;



public interface IUserDAO {

	public Users login(Users user);
	
	public List<Users> findUsersSplit(int cp, int ps, Integer userid);
	
	public int getCount();
	
	public boolean doUpdate(Users users);
	
	public Users findUserById(Integer userid);
}
