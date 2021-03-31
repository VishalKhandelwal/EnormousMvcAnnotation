package com.vk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.dao.FileDetailHibernateDao;
import com.vk.model.FileDetailHibernate;

@Service
public class FileDetailHibernateServiceImpl implements FileDetailHibernateService{

	@Autowired
	FileDetailHibernateDao fileDetailHibernateDao;
	
	@Override
	@Transactional
	public void save(FileDetailHibernate detailHibernate) {
		fileDetailHibernateDao.save(detailHibernate);
		
	}

}
