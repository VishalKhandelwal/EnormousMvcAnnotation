package com.download.model;

public class FileData {

	private String fileName;
	private String creationTime;
	private Long fileSize;
	private String path;	
	
	public FileData(String fileName, String creationTime, Long fileSize, String path) {
		super();
		this.fileName = fileName;
		this.creationTime = creationTime;
		this.fileSize = fileSize;
		this.path = path;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileData [fileName=" + fileName + ", creationTime=" + creationTime + ", fileSize=" + fileSize
				+ ", path=" + path + "]";
	}	
	
}
