package com.kimhuhg.service;

import com.kimhuhg.pojo.Priviliage;

import java.util.List;



public interface IPriviliageService {

	public List<String> findallurl();
	
	public List<Priviliage> findallpri();
	
	public List<Priviliage> findPriByRoleid(Integer roleid);
}
