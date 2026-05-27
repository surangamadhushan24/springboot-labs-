package com.madhushan.photo.clone;

public class Photo {
	
	private String id;
	private String folderAddress;
	
	
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
