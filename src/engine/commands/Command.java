package engine.commands;

import interfaces.GameEngine;

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
	
}
