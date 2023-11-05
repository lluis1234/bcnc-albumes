package com.lluis.bcncalbumes.adapter.out.jsonph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;

class PhotoJsonPhRestTest {
    @Mock
    private RestTemplate restTemplate;
    private PhotoJsonPhRest underTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        underTest = new PhotoJsonPhRest(restTemplate);
    }

    @Test
    void testFetchByPhotoId() {
        when(restTemplate.getForObject(anyString(), any()))
            .thenReturn(new PhotoJsonPhDto());
        var result = underTest.fetch(new PhotoId(null));
        assertEquals(new Photo(), result.get());
    }

    @Test
    void testFetchByPhotoId_photoIsNull() {
        when(restTemplate.getForObject(anyString(), any()))
            .thenReturn(null);
        var result = underTest.fetch(new PhotoId(null));
        assertTrue(result.isEmpty());
    }

    @Test
    void testFetchByAlbumId() {
        when(restTemplate.getForObject(anyString(), any()))
            .thenReturn(new PhotoJsonPhDto[]{ new PhotoJsonPhDto() });
        var result = underTest.fetch(new AlbumId(null));
        assertEquals(1, result.size());
        assertEquals(new Photo(), result.get(0));
    }
}
