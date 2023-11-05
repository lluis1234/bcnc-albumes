package com.lluis.bcncalbumes.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import com.lluis.bcncalbumes.domain.port.out.FetchPhotos;

class PhotoServiceTest {
    @Mock private FetchPhotos fetchPhotos;
    @InjectMocks private PhotoService underTest;
    private Photo tmpPhoto;
    private Photo tmpPhotoErr;

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
        tmpPhotoErr = new Photo();
    }

    @Test
    void testGetPhotoId() throws NoSuchElementException, ValidationException {
        when(fetchPhotos.fetch(any(PhotoId.class)))
            .thenReturn(Optional.of(tmpPhoto));
        var result = underTest.get(new PhotoId(1L));
        assertEquals(tmpPhoto, result);
    }

    @Test
    void testGetPhotoId_validationError() throws NoSuchElementException, ValidationException {
        when(fetchPhotos.fetch(any(PhotoId.class)))
            .thenReturn(Optional.of(tmpPhotoErr));
        assertThrows(ValidationException.class, () -> underTest.get(new PhotoId(1L)));
    }

    @Test
    void testGetByPhotoId_fetchPhotosEmpty() {
        when(fetchPhotos.fetch(any(PhotoId.class)))
            .thenReturn(Optional.empty());
        var photoId = new PhotoId(1L);
        assertThrows(
            NoSuchElementException.class,
            () -> underTest.get(photoId));
    }

    @Test
    void testGetByAlbumId() throws ValidationException {
        when(fetchPhotos.fetch(any(AlbumId.class)))
            .thenReturn(Arrays.asList(tmpPhoto));
        var results = underTest.get(new AlbumId(2L));
        assertEquals(1, results.size());
        assertEquals(tmpPhoto, results.get(0));
    }

    @Test
    void testGetByAlbumId_validationError() throws ValidationException {
        when(fetchPhotos.fetch(any(AlbumId.class)))
            .thenReturn(Arrays.asList(tmpPhotoErr));
        assertThrows(ValidationException.class, () -> underTest.get(new AlbumId(2L)));
    }
}
