package com.madhushan.photo.clone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;


@Table(name = "PHOTOS")
public class Photo {
	
	
	@Id
	private Integer id;
	
	@NotEmpty
	private String folderAddress;
	@JsonIgnore
	private byte[] data;
	
	private String contentType;
	
	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public Photo() {
		
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	
	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}



	

}
