package com.lluis.bcncalbumes.adapter.in.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumsEndpoint {

    @GetMapping
    List<AlbumResponse> getAllAlbums() {
        throw new UnsupportedOperationException();
    }
}
