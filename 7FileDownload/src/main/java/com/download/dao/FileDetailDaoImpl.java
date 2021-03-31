package com.download.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.download.model.FileDetail;
import com.download.model.FileManager;



@Repository
public class FileDetailDaoImpl implements FileDetailDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<FileDetail> getListOfFileDetail() {
		return jdbcTemplate.query("SELECT * FROM file_upload", new RowMapper<FileDetail>() {

			@Override
			public FileDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				FileDetail fileDetail = new FileDetail();
				fileDetail.setId(rs.getInt("file_id"));
				fileDetail.setFileName(rs.getString("file_name"));
				fileDetail.setFileType(rs.getString("file_type"));
				fileDetail.setData(rs.getBytes("file_data"));
				return fileDetail;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public FileDetail getFileDetailById(int id) {
		String sql = "SELECT * FROM file_upload where file_id = ?";
		return (FileDetail) jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				FileDetail fileDetail = new FileDetail();
				fileDetail.setId(rs.getInt("file_id"));
				fileDetail.setFileName(rs.getString("file_name"));
				fileDetail.setFileType(rs.getString("file_type"));
				fileDetail.setData(rs.getBytes("file_data"));
				return fileDetail;
			}
		});
	}

	
	
}
