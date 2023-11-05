package com.lluis.bcncalbumes.adapter.in.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.User;
import com.lluis.bcncalbumes.domain.model.User.UserId;

class AlbumResponseTest {
    @Test
    void testOf() {
        var album = new Album(
            new AlbumId(1L),
            new User(new UserId(2L)),
            "title"
        );
        var albumResponse = AlbumResponse.of(album);
        assertEquals(album.getId().getValue(), albumResponse.getId());
        assertEquals(album.getUser().getId().getValue(), albumResponse.getUserId());
        assertEquals(album.getTitle(), albumResponse.getTitle());
    }
}
