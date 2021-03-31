package com.vk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vk.model.FileDetail;

@Repository
public class FileDetailDaoImpl implements FileDetailDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(FileDetail fileDetail) {
        		
		//return jdbcTemplate.update("insert into file_upload(file_name,file_type,file_data) values(?,?,?)",fileDetail.getFileName(),fileDetail.getFileType(),fileDetail.getFile().getBytes());		
		return jdbcTemplate.update("insert into file_upload(file_name,file_type,file_data) values(?,?,?)",fileDetail.getFileName(),fileDetail.getFileType(),fileDetail.getData());		

	}
	
	
}
