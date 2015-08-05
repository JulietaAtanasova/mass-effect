package engine.commands;

import java.util.Optional;

import interfaces.GameEngine;
import interfaces.Starship;

public class Command {
	private GameEngine gameEngine;
	
	public Command(GameEngine gameEngine){
		this.gameEngine = gameEngine;
	}

	public GameEngine getGameEngine() {
		return gameEngine;
	}
	
	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
	
	public void Execute(String[] commandArgs){
		
	}
	
	protected boolean isShipInStarSystem(String shipName){
		Optional<Starship> ship = this.getGameEngine().getStarships().stream()
				.filter(s -> s.getName().equals(shipName)).findFirst();
		if(ship.isPresent()){
			return true;
		}
		return false;
	}
	
	protected Starship getStarshipByName(String shipName){
		Starship ship = this.getGameEngine().getStarships().stream().filter(s -> s.getName().equals(shipName))
				.findFirst().get();
		return ship;
	}
}
