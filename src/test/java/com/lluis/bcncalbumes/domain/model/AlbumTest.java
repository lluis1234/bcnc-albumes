package com.lluis.bcncalbumes.domain.model;

import static org.assertj.core.api.ListAssert.assertThatList;

import org.junit.jupiter.api.Test;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.User.UserId;

class AlbumTest {

    @Test
    void testValidate() {
        var album = new Album(null, null, null);
        var errors = album.validate();
        assertThatList(errors).contains(
            "id is null",
            "user is null",
            "title is null"
        );
    }

    @Test
    void testValidate2() {
        var album = new Album(new AlbumId(null), new User(null), null);
        var errors = album.validate();
        assertThatList(errors).contains(
            "id is null",
            "user is null",
            "title is null"
        );
    }

    @Test
    void testValidate3() {
        var album = new Album(null, new User(new UserId(null)), null);
        var errors = album.validate();
        assertThatList(errors).contains(
            "id is null",
            "user is null",
            "title is null"
        );
    }

    @Test
    void testValidate4() {
        var album = new Album(new AlbumId(1L), new User(new UserId(3L)), "");
        var errors = album.validate();
        assertThatList(errors).doesNotContain(
            "id is null",
            "user is null",
            "title is null"
        );
    }
}
