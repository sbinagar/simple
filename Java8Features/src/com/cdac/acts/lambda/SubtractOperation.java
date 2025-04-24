package com.cdac.acts.lambda;

public class SubtractOperation implements Operation<Double>{

	@Override
	public Double operate(Double a, Double b) {
		return a - b;
	}

}
