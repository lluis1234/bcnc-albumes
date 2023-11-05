package com.lluis.bcncalbumes.domain.model;

import static org.assertj.core.api.ListAssert.assertThatList;

import org.junit.jupiter.api.Test;

import com.lluis.bcncalbumes.domain.model.User.UserId;

class UserTest {
    @Test
    void testValidate() {
        var user = new User(null);
        var errors = user.validate();
        assertThatList(errors).contains("user id is null");

        user.setId(new UserId(null));
        errors = user.validate();
        assertThatList(errors).contains("user id is null");

        user.setId(new UserId(3L));
        errors = user.validate();
        assertThatList(errors).doesNotContain("user id is null");
    }
}
