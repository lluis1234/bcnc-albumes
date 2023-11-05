package com.lluis.bcncalbumes.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;

public interface FetchPhotos {
    Optional<Photo> fetch(PhotoId photoId);
    List<Photo> fetch(AlbumId albumId);
}
