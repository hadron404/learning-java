package com.example.learningenum.constants;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class EnumConverterTest {

	@Test
	void name() {
		Optional<StatusEnum> result = EnumConverter.codeOf(StatusEnum.class, 1);
		Assertions.assertTrue(result.isPresent());
	}
}
