package interfaces;

import java.util.List;

import engine.factories.EnhancementFactory;
import engine.factories.ShipFactory;
import exceptions.ShipException;
import gameobjects.Galaxy;

public interface GameEngine {
	ShipFactory getShipFactory();

	EnhancementFactory getEnhancementFactory();

	List<Starship> getStarships();

	Galaxy getGalaxy();

	CommandManager getCommandManager();

	boolean getIsRunning();

	void setIsRunning(boolean isRunning);

	void run();
}
