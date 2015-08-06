package engine.commands;

import interfaces.GameEngine;

public class OverCommand extends Command {

	public OverCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);
		this.getGameEngine().setRunning(false);
	}

}
