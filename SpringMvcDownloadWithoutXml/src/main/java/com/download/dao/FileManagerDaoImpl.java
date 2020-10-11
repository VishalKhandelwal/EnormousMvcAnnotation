package com.download.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.download.model.FileManager;



@Repository
public class FileManagerDaoImpl implements FileManagerDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public List<FileManager> getListOfFileManager() {
		
		return jdbcTemplate.query("SELECT * FROM filemanager", new RowMapper<FileManager>() {

			@Override
			public FileManager mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				FileManager fileManager = new FileManager();
				fileManager.setId(rs.getInt("Id"));
				fileManager.setFilePath(rs.getString("FilePath"));
				fileManager.setContentType(rs.getString("ContentType"));
				fileManager.setFileSize(rs.getFloat("FileSize"));
				return fileManager;
			}
		});
	}
	
}
