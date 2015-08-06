package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import engine.factories.EnhancementFactory;
import engine.factories.ShipFactory;
import gameobjects.Galaxy;
import interfaces.CommandManager;
import interfaces.GameEngine;
import interfaces.Starship;

public class DefaultGameEngine implements GameEngine {

	private ShipFactory shipFactory;
	private EnhancementFactory enhancementFactory;
	private List<Starship> starships;
	private Galaxy galaxy;
	private CommandManager commandManager;
	private boolean running;

	public DefaultGameEngine(CommandManager commandManager, Galaxy galaxy) {
		this.setCommandmanager(commandManager);
		this.setGalaxy(galaxy);
		this.setShipFactory(new ShipFactory());
		this.setEnahncementFactory(new EnhancementFactory());
		this.setStarships(new ArrayList<Starship>());
	}

	@Override
	public ShipFactory getShipFactory() {
		return this.shipFactory;
	}

	private void setShipFactory(ShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}

	@Override
	public EnhancementFactory getEnhancementFactory() {
		return this.enhancementFactory;
	}

	private void setEnahncementFactory(EnhancementFactory enhancementFactory) {
		this.enhancementFactory = enhancementFactory;
	}

	@Override
	public List<Starship> getStarships() {
		return this.starships;
	}

	private void setStarships(List<Starship> starships) {
		this.starships = starships;
	}

	@Override
	public Galaxy getGalaxy() {
		return this.galaxy;
	}

	private void setGalaxy(Galaxy galaxy) {
		this.galaxy = galaxy;
	}

	@Override
	public CommandManager getCommandManager() {
		return this.commandManager;
	}

	private void setCommandmanager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	@Override
	public boolean getRunning() {
		return this.running;
	}

	@Override
	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		this.setRunning(true);
		this.commandManager.setEngine(this);
		this.commandManager.seedCommands();

		Scanner in = new Scanner(System.in);
		do {
			String command = in.nextLine();
			try {
				this.commandManager.processCommand(command);
			} catch (Exception e) {
				System.out.println(e);
			}

		} while (this.getRunning());

	}

}
