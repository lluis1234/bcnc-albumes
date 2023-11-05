package com.lluis.bcncalbumes.adapter.out.jsonph;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;
import com.lluis.bcncalbumes.domain.port.out.FetchPhotos;

@Component
public class PhotoJsonPhRest implements FetchPhotos {

    @Override
    public Optional<Photo> fetch(PhotoId photoId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Photo> fetch(AlbumId albumId) {
        throw new UnsupportedOperationException();
    }
    
}
