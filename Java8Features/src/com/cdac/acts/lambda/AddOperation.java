package com.cdac.acts.lambda;

public class AddOperation implements Operation<Double>{

	@Override
	public Double operate(Double a, Double b) {
		return a * b;
	}

}
