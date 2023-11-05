package com.lluis.bcncalbumes.domain.model;

import static org.assertj.core.api.ListAssert.assertThatList;

import org.junit.jupiter.api.Test;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;

class PhotoTest {
    @Test
    void testValidate() {
        var photo = new Photo(null, null, null, null, null);
        var errors = photo.validate();
        assertThatList(errors).contains(
            "photo id is null",
            "photo is not in an album",
            "title of photo is null",
            "photo url is null",
            "photo thumbnailUrl is null");
    }

    @Test
    void testValidate2() {
        var photo = new Photo(new PhotoId(null), new Album(null), null, null, null);
        var errors = photo.validate();
        assertThatList(errors).contains(
            "photo id is null",
            "photo is not in an album",
            "title of photo is null",
            "photo url is null",
            "photo thumbnailUrl is null");
    }

    @Test
    void testValidate3() {
        var photo = new Photo(null, new Album(new AlbumId(null)), null, null, null);
        var errors = photo.validate();
        assertThatList(errors).contains(
            "photo id is null",
            "photo is not in an album",
            "title of photo is null",
            "photo url is null",
            "photo thumbnailUrl is null");
    }
}
