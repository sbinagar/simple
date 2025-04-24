package com.acts.fruits.predicates;

import java.util.function.Predicate;

import com.acts.fruits.Apple;

public class AppleColorPredicate implements Predicate<Apple>{

	
	@Override
	public boolean test(Apple t) {
		return "Green".equals(t.getColor());
	}

}
