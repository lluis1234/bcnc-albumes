package com.lluis.bcncalbumes.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationException extends Exception {
    private final List<String> errors;
}
