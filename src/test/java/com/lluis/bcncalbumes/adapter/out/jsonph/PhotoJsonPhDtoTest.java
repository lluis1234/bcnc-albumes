package com.lluis.bcncalbumes.adapter.out.jsonph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PhotoJsonPhDtoTest {
    @Test
    void testMapToDomain() {
        var photoJsonPh = new PhotoJsonPhDto(
            1L,
            2L,
            "title",
            "url",
            "thumbnailUrl"
        );
        var photo = photoJsonPh.mapToDomain();
        assertEquals(photoJsonPh.getId(), photo.getId().getValue());
        assertEquals(photoJsonPh.getAlbumId(), photo.getAlbum().getId().getValue());
        assertEquals(photoJsonPh.getTitle(), photo.getTitle());
        assertEquals(photoJsonPh.getUrl(), photo.getUrl());
        assertEquals(photoJsonPh.getThumbnailUrl(), photo.getThumbnailUrl());
    }
}
