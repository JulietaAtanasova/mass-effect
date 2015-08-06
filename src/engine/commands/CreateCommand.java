package engine.commands;

import engine.Messages;
import engine.factories.EnhancementFactory;
import engine.factories.ShipFactory;
import gameobjects.enhancements.Enhancement;
import gameobjects.enhancements.EnhancementType;
import gameobjects.locations.StarSystem;
import gameobjects.ships.DefaultStarship;
import gameobjects.ships.StarshipType;
import interfaces.GameEngine;

public class CreateCommand extends Command {

	public CreateCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);
		String shipType = commandArgs[1];
		String shipName = commandArgs[2];
		StarSystem starSystem = this.getGameEngine().getGalaxy().getStarSystemByName(commandArgs[3]);

		if (super.isShipInStarSystem(shipName)) {
			System.out.println(Messages.DUPLICATE_SHIP_NAME);
			return;
		}

		ShipFactory shipFactory = new ShipFactory();
		DefaultStarship newShip = (DefaultStarship) shipFactory.create(StarshipType.valueOf(shipType), shipName,
				starSystem);

		EnhancementFactory enhancementFactory = new EnhancementFactory();
		for (int i = 0; i < commandArgs.length - 4; i++) {
			Enhancement enhancement = enhancementFactory.create(EnhancementType.valueOf(commandArgs[4 + i]));
			newShip.addEnhancement(enhancement);
		}

		this.getGameEngine().getStarships().add(newShip);
		System.out.printf(Messages.CREATED_SHIP, shipType, newShip.getName());
		System.out.println();

	}

}
