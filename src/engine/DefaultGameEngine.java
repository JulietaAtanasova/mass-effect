package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import engine.factories.EnhancementFactory;
import engine.factories.ShipFactory;
import exceptions.ShipException;
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
	private boolean isRunning;

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

	private void setShipFactory(ShipFactory shipFactory){
		this.shipFactory = shipFactory;
	}
	
	@Override
	public EnhancementFactory getEnhancementFactory() {
		return this.enhancementFactory;
	}

	private void setEnahncementFactory(EnhancementFactory enhancementFactory){
		this.enhancementFactory = enhancementFactory;
	}
	
	@Override
	public List<Starship> getStarships() {
		return this.starships;
	}
	
	private void setStarships(List<Starship> starships){
		this.starships = starships;
	}

	@Override
	public Galaxy getGalaxy() {
		return this.galaxy;
	}

	private void setGalaxy(Galaxy galaxy){
		this.galaxy = galaxy;
	}
	
	@Override
	public CommandManager getCommandManager() {
		return this.commandManager;
	}
	
	private void setCommandmanager(CommandManager commandManager){
		this.commandManager = commandManager;
	}

	@Override
	public boolean getIsRunning() {
		return this.isRunning;
	}

	@Override
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		this.setIsRunning(true);
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

		} while (this.getIsRunning());

	}

}
