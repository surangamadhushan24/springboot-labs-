package com.madhushan.photo.clone.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.madhushan.photo.clone.model.Photo;
import com.madhushan.photo.clone.service.PhotoService;



@RestController
public class PhotoController {
	
	private final PhotoService photoService;
	

	public PhotoController(PhotoService photoService) {
		this.photoService = photoService;
	}


	@GetMapping("/photos")
	public Iterable<Photo> getPhotos() {
		return photoService.getPhotos();

	}
	
	@GetMapping("photos/{id}")
	public Photo getphoto(@PathVariable Integer id) {
		Photo photo = photoService.getPhoto(id);
		if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return photo;
		
	}
	
	@DeleteMapping("photos/{id}")
	public void deletePhoto(@PathVariable Integer id) {
		 photoService.remove(id);
	
	}

	@PostMapping("/add")
	public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
	    Photo photo = photoService.addPhoto(file.getOriginalFilename(),file.getContentType(),file.getBytes());
		return photo;
	}

}
