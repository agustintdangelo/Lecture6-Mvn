package com.solvd.javacourse.lambda;

import com.solvd.javacourse.unit.Unit;

@FunctionalInterface
public interface UnitFinder {
	public abstract Unit find(Unit unit);
}
