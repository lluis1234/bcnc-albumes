package com.lluis.bcncalbumes.adapter.in.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lluis.bcncalbumes.common.ValidationException;
import com.lluis.bcncalbumes.domain.port.in.GetAlbums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/albums")
public class AlbumsEndpoint {
    private final GetAlbums getAlbums;

    @GetMapping
    List<AlbumResponse> getAllAlbums() throws ValidationException {
        return getAlbums.getAllAlbums().stream()
            .map(AlbumResponse::of)
            .toList();
    }
}
