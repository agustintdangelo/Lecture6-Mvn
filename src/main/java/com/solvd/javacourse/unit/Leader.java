package com.solvd.javacourse.unit;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.exception.*;

public class Leader extends Unit implements IForceUser {
	String name;
	int force;
	private static final int DAMAGE = 100;
	private static final int FORCE_DAMAGE = 500;
	private final static Logger LOG = Logger.getLogger(Leader.class.getName());

	public Leader(String name, int force, int unitId, String side) throws WrongNameException {
		super(unitId);
		if (isNumeric(name) || name == null || name.trim().isEmpty()) {
			throw new WrongNameException();
		} else {
			this.name = name;
			this.health = 1000;
			this.stamina = 1000;
			this.force = force;
			this.side = side;
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(.\\d+)?");
	}

	@Override
	public void attack(Unit enemyUnit) {
		if (enemyUnit.getHealth() > 0) {
			enemyUnit.setHealth(enemyUnit.getHealth() - DAMAGE);
			this.stamina -= 50;
			LOG.log(Level.INFO,
					this.name + " does " + DAMAGE + " damage to the enemy number: " + enemyUnit.getUnitId());
			if (enemyUnit.getHealth() <= 0) {
				LOG.log(Level.WARNING, "An enemy has been defeated!");
				enemyUnit.setHealth(0);
				enemyUnit.setAlive(false);
			}
			LOG.log(Level.INFO, "The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
					+ enemyUnit.getHealth());
		} else {
			LOG.log(Level.WARNING, "The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
		}
	}

	@Override
	public void forceAttack(Unit enemyUnit) {
		if (enemyUnit.getHealth() > 0) {
			enemyUnit.setHealth(enemyUnit.getHealth() - FORCE_DAMAGE);
			this.force -= 50;
			LOG.log(Level.INFO, this.name + " uses the Force and does " + FORCE_DAMAGE + " damage to the enemy number: "
					+ enemyUnit.getUnitId());
			if (enemyUnit.getHealth() <= 0) {
				LOG.log(Level.WARNING,"An enemy has been defeated!");
				enemyUnit.setHealth(0);
				enemyUnit.setAlive(false);
			}
			LOG.log(Level.INFO,"The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
					+ enemyUnit.getHealth());
		} else {
			LOG.log(Level.INFO,"The enemy unit " + enemyUnit.getUnitId() + " is dead so you can't attack it.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(force, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leader other = (Leader) obj;
		return force == other.force && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Leader [name=" + name + ", force=" + force + ", health=" + health + ", stamina=" + stamina + ", unitId="
				+ unitId + ", isAlive=" + isAlive + ", side=" + side + "]";
	}

}
