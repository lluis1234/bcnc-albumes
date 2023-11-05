package com.lluis.bcncalbumes.domain.service;

import java.util.List;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.port.in.GetAlbums;

public class PhotoService implements GetAlbums {

    @Override
    public List<Album> getAllAlbums() {
        throw new UnsupportedOperationException();
    }
    
}
