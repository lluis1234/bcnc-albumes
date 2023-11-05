package com.lluis.bcncalbumes.adapter.in.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;
import com.lluis.bcncalbumes.domain.port.in.GetPhotos;

class PhotosEndpointTest {
    @Mock private GetPhotos getPhotos;
    @InjectMocks private PhotosEndpoint underTest;
    private Photo tmpPhoto;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        tmpPhoto = new Photo(
            new PhotoId(1L),
            new Album(new AlbumId(2L)),
            "title",
            "url",
            "thumbnailUrl"
        );
    }

    @Test
    void testGetPhotoById() throws NoSuchElementException, ValidationException {
        when(getPhotos.get(any(PhotoId.class))).thenReturn(tmpPhoto);
        var result = underTest.getPhotoById(1L);
        assertEquals(tmpPhoto.getId().getValue(), result.getId());
        assertEquals(tmpPhoto.getAlbum().getId().getValue(), result.getAlbumId());
        assertEquals(tmpPhoto.getTitle(), result.getTitle());
        assertEquals(tmpPhoto.getUrl(), result.getUrl());
        assertEquals(tmpPhoto.getThumbnailUrl(), result.getThumbnailUrl());
    }

    @Test
    void testGetPhotosByAlbumId() throws ValidationException {
        when(getPhotos.get(any(AlbumId.class))).thenReturn(Arrays.asList(tmpPhoto));
        var results = underTest.getPhotosByAlbumId(2L);
        assertEquals(1, results.size());
        var firstResult = results.get(0);
        assertEquals(tmpPhoto.getId().getValue(), firstResult.getId());
        assertEquals(tmpPhoto.getAlbum().getId().getValue(), firstResult.getAlbumId());
        assertEquals(tmpPhoto.getTitle(), firstResult.getTitle());
        assertEquals(tmpPhoto.getUrl(), firstResult.getUrl());
        assertEquals(tmpPhoto.getThumbnailUrl(), firstResult.getThumbnailUrl());
    }
}
