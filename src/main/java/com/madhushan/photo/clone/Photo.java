package com.madhushan.photo.clone;

import jakarta.validation.constraints.NotEmpty;

public class Photo {
	
	
	
	private String id;
	@NotEmpty
	private String folderAddress;
	
	public Photo() {
		
	}
	
	
	public Photo(String id, String folderAddress) {
		this.id = id;
		this.folderAddress = folderAddress;
	}
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the folderAddress
	 */
	public String getFolderAddress() {
		return folderAddress;
	}


	/**
	 * @param folderAddress the folderAddress to set
	 */
	public void setFolderAddress(String folderAddress) {
		this.folderAddress = folderAddress;
	}


	

}
