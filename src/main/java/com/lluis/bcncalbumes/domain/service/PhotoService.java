package com.lluis.bcncalbumes.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;
import com.lluis.bcncalbumes.domain.port.in.GetPhotos;
import com.lluis.bcncalbumes.domain.port.out.FetchPhotos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PhotoService implements GetPhotos {
    private final FetchPhotos fetchPhotos;

    @Override
    public Photo get(PhotoId photoId) throws NoSuchElementException, ValidationException {
        var photo = fetchPhotos.fetch(photoId).orElseThrow(NoSuchElementException::new);
        var errors = photo.validate();
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
        return photo;
    }

    @Override
    public List<Photo> get(AlbumId albumId) throws ValidationException {
        var photos = fetchPhotos.fetch(albumId);
        for (var photo : photos) {
            var errors = photo.validate();
            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }
        }
        return photos;
    }

}
