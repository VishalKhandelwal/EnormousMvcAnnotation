package com.download.dao;

import java.util.List;

import com.download.model.FileDetail;


public interface FileDetailDao {
	public List<FileDetail> getListOfFileDetail();
    public FileDetail getFileDetailById(int id);
}
