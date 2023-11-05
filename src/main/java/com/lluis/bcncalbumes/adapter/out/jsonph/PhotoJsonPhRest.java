package com.lluis.bcncalbumes.adapter.out.jsonph;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.common.Constants;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;
import com.lluis.bcncalbumes.domain.port.out.FetchPhotos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PhotoJsonPhRest implements FetchPhotos {
    private final RestTemplate restTemplate;

    @Override
    public Optional<Photo> fetch(PhotoId photoId) {
        var photo = restTemplate.getForObject(
            Constants.JSON_PH_URL + "photos/" + photoId.getValue(),
            PhotoJsonPhDto.class);
        if (photo == null) {
            return Optional.empty();
        }
        return Optional.of(photo.mapToDomain());
    }

    @Override
    public List<Photo> fetch(AlbumId albumId) {
        var results = restTemplate.getForObject(
            Constants.JSON_PH_URL + "photos?albumId=" + albumId.getValue(),
            PhotoJsonPhDto[].class);
        return Arrays.asList(results).stream()
            .map(e -> e.mapToDomain())
            .toList();
    }
    
}
