package com.example.learningenum.constants;


import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public interface EnumConverter {
	Integer getCode();

	static <E extends Enum<?> & EnumConverter> Optional<E> codeOf(Class<E> elementType, Integer value) {
		return Arrays.stream(elementType.getEnumConstants()).filter(e -> Objects.equals(e.getCode(), value)).findAny();
	}

}
