package com.kimhuhg.dao;

import com.kimhuhg.pojo.Priviliage;

import java.util.List;


public interface IPriviliageDAO {

	public List<Priviliage> findallpri();
	
	public List<String> findallurl();
	
	public List<Priviliage> findPriByRoleid(Integer roleid);
	
}
 