package engine.commands;

import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
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
		DefaultStarship ship = (DefaultStarship) super.getStarshipByName(shipName);
		System.out.println(ship);
	}

}
