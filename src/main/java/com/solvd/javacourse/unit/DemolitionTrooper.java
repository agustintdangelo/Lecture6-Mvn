package com.solvd.javacourse.unit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemolitionTrooper extends Unit implements IDemolition {
	private static final int DAMAGE = 70;
	private static final int MISSILE_DAMAGE = 100;
	private final static Logger LOG = Logger.getLogger(DemolitionTrooper.class.getName());

	public DemolitionTrooper(int unitId) {
		super(unitId);
		this.side = "Empire";
	}

	@Override
	public void attack(Unit enemyUnit) {
		if (enemyUnit.getHealth() > 0) {
			enemyUnit.setHealth(enemyUnit.getHealth() - DAMAGE);
			this.stamina -= 40;
//			System.out.println("The unit does " + DAMAGE + " damage to the enemy number: " + enemyUnit.getUnitId());
			LOG.log(Level.INFO, "The unit does " + DAMAGE + " damage to the enemy number: " + enemyUnit.getUnitId());
			if (enemyUnit.getHealth() <= 0) {
				enemyUnit.setHealth(0);
//				System.out.println("An enemy has been defeated!");
				LOG.log(Level.SEVERE, "An enemy has been defeated!");
			}
//			System.out.println("The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
//					+ enemyUnit.getHealth());
			LOG.log(Level.INFO, "The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
					+ enemyUnit.getHealth());

//			System.out.println("---------------------------------------------------------------");
		} else {
//			System.out.println("---------------------------------------------------------------");
//			System.out.println("The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
			LOG.log(Level.WARNING, "The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
		}
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
		return "DemolitionTrooper [health=" + health + ", stamina=" + stamina + ", unitId=" + unitId + ", isAlive="
				+ isAlive + ", side=" + side + "]";
	}

	@Override
	public void missileAttack(Unit enemyUnit) {
		if (enemyUnit.getHealth() > 0) {
			enemyUnit.setHealth(enemyUnit.getHealth() - MISSILE_DAMAGE);
			this.stamina -= 40;
			LOG.log(Level.INFO, "The unit attacks with missiles and does " + MISSILE_DAMAGE
					+ " damage to the enemy number: " + enemyUnit.getUnitId());
			if (enemyUnit.getHealth() <= 0) {
				enemyUnit.setHealth(0);
				LOG.log(Level.WARNING, "An enemy has been defeated!");
			}
			LOG.log(Level.INFO, "The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
					+ enemyUnit.getHealth());
		} else {
			LOG.log(Level.WARNING, "The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
		}
	}

}
