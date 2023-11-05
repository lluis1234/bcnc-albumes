package com.lluis.bcncalbumes.domain.port.in;

import java.util.List;
import java.util.NoSuchElementException;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;

public interface GetPhotos {
    Photo get(PhotoId photoId) throws NoSuchElementException, ValidationException;
    List<Photo> get(AlbumId albumId) throws ValidationException;
}
