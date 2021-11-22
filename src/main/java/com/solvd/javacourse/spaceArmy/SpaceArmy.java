package com.solvd.javacourse.spaceArmy;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.generic.GenericCustomLinkedList;
import com.solvd.javacourse.robot.Robot;
import com.solvd.javacourse.unit.Leader;
import com.solvd.javacourse.unit.Unit;

public abstract class SpaceArmy {
	protected Leader leader;
	protected GenericCustomLinkedList<Unit> units = new GenericCustomLinkedList<Unit>();
	private String name;
	static String location = "Endor";
	private Map<String, Integer> vehicles = new HashMap<>();
	private Set<Robot> robots = new HashSet<Robot>();

	private final static Logger LOG = Logger.getLogger(SpaceArmy.class.getName());

	public SpaceArmy(String name, Leader leader, GenericCustomLinkedList<Unit> units2, String location) {
		this.name = name;
		this.leader = leader;
		this.units = units2;
		SpaceArmy.location = location;
	}

	public void deleteUnit(int unitId) {
		int i = 0;
		while (i < this.units.size() && units.get(i).getUnitId() != unitId) {
			i++;
		}
		units.deleteAt(i);
	}

	public void printUnits() {
		System.out.println(this.name + " Units: ");
		this.units.show();
	}

	public void printRobots() {
		System.out.println(this.name + " Robots: ");
		for (Robot robot : this.robots) {
			System.out.println(robot);
		}
	}

	public void addRobot(Robot robot) {
		robots.add(robot);
	}

	public void deleteRobot(Robot robot) {
		robots.remove(robot);
	}

	public void addVehicle(String name, Integer quantity) {
		vehicles.put(name, quantity);
	}

	public void deleteVehicle(String name) {
		vehicles.remove(name);
	}

	public void printVehicles() {
		System.out.println(this.name + " Vehicles and it's quantities: ");
		for (Map.Entry<String, Integer> entry : vehicles.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	}

	public void attackEnemyLeaderWithUnits(SpaceArmy enemySpaceArmy) {
		for (int i = 0; i < this.units.size(); i++) {
			units.get(i).attack(enemySpaceArmy.leader);
		}
	}

	public int sizeUnits() {
		return units.size();
	}

	public void attackEnemyUnitsWithUnits(SpaceArmy enemySpaceArmy) {
		for (int i = 0; i < this.units.size(); i++) {
			for (int j = 0; j < enemySpaceArmy.units.size(); j++) {
				units.get(i).attack(enemySpaceArmy.units.get(j));
			}
		}
	}

	public void travelToAnotherPlanet(String planet) {
		SpaceArmy.location = planet;
		LOG.log(Level.INFO, "You travelled through hyperspeed and arrived at the planet " + planet + ".");
	}

	public void allUnitsRun() {
		leader.run();
		for (int i = 0; i < this.units.size(); i++) {
			units.get(i).run();
		}
	}

	public void addUnit(Unit unitToAdd) {
		this.units.insert(unitToAdd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(leader, name, units);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpaceArmy other = (SpaceArmy) obj;
		return Objects.equals(leader, other.leader) && Objects.equals(name, other.name)
				&& Objects.equals(units, other.units);
	}

	@Override
	public String toString() {
		return "SpaceArmy [leader=" + leader + ", units=" + units + ", name=" + name + "]";
	}

	public String getLocation() {
		return location;
	}

}
