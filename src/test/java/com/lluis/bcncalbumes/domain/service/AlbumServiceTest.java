package com.lluis.bcncalbumes.domain.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.User;
import com.lluis.bcncalbumes.domain.model.User.UserId;
import com.lluis.bcncalbumes.domain.port.out.FetchAlbums;

class AlbumServiceTest {
    @Mock
    private FetchAlbums fetchAlbums;
    private AlbumService underTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        underTest = new AlbumService(fetchAlbums);
    }

    @Test
    void testGetAllAlbums() throws ValidationException {
        when(fetchAlbums.fetchAllAlbums())
            .thenReturn(Arrays.asList(new Album(null)));
        assertThrows(ValidationException.class, () -> underTest.getAllAlbums());
    }

    @Test
    void testGetAllAlbums2() throws ValidationException {
        var album = new Album(new AlbumId(1L), new User(new UserId(2L)), "title");
        when(fetchAlbums.fetchAllAlbums())
            .thenReturn(Arrays.asList(album));
        assertDoesNotThrow(() -> underTest.getAllAlbums());
    }
}
