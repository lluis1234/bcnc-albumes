package com.lluis.bcncalbumes.adapter.in.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotosEndpoint {
    
    @GetMapping("/{id}")
    PhotoResponse getPhotoById(@PathVariable Long id) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    List<PhotoResponse> getPhotosByAlbumId(@RequestParam Long albumId) {
        throw new UnsupportedOperationException();
    }
}
