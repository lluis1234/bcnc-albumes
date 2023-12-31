package com.lluis.bcncalbumes.adapter.in.api;

import com.lluis.bcncalbumes.domain.model.Album;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "Album")
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AlbumResponse {
    private Long id;
    private Long userId;
    private String title;

    public static AlbumResponse of(Album album) {
        return new AlbumResponse(
            album.getId().getValue(),
            album.getUser().getId().getValue(),
            album.getTitle());
    }
}
