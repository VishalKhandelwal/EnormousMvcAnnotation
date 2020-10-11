package com.download.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.download.dao.FileDetailDao;
import com.download.model.FileDetail;


@Service
public class FileDetailServiceImpl implements FileDetailService {

	@Autowired
	FileDetailDao detailDao;

	@Override
	public List<com.download.model.FileDetail> getListOfFileDetail() {
		
		return detailDao.getListOfFileDetail();
	}

	@Override
	public FileDetail getFileDetailById(int id) {
		// TODO Auto-generated method stub
		return detailDao.getFileDetailById(id);
	}

	
}
