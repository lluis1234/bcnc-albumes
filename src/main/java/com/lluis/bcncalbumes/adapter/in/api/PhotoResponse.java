package com.lluis.bcncalbumes.adapter.in.api;

import com.lluis.bcncalbumes.domain.model.Photo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotoResponse {
    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public static PhotoResponse of(Photo photo) {
        return new PhotoResponse(
            photo.getId().getValue(),
            photo.getAlbum().getId().getValue(),
            photo.getTitle(),
            photo.getUrl(),
            photo.getThumbnailUrl());
    }
}
