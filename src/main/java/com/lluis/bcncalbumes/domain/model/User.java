package com.lluis.bcncalbumes.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.lluis.bcncalbumes.common.Validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
public class User implements Validator {
    private UserId id;

    @Override
    public List<String> validate() {
        var errors = new ArrayList<String>();
        if (id == null || id.getValue() == null) { errors.add("user id is null"); }
        return errors;
    }

    @Value
    public static class UserId {
        private Long value;
    }
}
