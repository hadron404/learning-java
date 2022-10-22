package com.example.learningenum.constants;


import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public interface EnumConverter {
	Integer getCode();

	static <E extends Enum<?> & EnumConverter> Optional<E> codeOf(Class<E> elementType, @Nullable Integer value) {
		return Arrays.stream(elementType.getEnumConstants()).filter(e -> Objects.equals(e.getCode(), value)).findAny();
	}

}
