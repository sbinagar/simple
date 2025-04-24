package com.cdac.acts.streams;

import java.util.Optional;

public class OptionalTester {

	public static void main(String[] args) {
	Optional<String> strOpt = Optional.of("Hi");
	Optional<String> strOpt1 = Optional.of(null);
	strOpt1.isPresent();//Value is present
	strOpt1.ifPresent(s -> s.toUpperCase());//
	String str = strOpt1.orElse("No value");
	strOpt1.orElseThrow(() -> new RuntimeException());
	}

}
