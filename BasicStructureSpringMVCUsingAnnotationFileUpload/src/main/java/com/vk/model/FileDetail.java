package com.vk.model;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileDetail {

	private CommonsMultipartFile file;
	private String fileName;
	private String fileType;
	private byte[] data;
	
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "FileDetail [file=" + file + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + "]";
	}
	
	
	
}
