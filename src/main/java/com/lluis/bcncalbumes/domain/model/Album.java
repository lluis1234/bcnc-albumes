package com.lluis.bcncalbumes.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.lluis.bcncalbumes.common.Validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
public class Album implements Validator {
    private AlbumId id;
    private User user;
    private String title;

    public Album(AlbumId id) {
        this.id = id;
    }

    @Override
    public List<String> validate() {
        var errors = new ArrayList<String>();
        if (id == null || id.getValue() == null) { errors.add("id is null"); }
        if (user == null || user.getId() == null || user.getId().getValue() == null) { errors.add("user is null"); }
        if (title == null) { errors.add("title is null"); }
        return errors;
    }

    @Value
    public static class AlbumId {
        private Long value;
    }
}
