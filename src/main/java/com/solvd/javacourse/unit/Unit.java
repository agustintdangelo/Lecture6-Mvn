package com.solvd.javacourse.unit;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.enums.Side;
import com.solvd.javacourse.exception.*;

public abstract class Unit implements IAttacker, IInformation {
	private static final int DAMAGE = 20;
	private static final int MAX_HEALTH = 100;
	protected int health;
	protected Integer stamina;
	protected int unitId;
	protected boolean isAlive;
	protected Side side;
	private final static Logger LOG = Logger.getLogger(Unit.class.getName());

	public Unit(int unitId, Side side2) {
		this.health = 100;
		this.stamina = 100;
		this.unitId = unitId;
		this.isAlive = true;
		this.side = side2;
	}

	public Side getSide() {
		return side;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int soldierId) {
		this.unitId = soldierId;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getMaxHealth() {
		return MAX_HEALTH;
	}

// 
//	public BiConsumer<Integer, Unit> staminaRecover = (s, u) -> {
////		if(this.stamina<0) {
////			throw new StaminaNegativeException();
////		} else {
//			u.setStamina(u.getStamina()+s);
////		}
//	};
//	
	public void staminaRecovery(Integer stamina) {
//		this.staminaRecover(stamina, this);

	}

//	public void staminaRecover(int stamina) throws StaminaNegativeException {
//		if (stamina < 0) {
//			throw new StaminaNegativeException();
//		} else {
//			this.stamina += stamina;
//		}
//	}

	public void healthRecover(int health) throws DeadUnitException, HealthNegativeException {

		try {
			if (health < 0) {
				throw new HealthNegativeException();
			}
			if (!this.isAlive) {
				throw new DeadUnitException();
			} else {
				this.health += health;
			}
		} catch (HealthNegativeException e) {
			LOG.log(Level.INFO, e.getMessage());
		} catch (DeadUnitException e) {
			LOG.log(Level.INFO, e.getMessage());
		}

	}

	public void attack(Unit enemyUnit) {
		if (enemyUnit.health > 0) {
			enemyUnit.health -= DAMAGE;
			this.stamina -= 10;
			LOG.log(Level.INFO, "The unit " + this.unitId + " does " + DAMAGE + " damage to the enemy number: "
					+ enemyUnit.getUnitId());
			if (enemyUnit.health <= 0) {
				LOG.log(Level.WARNING, "An enemy has been defeated!");
				enemyUnit.setHealth(0);
				enemyUnit.setAlive(false);
			}
			LOG.log(Level.INFO, "The health of the enemy unit number " + enemyUnit.getUnitId() + " now is: "
					+ enemyUnit.getHealth());
		} else {
			LOG.log(Level.INFO, "The enemy unit " + enemyUnit.unitId + " is dead so you can't attack it.");
		}
	}

	public void run() {
		if (this.stamina > 0) {
			this.stamina -= 20;
			LOG.log(Level.INFO, "The unit " + this.getUnitId() + " runs and the stamina goes down by 20 points.");
		} else {
			LOG.log(Level.INFO, "The unit " + this.getUnitId() + " doesn't have enough stamina");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(health, isAlive, side, stamina, unitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		return health == other.health && isAlive == other.isAlive && Objects.equals(side, other.side)
				&& stamina == other.stamina && unitId == other.unitId;
	}

	@Override
	public String toString() {
		return "Unit [health=" + health + ", stamina=" + stamina + ", unitId=" + unitId + ", isAlive=" + isAlive
				+ ", side=" + side + "]";
	}

}
