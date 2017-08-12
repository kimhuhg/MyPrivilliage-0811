package com.kimhuhg.service.impl;

import java.util.List;

import com.kimhuhg.dao.IPriviliageDAO;
import com.kimhuhg.pojo.Priviliage;
import com.kimhuhg.service.IPriviliageService;
import org.springframework.stereotype.Service;


@Service("priviliageServiceImpl")
public class PriviliageServiceImpl implements IPriviliageService {

	private IPriviliageDAO priviliageDAOImpl;
	
	public List<String> findallurl() {
		return priviliageDAOImpl.findallurl();
	}
	
	public List<Priviliage> findallpri() {
		return priviliageDAOImpl.findallpri();
	}
	
	public List<Priviliage> findPriByRoleid(Integer roleid) {
		return priviliageDAOImpl.findPriByRoleid(roleid);
	}
	

	public IPriviliageDAO getPriviliageDAOImpl() {
		return priviliageDAOImpl;
	}

	public void setPriviliageDAOImpl(IPriviliageDAO priviliageDAOImpl) {
		this.priviliageDAOImpl = priviliageDAOImpl;
	}





}
