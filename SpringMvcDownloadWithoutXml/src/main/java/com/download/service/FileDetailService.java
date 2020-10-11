package com.download.service;

import java.util.List;

import com.download.model.FileDetail;



public interface FileDetailService {

	public List<FileDetail> getListOfFileDetail();
	public FileDetail getFileDetailById(int id);
}
