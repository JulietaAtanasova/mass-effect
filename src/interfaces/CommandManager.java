package interfaces;

public interface CommandManager {
	GameEngine getEngine();

	void setEngine(GameEngine engine);

	void processCommand(String command);

	void seedCommands();
}
