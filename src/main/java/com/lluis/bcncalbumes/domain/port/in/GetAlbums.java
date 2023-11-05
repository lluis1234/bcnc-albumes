package com.lluis.bcncalbumes.domain.port.in;

import java.util.List;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.model.Album;

public interface GetAlbums {
    List<Album> getAllAlbums() throws ValidationException;
}
