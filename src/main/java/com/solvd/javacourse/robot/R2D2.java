package com.solvd.javacourse.robot;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.exception.UnitNullException;
import com.solvd.javacourse.unit.Unit;

public final class R2D2 extends Robot implements IRobot {
	private final int batteryCharge = 100; // final attribute
	private final static String PHRASE = "Beep Bloop Blop Bleep Boop"; // final static attribute
	static int FLAMETHROWER_DAMAGE; // static attribute
	private final static Logger LOG = Logger.getLogger(R2D2.class.getName());

	static {
		FLAMETHROWER_DAMAGE = 15; // static block
	}

	public R2D2() {
		super();
		this.name = "R2D2";
	}

	public void chargeBattery() {
		if (battery < 100) {
			this.battery = batteryCharge;
			LOG.log(Level.INFO, "Charging... \nCharging...\nThe battery is fully charged.");
		} else {
			LOG.log(Level.INFO, "The battery is fully charged.");
		}
	}

	public void talk() {
		// static method
		LOG.log(Level.INFO, PHRASE);
	}

	public final void useFlamethrower(Unit enemyUnit) {
		// final method
		try {
			if (enemyUnit == null) {
				throw new UnitNullException();
			}
			if (enemyUnit.getHealth() > 0) {
				enemyUnit.setHealth(enemyUnit.getHealth() - FLAMETHROWER_DAMAGE);
				this.fuel -= 25;
				this.battery -= 25;
				LOG.log(Level.INFO, "R2D2 uses flamethrower and does " + FLAMETHROWER_DAMAGE
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
		} catch (UnitNullException e) {
			LOG.log(Level.INFO, e.getMessage());
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(batteryCharge);
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
		R2D2 other = (R2D2) obj;
		return batteryCharge == other.batteryCharge;
	}

	@Override
	public String toString() {
		return "R2D2 [name=" + name + ", battery=" + battery + ", fuel=" + fuel + "]";
	}

}
