package com.lluis.bcncalbumes.domain.port.in;

import java.util.List;

import com.lluis.bcncalbumes.domain.model.Album;

public interface GetAlbums {
    List<Album> getAllAlbums();
}
