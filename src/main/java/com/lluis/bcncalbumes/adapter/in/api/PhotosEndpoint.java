package com.lluis.bcncalbumes.adapter.in.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;
import com.lluis.bcncalbumes.domain.port.in.GetPhotos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/photos")
public class PhotosEndpoint {
    private final GetPhotos getPhotos;
    
    @GetMapping("/{id}")
    PhotoResponse getPhotoById(@PathVariable Long id) throws NoSuchElementException, ValidationException {
        return PhotoResponse.of(getPhotos.get(new PhotoId(id)));
    }

    @GetMapping
    List<PhotoResponse> getPhotosByAlbumId(@RequestParam Long albumId) throws ValidationException {
        return getPhotos.get(new AlbumId(albumId)).stream()
            .map(PhotoResponse::of)
            .toList();
    }
}
