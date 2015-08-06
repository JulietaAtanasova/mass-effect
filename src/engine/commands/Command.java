package engine.commands;

import java.util.Optional;

import engine.Messages;
import interfaces.GameEngine;
import interfaces.Starship;

public class Command {
	private GameEngine gameEngine;

	public Command(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	public GameEngine getGameEngine() {
		return gameEngine;
	}

	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	public void Execute(String[] commandArgs) {
	}

	protected boolean isShipInStarSystem(String shipName) {
		Optional<Starship> ship = this.getGameEngine().getStarships().stream().filter(s -> s.getName().equals(shipName))
				.findFirst();
		if (ship.isPresent()) {
			return true;
		}
		return false;
	}

	protected Starship getStarshipByName(String shipName) {
		Starship ship = this.getGameEngine().getStarships().stream().filter(s -> s.getName().equals(shipName))
				.findFirst().get();
		return ship;
	}
	
	protected boolean isShipDestroyed(Starship ship){
		if (ship.getHealth() == 0) {
			System.out.println(Messages.SHIP_ALREADY_DESTROYED);
			return true;
		}
		return false;
	}
}
