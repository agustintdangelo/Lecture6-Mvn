package com.solvd.javacourse.lambda;

@FunctionalInterface
public interface TriFunction<S1, S2, S3> {
	public abstract Integer apply(S1 s1, S2 s2, S3 s3);
}
