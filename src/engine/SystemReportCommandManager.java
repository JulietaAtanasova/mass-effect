package engine;

import engine.commands.SystemReportCommand;

public class SystemReportCommandManager extends DefaultCommandManager {

	@Override
	public void seedCommands() {
		super.seedCommands();
		commandsByName.put("system-report", new SystemReportCommand(this.getEngine()));
	}
}
