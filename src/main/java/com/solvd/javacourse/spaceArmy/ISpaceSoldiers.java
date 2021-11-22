package com.solvd.javacourse.spaceArmy;

import com.solvd.javacourse.unit.Unit;

public interface ISpaceSoldiers {
	public void attackEnemyLeaderWithUnits(SpaceArmy enemySpaceArmy);

	public void attackEnemyUnitsWithUnits(SpaceArmy enemySpaceArmy);

	public void travelToAnotherPlanet(String planet);

	public void allUnitsRun();

	public void addUnit(Unit unitToAdd);
}
