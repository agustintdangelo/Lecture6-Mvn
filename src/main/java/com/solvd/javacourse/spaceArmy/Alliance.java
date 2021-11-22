package com.solvd.javacourse.spaceArmy;

import com.solvd.javacourse.generic.GenericCustomLinkedList;
import com.solvd.javacourse.unit.Leader;
import com.solvd.javacourse.unit.Unit;

public class Alliance extends SpaceArmy {

	public Alliance(Leader leader, GenericCustomLinkedList<Unit> units, String location) {
		super("Alliance", leader, units, location);
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
		return "Alliance [leader=" + leader + ", units=" + units + ", location=" + getLocation() + "]";
	}

}
