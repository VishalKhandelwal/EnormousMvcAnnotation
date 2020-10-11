package com.vk.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vk.model.FileDetailHibernate;

@Repository
public class FileDetailHibernateDaoImpl implements FileDetailHibernateDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(FileDetailHibernate detailHibernate) {
		 sessionFactory.getCurrentSession().saveOrUpdate(detailHibernate);
	}
	
	
}
