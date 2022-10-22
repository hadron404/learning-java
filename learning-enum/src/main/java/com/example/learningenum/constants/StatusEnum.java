package com.example.learningenum.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum implements EnumConverter {
    STARTED(1, "启用"),
    STOPPED(0, "停用");

    private final Integer code;
    private final String desc;
}
