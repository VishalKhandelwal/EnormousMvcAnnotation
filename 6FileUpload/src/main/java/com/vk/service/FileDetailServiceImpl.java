package com.vk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.dao.FileDetailDao;
import com.vk.model.FileDetail;

@Service
public class FileDetailServiceImpl implements FileDetailService {

	@Autowired
	FileDetailDao detailDao;

	@Override
	public int save(FileDetail fileDetail) {
		
		return detailDao.save(fileDetail);
	}
}
