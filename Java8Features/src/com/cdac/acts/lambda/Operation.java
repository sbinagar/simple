package com.cdac.acts.lambda;

@FunctionalInterface
public interface Operation<T> {
	T operate(T a, T b);// by default public and abstract

}
