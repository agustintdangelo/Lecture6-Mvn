package com.solvd.javacourse.spaceArmy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.solvd.javacourse.enums.Planets;
import com.solvd.javacourse.enums.SpaceArmyEnums;
import com.solvd.javacourse.enums.SpaceShip;
import com.solvd.javacourse.generic.GenericCustomLinkedList;
import com.solvd.javacourse.lambda.TriConsumer;
import com.solvd.javacourse.lambda.TriFunction;
import com.solvd.javacourse.lambda.UnitFinder;
import com.solvd.javacourse.robot.Robot;
import com.solvd.javacourse.unit.Leader;
import com.solvd.javacourse.unit.Unit;

public class SpaceArmy {
	protected Leader leader;
	private GenericCustomLinkedList<Unit> units = new GenericCustomLinkedList<Unit>();
	private SpaceArmyEnums side;
	private Planets location;
	private Map<SpaceShip, Integer> vehicles = new HashMap<>();
	private Set<Robot> robots = new HashSet<Robot>();

	private final static Logger LOG = Logger.getLogger(SpaceArmy.class.getName());

	public SpaceArmy(SpaceArmyEnums side, Leader leader, GenericCustomLinkedList<Unit> units2, Planets location) {
		this.side = side;
		this.leader = leader;
		this.setUnits(units2);
		this.location = location;
	}

	// STREAMS

	public <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
		return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}

	public void vehicleWhichHasMaxQuantity() {
		LOG.log(Level.INFO, "The vehicle which has the most units is: "
				+ this.getKeysByValue(vehicles, vehicles.values().stream().max(Integer::compare).get()));
	}

	public Integer numberOfVehicles() {
		return vehicles.values().stream().mapToInt(i -> i).sum();
	}

	public Object[] robotsFromSetToArray() {
		return robots.stream().toArray();
	}

	// LAMBDAS

	public static Integer getTotalIntegersOf3Units(Unit unit1, Unit unit2, Unit unit3,
			TriFunction<Unit, Unit, Unit> function) {
		return function.apply(unit1, unit2, unit3);
	}

	public static void modifyTwoUnitsAndOneRobot(Unit unit1, Unit unit2, Robot robot,
			TriConsumer<Unit, Unit, Robot> modifier) {
		modifier.accept(unit1, unit2, robot);
		LOG.log(Level.INFO, "All units and robot were modified successfully.");
	}

	public static void modifyRobot(Robot robot, Consumer<Robot> modifier) {
		modifier.accept(robot);
		LOG.log(Level.INFO, "Robot was modified successfully.");
	}

	public static void modifyTwoUnits(Unit unit, Unit unit2, BiConsumer<Unit, Unit> modifier) {
		modifier.accept(unit, unit2);
		LOG.log(Level.INFO, "Units were modified successfully.");
	}

	public static void modifyUnit(Unit unit, Consumer<Unit> modifier) {
		modifier.accept(unit);
		LOG.log(Level.INFO, "Unit was modified succesfully.");
	}

	public static boolean isTrue(Unit unit, Predicate<Unit> verifier) {
		return verifier.test(unit);
	}

	public static void getUnitIf(Unit unit, UnitFinder unitFinder) {
		Unit deadFound = unitFinder.find(unit);
		if (deadFound != null) {
			LOG.log(Level.INFO, "The unit found is: " + deadFound);
		}
	}

	public static void healUnits(Unit unit, Predicate<Unit> healthRecovery) {
		boolean isHealed = healthRecovery.test(unit);
		if (!isHealed) {
			unit.setHealth(unit.getMaxHealth());
		}
		LOG.log(Level.INFO, "Unit was healed succesfully: " + isHealed);
	}

	public Leader getLeader() {
		return leader;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}

	public SpaceArmyEnums getSide() {
		return side;
	}

	public Map<SpaceShip, Integer> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Map<SpaceShip, Integer> vehicles) {
		this.vehicles = vehicles;
	}

	public Set<Robot> getRobots() {
		return robots;
	}

	public void setRobots(Set<Robot> robots) {
		this.robots = robots;
	}

	public void setLocation(Planets location) {
		this.location = location;
	}

	public void deleteUnit(int unitId) {
		int i = 0;
		while (i < this.getUnits().size() && getUnits().get(i).getUnitId() != unitId) {
			i++;
		}
		getUnits().deleteAt(i);
	}

	public void printUnits() {
		LOG.log(Level.INFO, this.side + " Units: ");
		this.getUnits().show();
	}

	Consumer<Robot> printLambdaList = (r) -> {
		LOG.log(Level.INFO, ("Robot: " + r));
	};

	public void printRobots() {
		LOG.log(Level.INFO, this.side + " Robots: ");
		robots.forEach(printLambdaList);
	}

	public void addRobot(Robot robot) {
		robots.add(robot);
	}

	public void deleteRobot(Robot robot) {
		robots.remove(robot);
	}

	public void addVehicle(SpaceShip name, Integer quantity) {
		if (vehicles.containsKey(name)) {
			vehicles.put(name, quantity + vehicles.get(name));
		} else {
			vehicles.put(name, quantity);
		}
	}

	public void deleteVehicle(SpaceShip name) {
		vehicles.remove(name);
	}

	BiConsumer<? super SpaceShip, ? super Integer> printLambdaMap = (s, i) -> {
		LOG.log(Level.INFO, (s + ": " + i));
	};

	public void printVehicles() {
		LOG.log(Level.INFO, this.side + " Vehicles and it's quantities: ");
		vehicles.forEach(printLambdaMap);
	}

	public void attackEnemyLeaderWithUnits(SpaceArmy enemySpaceArmy) {
		for (int i = 0; i < this.getUnits().size(); i++) {
			getUnits().get(i).attack(enemySpaceArmy.leader);
		}
	}

	public int sizeUnits() {
		return getUnits().size();
	}

	public void attackEnemyUnitsWithUnits(SpaceArmy enemySpaceArmy) {
		for (int i = 0; i < this.getUnits().size(); i++) {
			for (int j = 0; j < enemySpaceArmy.getUnits().size(); j++) {
				getUnits().get(i).attack(enemySpaceArmy.getUnits().get(j));
			}
		}
	}

	public void travelToAnotherPlanet(Planets planet) {
		this.location = planet;
		LOG.log(Level.INFO, "You travelled through hyperspeed and arrived at the planet " + planet + ".");
	}

	public void allUnitsRun() {
		leader.run();
		for (int i = 0; i < this.getUnits().size(); i++) {
			getUnits().get(i).run();
		}
	}

	public void addUnit(Unit unitToAdd) {
		this.getUnits().insert(unitToAdd);
	}

	@Override
	public int hashCode() {
		return Objects.hash(leader, location, printLambdaList, printLambdaMap, robots, side, getUnits(), vehicles);
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
		return Objects.equals(leader, other.leader) && location == other.location
				&& Objects.equals(printLambdaList, other.printLambdaList)
				&& Objects.equals(printLambdaMap, other.printLambdaMap) && Objects.equals(robots, other.robots)
				&& side == other.side && Objects.equals(getUnits(), other.getUnits())
				&& Objects.equals(vehicles, other.vehicles);
	}

	@Override
	public String toString() {
		return "SpaceArmy [side=" + side + "leader=" + leader + ", units=" + getUnits() + "]";
	}

	public Planets getLocation() {
		return location;
	}

	public GenericCustomLinkedList<Unit> getUnits() {
		return units;
	}

	public void setUnits(GenericCustomLinkedList<Unit> units) {
		this.units = units;
	}

}
