package com.lluis.bcncalbumes.adapter.out.jsonph;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.Photo;
import com.lluis.bcncalbumes.domain.model.Photo.PhotoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoJsonPhDto {
    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo mapToDomain() {
        return new Photo(
            id == null ? null : new PhotoId(id),
            albumId == null ? null : new Album(new AlbumId(albumId)),
            title,
            url,
            thumbnailUrl);
    }
}
