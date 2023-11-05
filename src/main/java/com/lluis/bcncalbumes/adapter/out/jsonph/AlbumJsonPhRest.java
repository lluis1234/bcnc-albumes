package com.lluis.bcncalbumes.adapter.out.jsonph;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.port.out.FetchAlbums;

@Component
public class AlbumJsonPhRest implements FetchAlbums {

    @Override
    public List<Album> fetchAllAlbums() {
        throw new UnsupportedOperationException();
    }
    
}
