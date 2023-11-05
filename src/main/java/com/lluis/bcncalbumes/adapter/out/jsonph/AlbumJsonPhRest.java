package com.lluis.bcncalbumes.adapter.out.jsonph;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lluis.bcncalbumes.common.Constants;
import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.port.out.FetchAlbums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AlbumJsonPhRest implements FetchAlbums {
    private final RestTemplate restTemplate;

    @Override
    public List<Album> fetchAllAlbums() {
        var results = restTemplate.getForObject(Constants.JSON_PH_URL + "albums", AlbumJsonPhDto[].class);
        return Arrays.asList(results).stream()
            .map(e -> e.mapToDomain())
            .toList();
    }
    
}
