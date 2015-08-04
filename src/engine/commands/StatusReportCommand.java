package engine.commands;

import gameobjects.enhancements.Enhancement;
import gameobjects.ships.DefaultStarship;
import interfaces.GameEngine;
import interfaces.Starship;

public class StatusReportCommand extends Command{

	public StatusReportCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);
		String shipName = commandArgs[1];
		DefaultStarship ship = (DefaultStarship) this.getGameEngine().getStarships().stream().filter(s -> s.getName().equals(shipName)).findFirst().get();
		
		StringBuilder statusReport = formatShipStatus(ship);
		System.out.println(statusReport);

	}
	
	private StringBuilder formatShipStatus(DefaultStarship ship){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("--%s - %s\n", ship.getName(), ship.getType()));
		sb.append(String.format("-Location: %s\n", ship.getLocation().getName()));
		sb.append(String.format("-Health: %s\n", ship.getHealth()));
		sb.append(String.format("-Shields: %s\n", ship.getHealth()));
		sb.append(String.format("-Damage: %s\n", ship.getDamage()));
		sb.append(String.format("-Fuel: %s\n", ship.getFuel()));
		String enhancements = "N/A";
		
		if(ship.getEnhancements().size() > 0){
			enhancements = "";
			for (Enhancement e : ship.getEnhancements()) {
				enhancements += e.getName() + ", ";
			}
			enhancements = enhancements.substring(0, enhancements.length() - 2);
		}
		sb.append(String.format("-Enhancements: %s", enhancements));
		return sb;
	}
}
