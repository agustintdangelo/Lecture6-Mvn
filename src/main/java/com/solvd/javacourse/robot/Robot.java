package com.solvd.javacourse.robot;

import java.util.Objects;

public class Robot {
	String name;
	int battery, fuel;

	public Robot() {
		this.battery = 100;
		this.fuel = 100;
	}

	public void chargeBattery() {
		if (battery < 100) {
			this.battery = 100;
			System.out.println( "Charging... \nCharging...\nThe battery is fully charged.");
		} else {
			System.out.println( "The battery is fully charged.");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(battery, fuel, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Robot other = (Robot) obj;
		return battery == other.battery && fuel == other.fuel && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Robot [name=" + name + ", battery=" + battery + ", fuel=" + fuel + "]";
	}

	public void talk() {
		// TODO Auto-generated method stub
	}
	
	
}
