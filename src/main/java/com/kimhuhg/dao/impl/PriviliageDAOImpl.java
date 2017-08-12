package com.kimhuhg.dao.impl;

import java.util.List;

import com.kimhuhg.dao.IPriviliageDAO;
import com.kimhuhg.pojo.Priviliage;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class PriviliageDAOImpl extends SqlSessionDaoSupport implements
		IPriviliageDAO {

	public List<Priviliage> findallpri() {
		return super.getSqlSession().selectList("cn.sz.gl.pojo.Priviliage.findallpri");
	}

	public List<String> findallurl() {
		return super.getSqlSession().selectList("cn.sz.gl.pojo.Priviliage.findallurl");
	}

	public List<Priviliage> findPriByRoleid(Integer roleid) {
		return super.getSqlSession().selectList("mapper.Priviliage.findPriByRoleid", roleid);
	}

}
