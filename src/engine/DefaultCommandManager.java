package engine;

import java.util.HashMap;

import engine.commands.AttackCommand;
import engine.commands.Command;
import engine.commands.CreateCommand;
import engine.commands.OverCommand;
import engine.commands.PlotJumpCommand;
import engine.commands.StatusReportCommand;
import interfaces.*;

public class DefaultCommandManager implements CommandManager {
	protected final HashMap<String, Command> commandsByName;
	private GameEngine engine;

	public DefaultCommandManager() {
		this.commandsByName = new HashMap<String, Command>();
	}

	@Override
	public GameEngine getEngine() {
		return this.engine;
	}

	@Override
	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}

	@Override
	public void processCommand(String commandSrting) {
		String[] commandArgs = commandSrting.split(" ");
		String commandName = commandArgs[0];

		if (!this.commandsByName.containsKey(commandName)) {
			throw new UnsupportedOperationException(String.format("Command %s does not exist.", commandName));
		}

		Command command = this.commandsByName.get(commandName);
		command.Execute(commandArgs);
	}

	@Override
	public void seedCommands() {
		this.commandsByName.put("create", new CreateCommand(this.getEngine()));
		this.commandsByName.put("attack", new AttackCommand(this.getEngine()));
		this.commandsByName.put("status-report", new StatusReportCommand(this.getEngine()));
		this.commandsByName.put("plot-jump", new PlotJumpCommand(this.getEngine()));
		this.commandsByName.put("over", new OverCommand(this.getEngine()));
	}
}
