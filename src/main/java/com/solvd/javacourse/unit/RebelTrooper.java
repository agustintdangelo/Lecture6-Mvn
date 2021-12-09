package com.solvd.javacourse.unit;

import com.solvd.javacourse.enums.Side;

public class RebelTrooper extends Unit {

	public RebelTrooper(int soldierId, Side side) {
		super(soldierId, side);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RebelTrooper [health=" + health + ", stamina=" + stamina + ", unitId=" + unitId + ", isAlive=" + isAlive
				+ ", side=" + side + "]";
	}

}
