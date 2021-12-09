package com.solvd.javacourse.runner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.enums.EnumLeaders;
import com.solvd.javacourse.enums.Planets;
import com.solvd.javacourse.enums.Side;
import com.solvd.javacourse.enums.SpaceArmyEnums;
import com.solvd.javacourse.enums.SpaceShip;
import com.solvd.javacourse.exception.DeadUnitException;
import com.solvd.javacourse.exception.HealthNegativeException;
import com.solvd.javacourse.exception.WrongNameException;
import com.solvd.javacourse.generic.GenericCustomLinkedList;
import com.solvd.javacourse.robot.C3PO;
import com.solvd.javacourse.robot.R2D2;
import com.solvd.javacourse.robot.Robot;
import com.solvd.javacourse.spaceArmy.SpaceArmy;
import com.solvd.javacourse.unit.DemolitionRebel;
import com.solvd.javacourse.unit.DemolitionTrooper;
import com.solvd.javacourse.unit.Leader;
import com.solvd.javacourse.unit.RebelCommando;
import com.solvd.javacourse.unit.RebelTrooper;
import com.solvd.javacourse.unit.StormCommando;
import com.solvd.javacourse.unit.Stormtrooper;
import com.solvd.javacourse.unit.Unit;

public class Runner {
	private final static Logger LOG = Logger.getLogger(Runner.class.getName());
	private static Queue<String> famousQuotes = new LinkedList<>();

	public static void main(String[] args) throws DeadUnitException, HealthNegativeException, WrongNameException {

		Unit soldierE1 = new Stormtrooper(1, Side.EMPIRE);
		Unit soldierE2 = new StormCommando(2, Side.EMPIRE);
		Unit soldierE3 = new DemolitionTrooper(3, Side.EMPIRE);
//		List<Unit> unitsE = new ArrayList<>();
		GenericCustomLinkedList<Unit> unitsE = new GenericCustomLinkedList<Unit>();
		unitsE.insert(soldierE1);
		unitsE.insert(soldierE2);
		unitsE.insert(soldierE3);

		Leader darthVader = new Leader(EnumLeaders.DARTH_VADER, 400, 0, Side.EMPIRE);

		SpaceArmy empire = new SpaceArmy(SpaceArmyEnums.EMPIRE, darthVader, unitsE, Planets.HOTH);

		Unit soldierR1 = new RebelTrooper(1, Side.ALLIANCE);
		Unit soldierR2 = new RebelCommando(2, Side.ALLIANCE);
		Unit soldierR3 = new DemolitionRebel(3, Side.ALLIANCE);
		GenericCustomLinkedList<Unit> unitsR = new GenericCustomLinkedList<Unit>();
		Leader lukeSkywalker = new Leader(EnumLeaders.LUKE_SKYWALKER, 600, 0, Side.ALLIANCE);

		unitsR.insert(soldierR1);
		unitsR.insert(soldierR2);
		unitsR.insert(soldierR3);

		SpaceArmy alliance = new SpaceArmy(SpaceArmyEnums.ALLIANCE, lukeSkywalker, unitsR, Planets.CORRUSCANT);
		LOG.log(Level.INFO, "The empire: " + empire);
		LOG.log(Level.INFO, "The alliance: " + alliance);

		LOG.log(Level.INFO,
				"      ________________.  ___     .______\r\n" + "     /                | /   \\    |   _  \\\r\n"
						+ "    |   (-----|  |----`/  ^  \\   |  |_)  |\r\n"
						+ "     \\   \\    |  |    /  /_\\  \\  |      /\r\n"
						+ ".-----)   |   |  |   /  _____  \\ |  |\\  \\-------.\r\n"
						+ "|________/    |__|  /__/     \\__\\| _| `.________|\r\n"
						+ " ____    __    ____  ___     .______    ________.\r\n"
						+ " \\   \\  /  \\  /   / /   \\    |   _  \\  /        |\r\n"
						+ "  \\   \\/    \\/   / /  ^  \\   |  |_)  ||   (-----`\r\n"
						+ "   \\            / /  /_\\  \\  |      /  \\   \\\r\n"
						+ "    \\    /\\    / /  _____  \\ |  |\\  \\---)   |\r\n"
						+ "     \\__/  \\__/ /__/     \\__\\|__| `._______/");

		LOG.log(Level.INFO, "---------MAP---------");

		empire.addVehicle(SpaceShip.AT_AT, 4);
		empire.addVehicle(SpaceShip.TIE_FIGHTER, 20);
		empire.addVehicle(SpaceShip.AT_ST, 15);
		empire.printVehicles();
		LOG.log(Level.INFO, "---------------------");
		alliance.addVehicle(SpaceShip.MILLENIUM_FALCON, 1);
		alliance.addVehicle(SpaceShip.X_WING, 25);
		alliance.printVehicles();
		empire.vehicleWhichHasMaxQuantity();

		// -----------SET------------
		Robot c3po = new C3PO();
		Robot r2d2 = new R2D2();
		alliance.addRobot(r2d2);
		alliance.addRobot(c3po);

		LOG.log(Level.INFO, "Robots array: " + Arrays.toString(alliance.robotsFromSetToArray()));

		// ---------QUEUE---------
		famousQuotes.add("It's a trap!");
		famousQuotes.add("May the force be with you.");
		famousQuotes.add("No. I am your father.");
		famousQuotes.add("Just for once, let me look on you with my own eyes.");
		famousQuotes.add("Power! Unlimited power!");

		// STREAMS
		LOG.log(Level.INFO, "---------STREAMS---------");

		long numberOfQuotes = famousQuotes.stream().count();
		LOG.log(Level.INFO, "The number of quotes is: " + numberOfQuotes);
		LOG.log(Level.INFO, famousQuotes.stream().findFirst().get());
		famousQuotes.stream().filter(str -> str.length() < 25).forEach(str -> LOG.log(Level.INFO, str));

		// enums
		LOG.log(Level.INFO, "---------ENUMS---------");

		LOG.log(Level.INFO, darthVader.getSide().getGoodOrEvil());
		LOG.log(Level.INFO, "The location of the empire is: " + empire.getLocation());
		LOG.log(Level.INFO, darthVader.getLeader().printPhrase());

		// LAMBDAS
		LOG.log(Level.INFO, "---------LAMBDAS---------");

		// use of lambda function distanceBetweenPlanetHome
		int distance = empire.getLocation().distanceBetweenPlanetHome(Planets.ENDOR.getKm());
		LOG.log(Level.INFO, "The distance between the planet " + empire.getLocation() + " from " + Planets.ENDOR
				+ " is " + distance + " km.");

		// use of lambda as a getter
		Function<Unit, Integer> getStamina = Unit::getStamina;
		LOG.log(Level.INFO, "The stamina of the unit is: " + getStamina.apply(soldierR2));

		soldierR1.attack(soldierE2);
		for (int i = 0; i < unitsE.size(); i++) {
			SpaceArmy.healUnits(empire.getUnits().get(i), unit -> unit.getHealth() < unit.getMaxHealth());
		}

		SpaceArmy.modifyUnit(lukeSkywalker, unit -> unit.setUnitId(5));

		SpaceArmy.modifyTwoUnits(lukeSkywalker, darthVader, (unit1, unit2) -> {
			unit1.setStamina(500);
			unit2.setHealth(400);
		});

		for (int i = 0; i < unitsE.size(); i++) {
			SpaceArmy.getUnitIf(unitsE.get(i), unit -> {
				if (SpaceArmy.isTrue(unit, unit_ -> unit_.getUnitId() == 2))
					return unit;
				return null;
			});
		}

		SpaceArmy.modifyRobot(r2d2, robot -> alliance.getRobots().remove(r2d2));

		LOG.log(Level.INFO, "The total is: " + SpaceArmy.getTotalIntegersOf3Units(soldierR2, soldierR3, lukeSkywalker,
				(unit1, unit2, unit3) -> unit1.getHealth() + unit2.getHealth() + unit3.getHealth()));

	}
}
