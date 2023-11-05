package com.lluis.bcncalbumes.adapter.in.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;

public class PhotoResponseTest {
    @Test
    void testOf() {
        var photo = new Photo(
            new PhotoId(1L),
            new Album(new AlbumId(2L)),
            "title",
            "url",
            "thumbnailUrl");
        var photoResponse = PhotoResponse.of(photo);
        assertEquals(photo.getId().getValue(), photoResponse.getId());
        assertEquals(photo.getAlbum().getId().getValue(), photoResponse.getAlbumId());
        assertEquals(photo.getTitle(), photoResponse.getTitle());
        assertEquals(photo.getUrl(), photoResponse.getUrl());
        assertEquals(photo.getThumbnailUrl(), photoResponse.getThumbnailUrl());
    }
}