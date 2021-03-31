package com.vk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vk.model.FileManager;

@Repository
public class FileManagerDaoImpl implements FileManagerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(FileManager fileManager) {
		
		return jdbcTemplate.update("insert into filemanager(FilePath,ContentType,FileSize) values(?,?,?)",fileManager.getFilePath(),fileManager.getContentType(),fileManager.getFileSize());
	}
	
}
