package com.solvd.javacourse.unit;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.enums.EnumLeaders;
import com.solvd.javacourse.enums.Side;
import com.solvd.javacourse.exception.*;

public class Leader extends Unit implements IForceUser {
	private EnumLeaders leader;
	int force;
	@SuppressWarnings("unused")
	private static final int MAX_HEALTH = 1000;
	private static final int DAMAGE = 100;
	private static final int FORCE_DAMAGE = 500;
	private final static Logger LOG = Logger.getLogger(Leader.class.getName());

	public Leader(EnumLeaders leader, int force, int unitId, Side side) throws WrongNameException {
		super(unitId, side);
		if (isNumeric(leader.getName()) || leader.getName() == null || leader.getName().trim().isEmpty()) {
			throw new WrongNameException();
		} else {
			this.leader = leader;
			this.health = 1000;
			this.stamina = 1000;
			this.force = force;
			this.side = side;
		}
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public EnumLeaders getLeader() {
		return leader;
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(.\\d+)?");
	}

	@Override
	public void attack(Unit enemyUnit) {
		if (enemyUnit.getHealth() > 0) {
			enemyUnit.setHealth(enemyUnit.getHealth() - DAMAGE);
			this.stamina -= 50;
			LOG.log(Level.INFO, this.leader.getName() + " does " + DAMAGE + " damage to the enemy number: "
					+ enemyUnit.getUnitId());
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
			LOG.log(Level.INFO, this.leader.getName() + " uses the Force and does " + FORCE_DAMAGE
					+ " damage to the enemy number: " + enemyUnit.getUnitId());
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
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(force, leader);
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
		return force == other.force && leader == other.leader;
	}

	@Override
	public String toString() {
		return "Leader [name=" + this.leader.getName() + ", force=" + force + ", health=" + health + ", stamina="
				+ stamina + ", unitId=" + unitId + ", isAlive=" + isAlive + ", side=" + side + "]";
	}

}
