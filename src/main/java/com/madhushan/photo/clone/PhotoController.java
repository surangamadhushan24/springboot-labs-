package com.madhushan.photo.clone;

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



@RestController
public class PhotoController {

	private final Map<String, Photo> db = new HashMap<>(Map.of("1", new Photo("1", "hh.jpg")));

	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/photos")
	public Collection<Photo> getPhotos() {
		return db.values();

	}
	
	@GetMapping("photos/{id}")
	public Photo getphoto(@PathVariable String id) {
		Photo photo = db.get(id);
		if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return photo;
		
	}
	
	@DeleteMapping("photos/{id}")
	public void deletePhoto(@PathVariable String id) {
		Photo photo = db.remove(id);
		if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);	
	}

	@PostMapping("/add")
	public void create(@RequestPart("data") MultipartFile file) throws IOException {
		Photo photo = new Photo();
		photo.setId(UUID.randomUUID().toString());
		photo.setFolderAddress(file.getOriginalFilename());
		photo.setData(file.getBytes());
		db.put(photo.getId(), photo);
	}

}
