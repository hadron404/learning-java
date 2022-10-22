package com.example.learningenum.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YesNoEnum implements EnumConverter {
	YES(1, "是"),
	NO(0, "否");

	private final Integer code;
	private final String desc;
}
