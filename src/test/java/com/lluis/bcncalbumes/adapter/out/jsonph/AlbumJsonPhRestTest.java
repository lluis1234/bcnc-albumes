package com.lluis.bcncalbumes.adapter.out.jsonph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

class AlbumJsonPhRestTest {
    @Mock
    RestTemplate restTemplate;
    AlbumJsonPhRest underTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        underTest = new AlbumJsonPhRest(restTemplate);
    }

    @Test
    void testFetchAllAlbums() {
        when(restTemplate.getForObject(anyString(), any()))
            .thenReturn(new AlbumJsonPhDto[]{
                new AlbumJsonPhDto()
            });
        var results = underTest.fetchAllAlbums();
        assertEquals(1, results.size());
    }
}
