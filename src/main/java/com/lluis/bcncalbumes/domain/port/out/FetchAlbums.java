package com.lluis.bcncalbumes.domain.port.out;

import java.util.List;

import com.lluis.bcncalbumes.domain.model.Album;

public interface FetchAlbums {
    List<Album> fetchAllAlbums();
}
