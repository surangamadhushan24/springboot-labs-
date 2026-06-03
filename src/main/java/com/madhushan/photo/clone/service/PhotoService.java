package com.madhushan.photo.clone.service;


import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.madhushan.photo.clone.model.Photo;
import com.madhushan.photo.clone.repository.PhotoRepository;

@Service
public class PhotoService {
	

	private final PhotoRepository photoRepository;
	
	

	public PhotoService(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}



	public Iterable<Photo> getPhotos() {
		return photoRepository.findAll();
	}



	public Photo getPhoto(Integer id) {
		return photoRepository.findById(id).orElse(null);
	}

	public void remove(Integer id) {
		 photoRepository.deleteById(id);
	}

	public Photo addPhoto(@Nullable String originalFilename,String contentType, byte[] bytes) {
		Photo photo = new Photo();
		photo.setContentType(contentType);
        photo.setFolderAddress(originalFilename);
        photo.setData(bytes);
        photoRepository.save(photo);
        return photo;
	
	}

	

}
