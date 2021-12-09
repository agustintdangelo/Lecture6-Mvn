package com.solvd.javacourse.enums;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.unit.Unit;

public enum SpaceShip {
	TIE_FIGHTER("StormTrooper", 100, false), MILLENIUM_FALCON("Han Solo", 500, false),
	AT_ST("General Grievous", 300, false), AT_AT("Moff Tarkin", 600, false), X_WING("RebelTrooper", 100, false);

	private final static Logger LOG = Logger.getLogger(SpaceShip.class.getName());
	private String pilot;
	private int damage;
	private boolean needsRepair;

	private SpaceShip(String pilot, int damage, boolean needsRepair) {
		this.pilot = pilot;
		this.damage = damage;
		this.setNeedsRepair(needsRepair);
	}

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isNeedsRepair() {
		return needsRepair;
	}

	public void setNeedsRepair(boolean needsRepair) {
		this.needsRepair = needsRepair;
	}

	public void attackUnit(Unit enemyUnit) {
		if (!needsRepair) {
			if (enemyUnit.getHealth() > 0) {
				enemyUnit.setHealth(enemyUnit.getHealth() - damage);
				LOG.log(Level.INFO,
						"The spaceship did " + damage + " damage to the enemy number: " + enemyUnit.getUnitId());
				if (enemyUnit.getHealth() <= 0) {
					LOG.log(Level.WARNING, "An enemy has been defeated!");
					enemyUnit.setHealth(0);
					enemyUnit.setAlive(false);
				}
				LOG.log(Level.INFO, "The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
						+ enemyUnit.getHealth());
			} else {
				LOG.log(Level.INFO, "The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
			}
		} else {
			LOG.log(Level.INFO, "The spaceship needs repairment in order to attack.");
		}
	}
}
