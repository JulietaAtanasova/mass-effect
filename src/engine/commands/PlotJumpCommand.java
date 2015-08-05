package engine.commands;

import engine.Messages;
import exceptions.InsufficientFuelException;
import exceptions.LocationOutOfRangeException;
import gameobjects.locations.StarSystem;
import interfaces.GameEngine;
import interfaces.Starship;

public class PlotJumpCommand extends Command {

	public PlotJumpCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);

		String shipName = commandArgs[1];
		String starName = commandArgs[2];

		Starship ship = this.getGameEngine().getStarships().stream().filter(s -> s.getName().equals(shipName))
				.findFirst().get();
		StarSystem starSystem = this.getGameEngine().getGalaxy().getStarSystemByName(starName);
		
		if(ship.getLocation().getName().equals(starSystem.getName())){
			System.out.println(String.format(Messages.SHIP_ALREADY_IN_STAR_SYSTEM, ship.getLocation().getName()));
			return;
		}
		
		try {
			this.getGameEngine().getGalaxy().TravelTo(ship, starSystem);
		} catch (LocationOutOfRangeException | InsufficientFuelException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(String.format(Messages.SHIP_TRAVELLED, ship.getName(), ship.getLocation().getName(),
				starSystem.getName()));
	}

}
