package engine.commands;

import gameobjects.ships.DefaultStarship;
import interfaces.GameEngine;

public class StatusReportCommand extends Command {

	public StatusReportCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);
		String shipName = commandArgs[1];
		DefaultStarship ship = (DefaultStarship) getStarshipByName(shipName);
		System.out.println(ship);
	}

}
