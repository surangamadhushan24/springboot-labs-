package com.madhushan.photo.clone.repository;

import org.springframework.data.repository.CrudRepository;

import com.madhushan.photo.clone.model.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
