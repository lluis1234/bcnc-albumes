package com.lluis.bcncalbumes.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.lluis.bcncalbumes.common.Validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo implements Validator {
    private PhotoId id;
    private Album album;
    private String title;
    private String url;
    private String thumbnailUrl;

    @Override
    public List<String> validate() {
        // Validations could be better, but it is not for a real project
        var errors = new ArrayList<String>();
        if (id == null || id.getValue() == null) { errors.add("photo id is null"); }
        if (album == null || album.getId() == null || album.getId().getValue() == null) { errors.add("photo is not in an album"); }
        if (title == null) { errors.add("title of photo is null"); }
        if (url == null) { errors.add("photo url is null"); }
        if (thumbnailUrl == null) { errors.add("photo thumbnailUrl is null"); }
        return errors;
    }

    @Value
    public static class PhotoId {
        private Long value;
    }
}
