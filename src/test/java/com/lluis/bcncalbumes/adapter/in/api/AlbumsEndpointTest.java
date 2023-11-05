package com.lluis.bcncalbumes.adapter.in.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.User;
import com.lluis.bcncalbumes.domain.model.User.UserId;
import com.lluis.bcncalbumes.domain.port.in.GetAlbums;

class AlbumsEndpointTest {
    @Mock private GetAlbums getAlbums;
    @InjectMocks private AlbumsEndpoint underTest;
    private Album tmpAlbum;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        tmpAlbum = new Album(
            new AlbumId(2L),
            new User(new UserId(3L)),
            "title");
    }

    @Test
    void testGetAllAlbums() throws ValidationException {
        when(getAlbums.getAllAlbums())
            .thenReturn(Arrays.asList(tmpAlbum));
        var results = underTest.getAllAlbums();
        assertEquals(1, results.size());
        var firstResult = results.get(0);
        assertEquals(tmpAlbum.getId().getValue(), firstResult.getId());
        assertEquals(tmpAlbum.getUser().getId().getValue(), firstResult.getUserId());
        assertEquals(tmpAlbum.getTitle(), firstResult.getTitle());
    }   
}
