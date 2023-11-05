package com.lluis.bcncalbumes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.port.in.GetAlbums;
import com.lluis.bcncalbumes.domain.port.out.FetchAlbums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlbumService implements GetAlbums {
    private final FetchAlbums fetchAlbums;

    @Override
    public List<Album> getAllAlbums() throws ValidationException {
        var albums = fetchAlbums.fetchAllAlbums();
        for (var album : albums) {
            var errors = album.validate();
            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }
        }
        return albums;
    }

}
