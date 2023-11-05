package com.lluis.bcncalbumes.adapter.out.jsonph;

import com.lluis.bcncalbumes.domain.model.Album;
import com.lluis.bcncalbumes.domain.model.Album.AlbumId;
import com.lluis.bcncalbumes.domain.model.User;
import com.lluis.bcncalbumes.domain.model.User.UserId;

import lombok.Data;

@Data
public class AlbumJsonPhDto {
    private Long id;
    private Long userId;
    private String title;
    
    public Album mapToDomain() {
        return new Album(
            new AlbumId(id),
            new User(new UserId(userId)),
            title);
    }
}
