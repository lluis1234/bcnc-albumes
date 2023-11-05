package com.lluis.bcncalbumes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.port.in.GetAlbums;

@Service
public class AlbumService implements GetAlbums {

    @Override
    public List<Album> getAllAlbums() {
        throw new UnsupportedOperationException();
    }

}
