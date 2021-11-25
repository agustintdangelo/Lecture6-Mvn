package com.solvd.javacourse.runner;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.javacourse.exception.DeadUnitException;
import com.solvd.javacourse.exception.HealthNegativeException;
import com.solvd.javacourse.exception.WrongNameException;
import com.solvd.javacourse.generic.GenericCustomLinkedList;
import com.solvd.javacourse.robot.C3PO;
import com.solvd.javacourse.robot.R2D2;
import com.solvd.javacourse.robot.Robot;
import com.solvd.javacourse.spaceArmy.Alliance;
import com.solvd.javacourse.spaceArmy.Empire;
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
	private static Map<Integer, String> planets = new TreeMap<>();
	private static Queue<String> famousQuotes = new LinkedList<>();

	public static void main(String[] args) throws DeadUnitException, HealthNegativeException, WrongNameException {
		planets.put(1, "Tatooine");
		planets.put(2, "Endor");
		planets.put(3, "Hoth");
		planets.put(4, "Corruscant");

		Unit soldierE1 = new Stormtrooper(1);
		Unit soldierE2 = new StormCommando(2);
		Unit soldierE3 = new DemolitionTrooper(3);
//		List<Unit> unitsE = new ArrayList<>();
		GenericCustomLinkedList<Unit> unitsE = new GenericCustomLinkedList<Unit>();
		unitsE.insert(soldierE1);
		unitsE.insert(soldierE2);
		unitsE.insert(soldierE3);

		Leader darthVader = new Leader("Darth Vader", 400, 0, "Empire");

		Empire empire = new Empire(darthVader, unitsE, planets.get(1));

		Unit soldierR1 = new RebelTrooper(1);
		Unit soldierR2 = new RebelCommando(2);
		Unit soldierR3 = new DemolitionRebel(3);
		GenericCustomLinkedList<Unit> unitsR = new GenericCustomLinkedList<Unit>();
		Leader lukeSkywalker = new Leader("Luke Skywalker", 600, 0, "Alliance");

		unitsR.insert(soldierR1);
		unitsR.insert(soldierR2);
		unitsR.insert(soldierR3);

		Alliance alliance = new Alliance(lukeSkywalker, unitsR, planets.get(1));

		LOG.log(Level.INFO,"The empire: "+empire);
		LOG.log(Level.INFO,"The alliance: "+alliance);

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

//		alliance.attackEnemyUnitsWithUnits(empire);
//		empire.travelToAnotherPlanet("Death Star");
//		alliance.allUnitsRun();
//		Unit soldierE4 = new Stormtrooper(4);
//		empire.addUnit(soldierE4);
//
//		lukeSkywalker.attack(soldierE3);
//		lukeSkywalker.forceAttack(darthVader);
//	
//		LOG.log(Level.INFO,lukeSkywalker.equals(darthVader));//use of equals		
//		LOG.log(Level.INFO,lukeSkywalker.hashCode());//use of hashcode
//		
//		soldierE1.staminaRecover(-5);
//		soldierE3.healthRecover(5);
//		soldierE3.healthRecover(-5);
//		Leader EmperorPalpatine = new Leader("", 400, 0, "Empire");

		LOG.log(Level.INFO,"---------MAP---------");
		empire.addVehicle("AT-AT", 4);
		empire.addVehicle("Tie Fighter", 20);
		empire.printVehicles();
		LOG.log(Level.INFO,"---------------------");
		alliance.addVehicle("Millenium Falcon", 1);
		alliance.addVehicle("X-Wing Fighter", 25);
		alliance.deleteVehicle("X-Wing Fighter");
		alliance.printVehicles();
		LOG.log(Level.INFO,"---------------------");
		LOG.log(Level.INFO,"Planets: ");
		for (Map.Entry<Integer, String> entry : planets.entrySet()) {
			LOG.log(Level.INFO,entry.getKey() + ":" + entry.getValue().toString());
		}

		LOG.log(Level.INFO,"---------SET---------");
		Robot c3po = new C3PO();
		Robot r2d2 = new R2D2();
		alliance.addRobot(r2d2);
		alliance.addRobot(c3po);
		alliance.deleteRobot(r2d2);
		alliance.printRobots();

		LOG.log(Level.INFO,"---------CUSTOM LINKED LIST---------");
		empire.printUnits();
		empire.deleteUnit(1);
		empire.printUnits();
		LOG.log(Level.INFO,"-------------------------------------------------------------------------------------");
		LOG.log(Level.INFO,"----------- THE FOLLOWING METHODS WERE ADAPTED TO THE CUSTOM LINKED LIST.------------");
		LOG.log(Level.INFO,"-------------------------------------------------------------------------------------");
		empire.attackEnemyUnitsWithUnits(alliance);
		empire.allUnitsRun();

		LOG.log(Level.INFO,"---------QUEUE---------");
		famousQuotes.add("It's a trap!");
		famousQuotes.add("May the force be with you.");
		famousQuotes.add("No. I am your father.");
		famousQuotes.add("Just for once, let me look on you with my own eyes.");
		famousQuotes.add("Power! Unlimited power!");
		LOG.log(Level.INFO,"Famous quotes: " + famousQuotes);
		LOG.log(Level.INFO,"Is empty?: " + famousQuotes.isEmpty());
		LOG.log(Level.INFO,"Peek: " + famousQuotes.peek());
		famousQuotes.remove();
	}
}
